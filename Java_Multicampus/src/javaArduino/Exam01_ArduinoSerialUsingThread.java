package javaArduino;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;

public class Exam01_ArduinoSerialUsingThread {

	public static void main(String[] args) {
		// 1. Serial 통신을 하기 위한 COM포트 설정
		CommPortIdentifier portIdentifier = null;
		try {
			// CommPortIdentifier의 static Method를 이용하여 port를 설정 (내부 인자는 실제 컴퓨터와 연결된 포트번호)
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM9");
			
			// 2. 해당 포트가 다른 프로세스에 의해 점유되고 있는지 확인 (포트가 사용되고 있는지 확인)
			if(portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다.");
			} else {
				// Port를 열어서 Port객체를 생성
				// open()의 인자 두 개는 Description이기 때문에 사용자 임의로 지정
				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);
				
				// Port 객체를 얻어온 후 우리가 사용하는건 SerialPort (선이 한개가 연결되어 있는 경우)
				// Port에는 ParallelPort도 존재 (선이 여러개가 연결되어 있는 경우, 5차선으로 데이터를 병렬방식으로 전송)
				// ParallelPort로 연결하면, 입출력단자가 여러 개가 존재해야 한다. (Arduino에도!)
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
