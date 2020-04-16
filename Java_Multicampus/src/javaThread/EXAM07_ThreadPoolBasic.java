package javaThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class EXAM07_ThreadPoolBasic extends Application {
	
	private TextArea ta;
	private Button initBtn, startBtn, shutdownBtn;
	
	// Textarea에 문자열을 출력하기 위한 method
	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});
	}
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면을 구성하고 event 처리를 담당
		// 기본 layout을 생성 => BorderPane(동서남북중앙으로 구성)으로 생성.
		BorderPane root = new BorderPane();
		// BorderPane의 size를 설정(px단위로 가로길이와 세로길이를 설정)
		root.setPrefSize(700, 500);
		
		ta = new TextArea();   // 글상자를 생성
		root.setCenter(ta);	  // BorderPane가운데에 TextArea 부착
		
		
		initBtn = new Button("Thread Pool 생성");
		initBtn.setPrefSize(250, 50);
		initBtn.setOnAction(e -> {
			
		});
		
		startBtn = new Button("Thread 생성");
		startBtn.setPrefSize(250, 50);
		startBtn.setOnAction(e -> {
			// Thread Pool에서 Thread를 가져다가 사용하는 코드
			// 10개의 Thread를 THread Pool에서 가져다가 사용
			for(int i = 0; i < 10; i++) {
				// 1. Runnable interface를 구현한 객체 생성
				// 2. Thread Pool을 이용해서 Thread 생성
			}
		});
		
		shutdownBtn = new Button("Thread Pool 종료");
		shutdownBtn.setPrefSize(250, 50);
		shutdownBtn.setOnAction(e -> {
			
		});
	
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(initBtn);  // FlowPane에 Button을 부착
		
		root.setBottom(flowpane);  // 전체 화면의 아래부분에 FlowPane 부착
		
		// Scene(장면) 필요해요!!
		Scene scene = new Scene(root);  // BorderPane을 포함하는 장면생성
		primaryStage.setScene(scene);   // Window의 화면을 Scene으로 설정
		primaryStage.setTitle("예제용 JavaFX");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// 화면에 창을 띄울려고 해요!	
		launch();   // start() method가 호출되요!!

	}

}
