package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// Server Program, Javafx로 UI구현
public class Exam04_ChatServer extends Application{
	// 필요한 field 선언
	private TextArea ta;
	private Button startBtn, stopBtn;
	// Thread Pool 생성 
	// 제한된 숫자의 Thread를 가지고 있는 pool이 아니라 필요한 개수만큼 Thread를 가지고 있는 Thread Pool을 생성
	private ExecutorService es = Executors.newCachedThreadPool();
	
	// Server Network Program이므로 ServerSocket 선언
	private ServerSocket server;
	
	// 공용객체를 하나 생성
	// 공용객체는 Thread에 의해서 공유되는 객체이며 1개만 존재
	private ChatSharedObject shared = new ChatSharedObject();
	
	// TextArea에 특정 문자열을 출력하기 위한 printMSG() 생성
	private void printMSG(String msg) {
		// Thread를 이용해서 출력
		// Lambda 표현식으로 사용
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 처음 창이 화면에 뜰 때, 화면구성하는 용도
		// 화면을 동서남북중앙으로 구성하는 BorderPane을 이용
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// TextArea를 생성해서 BorderPane의 중앙에 부착
		ta = new TextArea();
		root.setCenter(ta);
		
		// 두 개의 버튼을 각각 생성하여 화면에 부착
		startBtn = new Button("Echo Server Start");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e -> {
			// Event 처리 코드
			printMSG("[Server Start]");
			
			// ServerSocket이 있어야 Server 역할을 수행 가능
			// 별도의 Thread를 생성하여 Server역할을 수행
			// Runnable Interface를 구현한 객체를 생성
			// ExecutorService (Thread Pool)을 이용해서 Thread를 실행
			Runnable runnable = () -> {
				try { 
					server = new ServerSocket(9999);
					while(true) {
						Socket socket = server.accept();
						ChatRunnable chat = new ChatRunnable(socket, shared);
					
						shared.add(chat);
					
						es.execute(chat);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			};
			
			// Thread 실행
			es.execute(runnable);
		});
		
		stopBtn = new Button("Echo Server Stop");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e -> {
			
		});
		
		// Android의 LinearLayout과 유사한 Component
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 40);
		// 위, 아래, 좌, 우에 여백을 생성하는 Code
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		// 가로로 Component가 붙을 때 각 Component 사이의 여백 (Horizontal Gap)
		flowpane.setHgap(10);
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		
		root.setBottom(flowpane);
		
		// 화면 구현이 끝났으니 창을 설정하고 화면에 Show
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multi Echo Server");
		primaryStage.setOnCloseRequest(e -> {
			// x버튼을 눌러 종료시 발생하는 Event
			
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}

class ChatRunnable implements Runnable {
	private Socket socket;
	private ChatSharedObject shared;
	private BufferedReader br;
	private PrintWriter pw;
	
	ChatRunnable(Socket socket, ChatSharedObject shared){
		this.socket = socket;
		this.shared = shared;
		try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.pw = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PrintWriter getPw() {
		return pw;
	}

	@Override
	public void run() {
		// Thread가 Client와 어떻게 동작하는지를 여기에 명시
		String line = "";
		try {
			while((line = br.readLine()) != null) {
				if(line.equals("@EXIT"))
					break;
				// 모든 Client에게 문자열을 전달하기위해 공용객체 활용
				shared.broadcast(line);
//				pw.println(line);
//				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// Thread에 의해서 공유되는 공용객체를 만들기 위한 Class 생성
class ChatSharedObject {
	// Thread에 의해서 공유되어야 하는 Data
	// 모든 Client에 대한 Thread를 만들기 위해 필요한 Runnable객체를 저장
	List<ChatRunnable> clients = new ArrayList<ChatRunnable>();
	
	// Data를 제어하기 위해 필요한 Method
	// 새로운 사용자가 접속했을 때 clients안에 새로운 사용자에 대한 Runnable 객체를 저장
	public void add(ChatRunnable r) {
		clients.add(r);
	}
	
	// 사용자가 접속을 종료했을 때 clients안에 있는 사용자를 삭제
	public void remove(ChatRunnable r) {
		clients.remove(r);
	}
	
	// Client가 Data를 보내줬을 때 Chat Message를 Broadcast하는 method
	public void broadcast(String msg) {
		for(ChatRunnable client : clients) {
			client.getPw().println(msg);
			client.getPw().flush();
		}
	}
}