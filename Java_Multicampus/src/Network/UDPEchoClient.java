package Network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPEchoClient {
	public static void main(String[] args) {
		InetAddress address = null;
		// 서버의 IP 주소를 지정하여 InetAddress객체를 생성함
		try {
			address = InetAddress.getByName("127.0.0.1");
		} catch (UnknownHostException e) {
			System.out.println("잘못된 Domain이거나 IP 주소입니다.");
			System.exit(0);
		}
		
		DatagramSocket socket = null;
		try {
			// 키보드로부터 메시지를 읽기위한 입력 스트림을 생성함
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			socket = new DatagramSocket();
			
			// 키보드로 입력한 메시지를 라인 단위로 읽어 들여서 DatagramPacket 객체를 생성하고, 생성된 객체를 서버로 전송함
			String line = null;
			while((line = br.readLine()) != null) {
				DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length, address, 50001);
				socket.send(sendPacket);
				// 읽은 메시지가 quit면 프로그램을 종료함
				if(line.equals("quit"))
					break;
				
				// 서버로부터 전송된 DatagramPacket으로부터 메시지를 추출하여 클라이언트 콘솔 창에 출력함
				byte[] buff = new byte[line.getBytes().length];
				DatagramPacket receivePacket = new DatagramPacket(buff, buff.length);
				socket.receive(receivePacket);
				
				String message = new String(receivePacket.getData(), 0, receivePacket.getData().length);
				System.out.println("전송받은 문자열 : " + message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(socket != null) {
				socket.close();
			}
		}
	}
}