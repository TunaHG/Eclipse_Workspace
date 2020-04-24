package javaArduino;

import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

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
				if(commPort instanceof SerialPort) {
					// SerialPort로 형변환(Type Casting)
					SerialPort serialPort = (SerialPort)commPort;
					// 포트 설정(통신속도 설정)
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					// 데이터 통신을 하기 위해서 Stream을 생성
					// Byte방식으로 통신하기 때문에 기본 Stream을 사용
					InputStream in = serialPort.getInputStream();
					OutputStream out = serialPort.getOutputStream();
					
					// Thread를 이용해서 Arduino로부터 들어오는 데이터를 반복적으로 수신
					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
							byte[] buffer = new byte[1024];
							// Data의 Size를 의미함. -1은 데이터가 없다는 의미
							int len = -1;
							try {
								// in으로 들어온 Byte를 읽어서 buffer로 넣음
								while((len = in.read(buffer)) != -1) {
									// buffer배열중 0번쨰부터 len번째까지를 String으로 생성하여 출력
									System.out.print("Data: " + new String(buffer, 0, len));
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					t.start();
				} else {
					System.out.println("Serial Port만 이용할 수 있다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
