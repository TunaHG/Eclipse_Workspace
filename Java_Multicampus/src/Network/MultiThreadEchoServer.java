package Network;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadEchoServer {
	public static void main(String[] args) {
		try {
			// ServerSocket 생성자에 동작포트값을 넣어 객체를 생성함
			ServerSocket server = new ServerSocket(50000);
			System.out.println("클라이언트의 접속을 대기합니다...");
			
			// 클라이언트의 접속을 계속 기다리도록 무한 루프를 돌림
			while(true) {
				// 클라이언트의 접속이 요청되면 accept() 메소드가 실행되어 클라이언트와 통신할 Socket 객체를 생성
				Socket socket = server.accept();
				EchoThread echoThread = new EchoThread(socket);
				echoThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
