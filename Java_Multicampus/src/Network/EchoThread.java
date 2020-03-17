package Network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class EchoThread  extends Thread {
	private Socket socket;
	
	public EchoThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			InetAddress address = socket.getInetAddress();
			// 접속을 요청한 클라이언트의 IP주소를 출력
			System.out.println(address.getHostAddress() + " 로부터 접속됨.");
			
			// 생성자를 통해 넘어온 Socket으로부터 Stream을 구함
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
			e.printStackTrace();
		}
	}
}
