package Network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
	public static void main(String[] args) {
		try {
			// ServerSocket 생성자에 서버의 동작포트값 50000을 넣어 생성
			ServerSocket server = new ServerSocket(50000);
			System.out.println("클라이언트의 접속을 대기중...");
			// 클라이언트로부터 연결 요청이 들어오면 accept()가 실행되어
			// 클라이언트와 통신을 담당할 Socket 객체가 생성됨
			Socket socket = server.accept();
			InetAddress address = socket.getInetAddress();
			System.out.println(address.getHostAddress() + " 로부터 접속했습니다.");
			
			// 생성된 Socket으로부터 InputStream과 OutputStream을 구함
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			// Socket으로부터 읽어 들인 메시지를 콘솔에 출력하고 이를 다시 클라이언트로 전송함
			String message = null;
			while((message = br.readLine()) != null) {
				System.out.println("클라이언트로 부터 전송받은 메시지 : " + message);
				pw.println(message);
				pw.flush();
			}
			// 입출력 작업이 종료되면 스트림을 닫음
			br.close();
			pw.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
