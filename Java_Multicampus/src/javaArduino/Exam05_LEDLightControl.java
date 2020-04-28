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

public class Exam05_LEDLightControl {
	static BufferedWriter bw;
	static PrintWriter pw;
	static InputStream in;
	static OutputStream out;
	
	public static void main(String[] args) {
		CommPortIdentifier portIdentifier = null;
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM9");
			
			if(portIdentifier.isCurrentlyOwned()) {
				System.out.println("Port is used");
			} else {
				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);
				if(commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort)commPort;
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
					
					in = serialPort.getInputStream();
					out = serialPort.getOutputStream();
					bw = new BufferedWriter(new OutputStreamWriter(out));
				} else {
					System.out.println("Serial Port is only usable");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					ServerSocket server = new ServerSocket(9997);
					System.out.println("ServerSocket Created");
					Socket socket = server.accept();
					System.out.println("Client Connected");
					
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw = new PrintWriter(socket.getOutputStream());
					String msg = "";
					while(true) {
						if((msg = br.readLine()) != null) {
							int num = Integer.parseInt(msg);
							out.write(num);
							out.flush();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				byte[] buffer = new byte[1024];
				// Data의 Size를 의미함. -1은 데이터가 없다는 의미
				int len = -1;
				String str = "";
				try {
					// in으로 들어온 Byte를 읽어서 buffer로 넣음
					while((len = in.read(buffer)) != -1) {
						// buffer배열중 0번쨰부터 len번째까지를 String으로 생성하여 출력
						String tmp = new String(buffer, 0, len);
						if(tmp.contains("\n")) {
//							String[] arr = tmp.split("\n");
							str += tmp;
							pw.println(str.trim());
							pw.flush();
							System.out.println(str.trim());
							str = "";
						} else {
							str += tmp;
						}
					}
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
		t2.start();
	}

}
