package javaArduino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Exam03_AndroidArduinoServer {
	static BufferedWriter bw;
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
					bw = new BufferedWriter(new OutputStreamWriter(out));
				} else {
					System.out.println("Serial Port만 이용할 수 있다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					ServerSocket server = new ServerSocket(9998);
					System.out.println("ServerSocket Created");
					Socket socket = server.accept();
					System.out.println("Client Connected");
					
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter pw = new PrintWriter(socket.getOutputStream());
					
					String msg = "";
					while(true) {
						if((msg = br.readLine()) != null) {
							if(msg.equals("LED_ON")) {
								System.out.println("Turn on LED");
								bw.write(msg, 0, msg.length());
								bw.flush();
							}
							if(msg.equals("LED_OFF")) {
								System.out.println("Turn off LED");
								bw.write(msg, 0, msg.length());
								bw.flush();
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(runnable);
		t.start();
	}

}
