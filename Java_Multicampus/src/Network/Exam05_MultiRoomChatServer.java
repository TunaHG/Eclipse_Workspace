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
		MultiChatUserObject shared = new MultiChatUserObject();
		ExecutorService es = Executors.newCachedThreadPool();

		System.out.println("Server Start");
		try {
			// Serversocket 객체 생성
			server = new ServerSocket(20000);

			System.out.println("Waiting Client...");
			// 여러 개의 Client를 받을 예정이므로 Server Program 종료이전까지 무한Loop
			while (true) {
				// ServerSocket으로 들어온 Client Socket
				socket = server.accept();
				System.out.println("Client Connected");
				
				// Thread를 사용하여 기능수행
				MultiChatRunnable chat = new MultiChatRunnable(socket, shared);
				
				// Thread 공용객체중 모든 Client를 의미하는 Users에 user추가
				shared.users.add(chat);
				
				// ExecutorService를 이용하여 생성한 Thread Pool를 활용하여 Thread 실행
				es.execute(chat);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

// 기능을 수행할 Thread Class
class MultiChatRunnable implements Runnable {
	private Socket socket;
	private MultiChatUserObject users;
	private BufferedReader br;
	private PrintWriter pw;
	private String roomName;
	private String userID;

	// 생성자, Client의 Socket과 공용객체를 받아옴
	MultiChatRunnable(Socket socket, MultiChatUserObject users) {
		this.socket = socket;
		this.users = users;
		try {
			// Socket을 이용하여 Input, Output Stream생성
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.pw = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Getter Method는 공용객체에서 해당 Data를 사용하기 위함
	public PrintWriter getPw() {
		return pw;
	}
	
	public String getUserID() {
		return userID;
	}

	
	// 각 기능을 넘어오는 message를 이용하여 수행
	@Override
	public void run() {
		String line = "";
		try {
			// Message가 들어오지 않을때까지 수행
			while ((line = br.readLine()) != null) {
				// @EXIT 메시지를 수신하면, 특정 채팅방에서 나간 상태
				if (line.equals("@EXIT")) {
					// User를 채팅방에서 제거하는 Method
					users.removeUserInRoom(MultiChatRunnable.this);
					// Client에서 GUI 작업을 위해 Message를 전송
					pw.println("@EXIT");
					pw.flush();
					// 아래의 Code들이 실행되지 않도록 continue
					continue;
				}
				// @DELETE 메시지를 수신하면, Server와의 연결을 종료하는 상황
				if(line.equals("@DELETE")) {
					// Server가 가지고 있는 공용객체의 자료구조에서 해당 User를 제거하는 Method
					users.removeUser(MultiChatRunnable.this);
					// Server의 작업이 종료될 것이므로 break를 사용하여 반복문 종료
					break;
				}
				// @userID로 시작하는 메시지를 수신하면, user가 userID로 접속하는 상황
				if(line.startsWith("@userID")) {
					// user객체가 가지는 userID값으로 지정
					this.userID = line.replace("@userID ", "");
					System.out.println("Setting userID: " + this.userID);
					continue;
				}
				// @createRoom으로 시작하는 메시지를 수신하면, 새로운 채팅방을 만드는 상황
				if(line.startsWith("@createRoom")) {
					// Client가 해당 단어 이후에 채팅방 이름을 전송함, 채팅방 이름을 변수로 선언
					String roomName = line.replaceFirst("@createRoom ", "");
					// 채팅방 이름으로 새로운 채팅방 생성하는 Method
					int result = users.createRoom(roomName);
					// 결과값이 0이면, 이미 생성된 채팅방을 의미
					if(result == 0) {
						pw.println("[System]\t이미 생성된 채팅방 이름입니다.");
					} else {
						// 결과값이 1이면, 새로운 생성방이 생성되었음을 의미
						pw.println("[System]\t채팅방 " + roomName + "이 생성되었습니다.");
					}
					System.out.println("Create Chat Room: " + roomName);
					continue;
				}
				// @connRoom으로 시작하는 메시지를 수신하면, 특정 채팅방으로 접속하는 상황
				if(line.startsWith("@connRoom")) {
					// Client가 해당 단어 이후에 채팅방 이름을 전송함, 채팅방 이름을 변수로 선언
					String roomName = line.replaceFirst("@connRoom ", "");
					// 채팅방 이름을 이용하여 해당 채팅방으로 User 접속
					// 여기서 인자로 MultiChatRunnable객체를 받는데,
					// 그냥 this를 사용하면 해당 객체가 아닌 돌아가고 있는 Thread가 전달되서 Error 발생하므로 유의
					users.connRoom(roomName, MultiChatRunnable.this);
					// 해당 User가 특정 채팅방에 접속했으므로 채팅방 이름을 전역변수로 지정 (추후에 해당 채팅방의 모든 User를 출력할때 사용)
					this.roomName = roomName;
					System.out.println(this.userID + " Connect Chat Room: " + roomName);
					continue;
				}
				// @getRooms 메시지를 수신하면, 모든 채팅방을 출력
				if(line.equals("@getRooms")) {
					// 모든 채팅방을 User들에게 갱신시켜주는 Method
					// String 변수를 받는 이유는 Server System.out.println에 사용하기 위함.
					String rooms = users.getRooms();
					System.out.println("Return All Room Names: " + rooms);
					continue;
				}
				// @getUsers 메시지를 수신하면, 특정 채팅방에 접속중인 모든 User를 출력
				if(line.equals("@getUsers")) {
					// 특정 채팅방(전역변수 roomName)에 접속중인 모든 User의 명단을 해당 User들에게 갱신시켜주는 Method
					// String 변수를 받는 이유는 Server System.out.println에 사용하기 위함.
					String userIDs = users.getUsers(roomName);
					System.out.println("Return " +  roomName + " Room's User IDs: " + userIDs);
					continue;
				}
				// 모든 경우의 수에서 벗어날 경우, 해당 채팅방에 User가 보내는 Message임.
				// 채팅방에 접속중인 모든 User에게 전송하는 Method
				users.broadcast(roomName, userID, line);
				System.out.println(userID + " Send Msg(" + line + ") to " + roomName);
			}
			// 반복문이 종료되었다는 것은, 해당 Client의 접속이 종료되었다는 의미. 자원해제
			if(br != null)
				br.close();
			if(pw != null)
				pw.close();
			if(socket != null)
				socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// Thread 공용객체 Class
class MultiChatUserObject {
	// 현재 Server에 접속중인 모든 User를 나타낼 객체
	List<MultiChatRunnable> users = new ArrayList<>();
	// 특정 채팅방에 소속된 User들을 나타낼 객체
	// <채팅방이름, 해당 채팅방에 소속된 User들의 List>의 구조를 가지는 Map
	Map<String, List<MultiChatRunnable>> map = new HashMap<>();
	
	// 새로운 채팅방을 생성할 Method
	public int createRoom(String roomName) {
		// map구조가 이미 채팅방 이름을 가지고 있다면 0 return
		if(map.containsKey(roomName))
			return 0;
		// 0으로 return되지 않았다면,
		// map자료구조에 새로운 채팅방을 생성하고 1 return
		// 여기서 해당 채팅방에 소속된 User들의 List는 채팅방 생성만하고 접속하지 않았으므로 비어있게 하는데, null이 들어가면안됨!
		map.put(roomName, new ArrayList<MultiChatRunnable>());
		return 1;
	}

	// 특정 채팅방에 접속하는 Method
	public void connRoom(String roomName, MultiChatRunnable r) {
		// 특정 채팅방에 접속한다는 의미는 이미 해당 채팅방이 생성되어 map자료구조에 들어있다는 의미
		// 해당 채팅방에 소속된 User들의 List를 임시변수로 할당
		List<MultiChatRunnable> tmp = map.get(roomName);
		// 임시변수에 새로운 User추가
		tmp.add(r);
		// 임시변수를 해당 채팅방의 value값으로 지정
		// map 자료구조의 특징으로 같은 key값을 가진다면, 이후에 입력된 value값으로 value가 갱신
		map.put(roomName, tmp);
		
		// 특정 채팅방의 User들을 출력하는 Method를 모든 채팅방에 대해 실행하여 전부 갱신 
//		for(String room : map.keySet())
//			getUsers(room);
	}
	
	// 특정 채팅방에서 User를 제거하는 Method
	public void removeUserInRoom(MultiChatRunnable r) {
		// 모든 채팅방을 탐색하기 위한 반복문
		for(String roomName : map.keySet()) {
			// 특정 채팅방의 User List를 가져옴
			List<MultiChatRunnable> userList = map.get(roomName);
			// User List가 특정 User를 포함하고 있다면,
			if(userList.contains(r)) {
				// 특정 User를 해당 User List에서 제거
				userList.remove(r);
				// 특정 User가 제거된 User List를 map자료구조에 갱신
				map.put(roomName, userList);
				// 해당 채팅방에 출력되는 User목록을 갱신
				getUsers(roomName);
				// 특정 User가 포함된 채팅방에서 제거과정을 진행했으니 다른 채팅방은 보지않아도 됨
				break;
			}
		}
//		getRooms();
	}
	
	// 특정 User가 Server와의 연결을 종료했을 때 실행할 Method
	public void removeUser(MultiChatRunnable r) {
		// Server에 접속중인 모든 User를 의미하는 users에서 특정 User를 제거
		users.remove(r);
	}
	
	// Client GUI에서 모든 채팅방을 보여주는 Method
	public String getRooms() {
		// 모든 채팅방을 String[]로 선언
		// keySet()은 Set자료구조로 반환, Set의 toArray()는 Object[]로 반환
		// toArray()의 인자로 new String[]{}를 선언하면 String[]로 반환
		String[] tmp = map.keySet().toArray(new String[] {});
		// Client가 명령으로 인식하도록 하기위한 명령어 지정
		String rooms = "@getRooms";
		// 명령어 이후의 인자 선언
		for(String room : tmp) {
			rooms += " " + room;
		}
		// 모든 User에게 전달(모든 User가 채팅방을 계속 갱신함)
		for(MultiChatRunnable user : users) {
			user.getPw().println(rooms);
			user.getPw().flush();
		}
		
		return rooms;
	}
	
	// Client GUI에서 특정 채팅방에 접속한 모든 User를 보여주는 Method
	public String getUsers(String roomName) {
		// 특정 채팅방의 모든 User를 의미하는 map의 value값 지정
		List<MultiChatRunnable> tmp = map.get(roomName);
		// Client가 명령으로 인식하도록 하기 위한 명령어 지정
		String userIDs = "@getUsers";
		// 명령어 이후의 인자 선언
		for (MultiChatRunnable user : tmp) {
			userIDs += " " + user.getUserID();
		}
		// 특정 채팅방에 포함된 모든 User에게 전달
		for(MultiChatRunnable user : tmp) {
			user.getPw().println(userIDs);
			user.getPw().flush();
		}
		
		return userIDs;
	}

	// 특정 채팅방에 Message를 전송하는 Method
	public void broadcast(String roomName, String sender, String msg) {
		// 특정 채팅방의 모든 User를 지정
		List<MultiChatRunnable> tmp = map.get(roomName);
		// 특정 채팅방의 모든 User에게 Message 전송
		for (MultiChatRunnable user : tmp) {
			user.getPw().println("[" + roomName + ", " + sender + "]\t" + msg);
			user.getPw().flush();
		}
	}
}
