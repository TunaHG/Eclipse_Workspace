package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam05_MultiRoomChatServer {

	public static void main(String[] args) {
		ServerSocket server;
		Socket socket;
		MultiChatUserObject users = new MultiChatUserObject();
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Server Start");
		try {
			server = new ServerSocket(20000);

			System.out.println("Waiting Client...");
			while (true) {
				socket = server.accept();
				System.out.println("Client Connected");
				
				MultiChatRunnable chat = new MultiChatRunnable(socket, users);
				
				users.users.add(chat);
				
				es.execute(chat);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class MultiChatRunnable implements Runnable {
	private Socket socket;
	private MultiChatUserObject users;
	private BufferedReader br;
	private PrintWriter pw;
	private String roomName;
	private String userID;

	MultiChatRunnable(Socket socket, MultiChatUserObject users) {
		this.socket = socket;
		this.users = users;
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
	
	public String getUserID() {
		return userID;
	}

	@Override
	public void run() {
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				if (line.equals("@EXIT")) {
					users.removeUserInRoom(MultiChatRunnable.this);
					pw.println("@EXIT");
					pw.flush();
					continue;
				}
				if(line.startsWith("@userID")) {
					this.userID = line.replace("@userID ", "");
					System.out.println("Setting userID: " + this.userID);
					continue;
				}
				if(line.startsWith("@createRoom")) {
					String roomName = line.replaceFirst("@createRoom ", "");
					int result = users.createRoom(roomName);
					if(result == 0) {
						pw.println("[System]\t이미 생성된 채팅방 이름입니다.");
					} else {
						pw.println("[System]\t채팅방 " + roomName + "이 생성되었습니다.");
					}
					System.out.println("Create Chat Room: " + roomName);
					continue;
				}
				if(line.startsWith("@connRoom")) {
					String roomName = line.replaceFirst("@connRoom ", "");
					users.connRoom(roomName, MultiChatRunnable.this);
					this.roomName = roomName;
					System.out.println(this.userID + " Connect Chat Room: " + roomName);
					continue;
				}
				if(line.equals("@getRooms")) {
					String rooms = users.getRooms();
					System.out.println("Return All Room Names: " + rooms);
					continue;
				}
				if(line.equals("@getUsers")) {
					String userIDs = users.getUsers(roomName);
					System.out.println("Return " +  roomName + " Room's User IDs: " + userIDs);
					continue;
				}
				users.broadcast(roomName, userID, line);
				System.out.println(userID + "Send Msg(" + line + ") to " + roomName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MultiChatUserObject {
	List<MultiChatRunnable> users = new ArrayList<>();
	Map<String, List<MultiChatRunnable>> map = new HashMap<>();
	
	public int createRoom(String roomName) {
		if(map.containsKey(roomName))
			return 0;
		map.put(roomName, new ArrayList<MultiChatRunnable>());
		return 1;
	}

	public void connRoom(String roomName, MultiChatRunnable r) {
		List<MultiChatRunnable> tmp = map.get(roomName);
		tmp.add(r);
		map.put(roomName, tmp);
		
		for(String room : map.keySet())
			getUsers(room);
	}
	
	public void removeUserInRoom(MultiChatRunnable r) {
		for(String roomName : map.keySet()) {
			List<MultiChatRunnable> userList = map.get(roomName);
			if(userList.contains(r)) {
				userList.remove(r);
				map.put(roomName, userList);
				getUsers(roomName);
				break;
			}
		}
		getRooms();
	}
	
	public String getRooms() {
		String[] tmp = map.keySet().toArray(new String[] {});
		String rooms = "@getRooms";
		for(String room : tmp) {
			rooms += " " + room;
		}
		for(MultiChatRunnable user : users) {
			user.getPw().println(rooms);
			user.getPw().flush();
		}
		
		return rooms;
	}
	
	public String getUsers(String roomName) {
		List<MultiChatRunnable> tmp = map.get(roomName);
		String userIDs = "@getUsers";
		for (MultiChatRunnable user : tmp) {
			userIDs += " " + user.getUserID();
		}
		
		for(MultiChatRunnable user : tmp) {
			user.getPw().println(userIDs);
			user.getPw().flush();
		}
		
		return userIDs;
	}

	public void broadcast(String roomName, String sender, String msg) {
		List<MultiChatRunnable> tmp = map.get(roomName);
		for (MultiChatRunnable user : tmp) {
			user.getPw().println("[" + roomName + ", " + sender + "]\t" + msg);
			user.getPw().flush();
		}
	}
}
