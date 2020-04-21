package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// javaFX를 이용해서 Client UI 구성
public class Exam05_MultiRoomChatClient extends Application {
	// Field 정의
	private String userID;        // 클라이언트 채팅 ID
	private TextArea textarea;    // 채팅창 역할을 하는 TextArea
	private Button connBtn;       // 채팅서버와 연결하기 위한 Button
	private Button disconnBtn;    // 채팅서버와 연결을 종료하기 위한 Button
	private Button createRoomBtn; // 새로운 채팅방을 만드는 Button
	private Button connRoomBtn;   // 채팅방에 입장하는 Button
	private ListView<String> roomListView;         // 채팅방 목록을 보여주는 ListView
	private ListView<String> participantsListView; // 채팅방에서 현재 채팅에 참여하고 있는 사람들을 보여주는 ListView
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private ExecutorService es = Executors.newCachedThreadPool();
	private BorderPane root;
	private FlowPane menuflow;
	
	// TextArea에 내용을 출력하기 위한 method 정의
	private void printMSG(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면을 동, 서, 남, 북, 중앙 5개의 영역으로 분할
		root = new BorderPane();
		// 크기 조절
		root.setPrefSize(700, 500);
		
		// TextArea 생성
		textarea = new TextArea();
		// Editing이 안되게 처리
		textarea.setEditable(false);
		// 화면 중앙에 TextArea 부착
		root.setCenter(textarea);
		
		// 방 목록을 표현하는 ListView를 생성
		roomListView = new ListView<String>();
		// 방안에서 채팅하는 사람들의 목록을 표현하는 ListView를 생성
		participantsListView = new ListView<>();
		
		// 화면을 격자로 나누어서 Component를 표현하는 Layout
		GridPane grid = new GridPane();
		// grid의 padding(여백) 설정
		grid.setPadding(new Insets(10, 10, 10, 10));
		// grid안에 여러 Component가 부착되는데, 이 Component간의 여백을 설정
		grid.setVgap(10);
		grid.add(roomListView, 0, 0);
		grid.add(participantsListView, 0, 1);
		
		// 화면 오른쪽에 grid 부착
		root.setRight(grid);
		
		connBtn = new Button("Chat Server Connect");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {
			// Server 접속 Button을 누르면 사용자 ID부터 받음
			Dialog<String> dialog = new TextInputDialog("자신의 닉네임을 입력하세요.");
			dialog.setTitle("닉네임 설정");
			dialog.setHeaderText("닉네임 설정입니다. 적절한 이름을 입력하세요.");
			
			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if(result.isPresent()) {
				// 닉네임을 입력하고 확인을 누른경우
				entered = result.get();
			}
			
			try {
				socket = new Socket("localhost", 20000);
				textarea.clear();
				printMSG("[System]\tServer Connected");
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				
				ReceiveRunnable r = new ReceiveRunnable(br);
				es.execute(r);
				
				pw.println("@userID " + entered);
				pw.println("@getRooms");
				pw.flush();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			// 원래는 서버에 접속해서 방목록을 받아와야 함
			userID = entered;
			printMSG("[System]\t환영합니다. " + userID + "님");
			
			createRoomBtn.setDisable(false);
			connRoomBtn.setDisable(false);
			disconnBtn.setDisable(false);
		});
		
		disconnBtn = new Button("Disconnect Server");
		disconnBtn.setPrefSize(150, 40);
		disconnBtn.setDisable(true);
		disconnBtn.setOnAction(e -> {
			try {
				roomListView.getItems().clear();
				participantsListView.getItems().clear();
				br.close();
				pw.close();
				socket.close();
				es.shutdownNow();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			disconnBtn.setDisable(true);
			createRoomBtn.setDisable(true);
			connRoomBtn.setDisable(true);
		});
		
		createRoomBtn = new Button("Create Chat Room");
		createRoomBtn.setPrefSize(150, 40);
		createRoomBtn.setDisable(true);
		createRoomBtn.setOnAction(e -> {
			Dialog<String> dialog = new TextInputDialog("생성할 방 이름을 입력하세요.");
			dialog.setTitle("채팅방 생성");
			dialog.setHeaderText("채팅방 생성입니다. 적절한 이름을 입력하세요.");
			
			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if(result.isPresent()) {
				// 방 이름이 입력되면,
				entered = result.get();
			}
			
			// 방 이름이 서버에 전달되어야 함
			try {
				pw = new PrintWriter(socket.getOutputStream());
				pw.println("@createRoom " + entered);
				pw.println("@getRooms");
				pw.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		connRoomBtn = new Button("Connect Chat Room");
		connRoomBtn.setPrefSize(150, 40);
		connRoomBtn.setDisable(true);
		connRoomBtn.setOnAction(e -> {
			// 1. 어떤 방을 선택했는지를 알아옴
			String roomName = roomListView.getSelectionModel().getSelectedItem();
			printMSG("[" + userID + "]\t" + roomName + "에 입장하셨습니다.");
			
			// 서버에 접속해서 현재 방에 참여하고 있는 참여자 목록을 받아옴
			// 목록을 받아오면 참여자 ListView에 출력
			pw.println("@connRoom " + roomName);
			pw.println("@getUsers");
			pw.flush();
			
			// 밑 부분의 메뉴를 채팅을 입력할 수 있는 화면으로 전환
			FlowPane inputFlow = new FlowPane();
			inputFlow.setPadding(new Insets(10, 10, 10, 10));
			inputFlow.setPrefSize(700, 40);
			inputFlow.setHgap(10);
			
			TextField inputTF = new TextField();
			inputTF.setPrefSize(400, 40);
			inputTF.setOnAction(e1 -> {
				String msg = inputTF.getText();
				pw.println(msg);
				pw.flush();
				inputTF.clear();
			});
			
			inputFlow.getChildren().add(inputTF);
			root.setBottom(inputFlow);
			
		});
		
		menuflow = new FlowPane();
		menuflow.setPadding(new Insets(10, 10, 10, 10));
		menuflow.setPrefSize(700, 40);
		menuflow.setHgap(10);
		menuflow.getChildren().add(connBtn);
		menuflow.getChildren().add(disconnBtn);
		menuflow.getChildren().add(createRoomBtn);
		menuflow.getChildren().add(connRoomBtn);
		
		root.setBottom(menuflow);
		
		// 창을 띄우기 위한 Scene
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multi Room Chat Client");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
	
	class ReceiveRunnable implements Runnable {
		private BufferedReader br;
		
		ReceiveRunnable(BufferedReader br) {
			this.br = br;
		}
		
		public void getRooms(String tmp) {
			String[] rooms = tmp.split(" ");
			Platform.runLater(() -> {
				roomListView.getItems().clear();
				for(String room : rooms) {
					if(room.equals("@getRooms"))
						continue;
					roomListView.getItems().add(room);
				}
			});
		}
		
		public void getUsers(String msg) {
			String[] users = msg.split(" ");
			Platform.runLater(() -> {
				participantsListView.getItems().clear();
				for(String user : users) {
					if(user.equals("@getUsers"))
						continue;
					participantsListView.getItems().add(user);
				}
			});
		}
		@Override
		public void run() {
			String msg = "";
			try {
				while(true) {
					msg = br.readLine();
					if(msg == null)
						break;
					if(msg.equals("@EXIT")) {
						Platform.runLater(() -> {
							participantsListView.getItems().clear();
							root.setBottom(menuflow);
						});
						continue;
					}
					if(msg.startsWith("@getRooms")) {
						getRooms(msg);
						continue;
					}
					if(msg.startsWith("@getUsers")) {
						getUsers(msg);
						continue;
					}
					printMSG(msg);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
