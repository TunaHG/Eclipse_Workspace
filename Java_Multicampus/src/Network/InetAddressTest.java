package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressTest {

	public static void main(String[] args) {
		System.out.println("<< IP 주소나 도메인 주소를 입력하세요. >>");
		// 입력 Stream을 생성하고 키보드로부터 도메인명이나 IP주소를 입력받음
		Scanner sc = new Scanner(System.in);
		String address = sc.nextLine();
		
		InetAddress[] addressList = null;
		
		try {
			// 사용자가 입력한 도메인명이나 IP주소를 InetAddress의 getAllByName() 메소드에 전달하면 InetAddress[]가 리턴됨
			addressList = InetAddress.getAllByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		// 배열의 크기만큼 반복하면서
		// 도메인명, IP주소, 도메인정보를 구할 수 있음
		for (int i = 0; i < addressList.length; i++) {
			System.out.println("-----------------------------");
			System.out.println(addressList[i].getHostName());
			System.out.println(addressList[i].getHostAddress());
			System.out.println(addressList[i].toString());
			System.out.println("-----------------------------");
		}
	}

}
