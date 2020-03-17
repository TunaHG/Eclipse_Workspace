package Network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPEchoClient {
	public static void main(String[] args) {
		try {
			// Socket 생성자에 서버 IP 주소와 포트번호 50000을 매개변수로 넣어 생성
			Socket socket = new Socket("127.0.0.1", 50000);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			// 생성된 Socket으로부터 InputStream과 OutputStream을 구함
			InputStream in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			String message = null;
			
			// 키보드로부터 한 줄 씩 입력받아 PrintWriter에 있는 println() 메소드를 이용해서 서버에게 전송함
			while((message = keyboard.readLine()) != null) {
				if(message.equals("quit"))
					break;
				pw.println(message);
				pw.flush();
				// 서버가 다시 반환하는 문자열을 BufferedReader에 있는 readLine() 메소드를 이용해서 읽어들임
				String echoMessage = br.readLine();
				System.out.println("서버로부터 전달받은 문자열 : " + echoMessage);
			}
			// 키보드로부터 quit 문자열이 입력되면 IO 객체와 소켓의 close() 메소드를 호출하여 연결자원들을 해제함
			br.close();
			pw.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
