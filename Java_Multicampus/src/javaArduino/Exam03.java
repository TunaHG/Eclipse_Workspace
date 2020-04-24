package javaArduino;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
public class Exam03 {
	public static void main(String[] args) {
		
		CommPortIdentifier portIdentifier = null;
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM9");
			ServerSocket server = new ServerSocket(9998);
			System.out.println("Waiting Android...");
			Socket android = server.accept();
			System.out.println("Android Connected");
			
			if(portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다.");
			} else {
				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);
				if(commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort)commPort;
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					
					InputStream in = android.getInputStream();
					OutputStream out = serialPort.getOutputStream();
					
					System.out.println("Thread Start");
					
					Thread t1 = new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								byte[] buffer = new byte[1024];
								int len = -1;
								while((len = in.read(buffer)) != -1) {
									int num = Integer.parseInt(new String(buffer, 0, len));
									out.write(num);
									out.flush();
								}
								System.out.println("EXIT While Loop");
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					t1.start();
				} else {
					System.out.println("Serial Port만 이용할 수 있다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
