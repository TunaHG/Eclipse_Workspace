package Network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			System.out.println("접속 대기상태입니다.");
			// DatagramSocket 생성자에 서버의 포트값 50001을 매개변수로 넣어 생성함
			socket = new DatagramSocket(50001);
			
			// 클라이언트로부터 연결 요청이 들어올 때까지 무한루프를 돌림
			while(true) {
				// 클라이언트의 메시지를 저장할 충분한 크기의 버퍼를 생성하고, 버퍼 크기만큼 데이터를 저장할 DatagramPacket을 생성함
				byte[] buff = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(buff, buff.length);
				// DatagramPacket을 이용하여 클라이언트가 전송한 메시지를 읽어서 콘솔에 출력함
				socket.receive(receivePacket);
				String msg = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("전송받은 문자열 : " + msg);
				// 클라이언트가 전송한 메시지가 "quit"면 반복을 종료함
				if(msg.equals("quit")) {
					break;
				}
				
				// 클라이언트가 전송한 메시지를 다시 DatagramPacket으로 생성하여 클라이언트로 재전송함
				DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getData().length, 
						receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
			}
			System.out.println("UDPEchoServer를 종료합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 통신이 끝나면 DatagramSocket을 닫음
			if(socket != null) {
				socket.close();
			}
		}
	}
}
