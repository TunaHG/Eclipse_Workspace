package javaArduino;

import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

// 이벤트를 처리하는 리스너객체를 만들기 위한 Class 정의
class SerialListener implements SerialPortEventListener {
	private InputStream in;
	
	SerialListener(InputStream in){
		this.in = in;
	}
	
	@Override
	public void serialEvent(SerialPortEvent arg0) {
		// 이벤트가 발생하면 호출되는 Method
		if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				// InputStream에 Data가 존재하는지 확인
				// return값은 size를 의미하므로 k는 전달되는 Data의 크기를 의미한다.
				int k = in.available();
				// 데이터의 size를 알기 때문에 그만큼만 배열을 선언
				byte[] data = new byte[k];
				in.read(data, 0, k);
				
				System.out.println("Data: " + new String(data));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class Exam02_ArduinoSerialUsingEvent {

	public static void main(String[] args) {
		CommPortIdentifier portIdentifier = null;
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM9");
			
			if(portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다.");
			} else {
				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);
				if(commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort)commPort;
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					
					InputStream in = serialPort.getInputStream();
					OutputStream out = serialPort.getOutputStream();
					
					serialPort.addEventListener(new SerialListener(in));
					// Data가 들어오면 신호를 줘서 Event를 진행
					serialPort.notifyOnDataAvailable(true);
				} else {
					System.out.println("Serial Port만 이용할 수 있다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
