package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressLocalTest {

	public static void main(String[] args) {
		InetAddress address = null;
		
		try {
			// 현재 컴퓨터(Local)의 IP에 관련된 정보를 구하기 위해서 InetAddress Class에 있는 getLocalHost()를 사용
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// 로컬 컴퓨터의 이름과 IP 주소를 출력
		System.out.println("<< 로컬 컴퓨터 이름과 IP 주소 >>");
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		
		// byte 배열 형태의 IP 주소를 출력
		System.out.println("<< byte[] 형식의 IP 주소 >>");
		byte[] ip = address.getAddress();
		for (int i = 0; i < ip.length; i++) {
			System.out.print((int) ip[i]);
			if(i != ip.length - 1) {
				System.out.print(".");
			}
		}
	}

}
