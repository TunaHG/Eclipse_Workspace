package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam05_MultiRoomChatServer {

	public static void main(String[] args) {
		ServerSocket server;
		Socket socket;
		MultiChatUserObject users = new MultiChatUserObject();
		MultiChatRoomObject rooms = new MultiChatRoomObject();
		ObjectOutputStream oos;
		ObjectInputStream ois;
		BufferedReader br;
		PrintWriter pw;
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Server Start");
		try {
			server = new ServerSocket(20000);

			System.out.println("Waiting Client...");
			while (true) {
				socket = server.accept();
				System.out.println("Client Connected");
				
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(rooms);
				oos.flush();
				
				MultiChatRunnable chat = new MultiChatRunnable(socket, rooms);
				
				
				
				es.execute(chat);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class MultiChatRunnable implements Runnable {
	private Socket socket;
	private MultiChatRoomObject rooms;
	private String roomName;
	private BufferedReader br;
	private PrintWriter pw;

	MultiChatRunnable(Socket socket, MultiChatRoomObject rooms) {
		this.socket = socket;
		this.rooms = rooms;
		try {
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.pw = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PrintWriter getPw() {
		return pw;
	}

	@Override
	public void run() {
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				if (line.equals("@EXIT"))
					break;
				// 모든 Client에게 문자열을 전달하기위해 공용객체 활용
				rooms.broadcast(roomName, line);
//				pw.println(line);
//				pw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 채팅방의 목록을 의미하는 객체
class MultiChatRoomObject {
	List<MultiChatUserObject> rooms = new ArrayList<MultiChatUserObject>();
	
	public void add(MultiChatUserObject room) {
		rooms.add(room);
	}
	
	public void remove(MultiChatUserObject room) {
		rooms.remove(room);
	}
	
	public List<String> name(){
		List<String> names = new ArrayList<String>();
		for(MultiChatUserObject room : rooms) {
			names.add(room.getRoomName());
		}
		
		return names;
	}
	
	public void broadcast(String roomName, String msg) {
		for(MultiChatUserObject room : rooms) {
			if(room.getRoomName().equals(roomName)) {
				room.broadcast(msg);
			}
		}
	}
}

// 특정 채팅방에 포함된 User들을 의미하는 객체
class MultiChatUserObject {
	private String roomName;
	List<MultiChatRunnable> users = new ArrayList<MultiChatRunnable>();
	
	MultiChatUserObject() { }
	
	MultiChatUserObject(String roomName){
		this.roomName = roomName;
	}
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	// Data를 제어하기 위해 필요한 Method
	// 새로운 사용자가 접속했을 때 clients안에 새로운 사용자에 대한 Runnable 객체를 저장
	public void add(MultiChatRunnable r) {
		users.add(r);
	}

	// 사용자가 접속을 종료했을 때 clients안에 있는 사용자를 삭제
	public void remove(MultiChatRunnable r) {
		users.remove(r);
	}

	// Client가 Data를 보내줬을 때 Chat Message를 Broadcast하는 method
	public void broadcast(String msg) {
		for (MultiChatRunnable user : users) {
			user.getPw().println(msg);
			user.getPw().flush();
		}
	}
}