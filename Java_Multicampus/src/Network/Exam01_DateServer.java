package Network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Server Side Programming
// Client가 접속하면 현재 시간을 알아내서
// CLient에게 전송하는 Server Program
public class Exam01_DateServer {
	// Program Entry Point
	public static void main(String[] args) {
		// 1. Server Program이므로 Client의 접속을 대기
		// Client의 Socket 접속을 기다리는 Server Socket 필요
		// 적당한 Port Number를 이용해서 Server Socket 객체 생성
		try {
			ServerSocket server = new ServerSocket(5556);
			System.out.println("Server Created");
			
			// 2. Client의 접속을 대기하기 위한 method 호출
			Socket s = server.accept(); // Blocking method
			// Client가 접속할 때까지 대기 
			// Client가 접속해야 accpet() 다음 코드가 진행된다.
			System.out.println("Client Connect"); 
			
			// 3. Socket이 생성되면 데이터 입출력을 위한 Stream을 생성
			String date = (new Date()).toLocaleString(); // 현재 시간
			PrintWriter out = new PrintWriter(s.getOutputStream());
			out.println(date);
			out.flush();
			out.close();
			s.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
