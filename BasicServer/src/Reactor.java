import java.io.IOException;
import java.net.ServerSocket;

public class Reactor {
	private ServerSocket serverSocket;
	private HandleMap handleMap;

	public Reactor(int port) {
		handleMap = new HandleMap();
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startServer() {

//		Dispatcher dispatcher = new ThreadPerDispatcher();
		Dispatcher dispatcher = new ThreadPoolDispatcher();

//		while (true) {
			dispatcher.dispatch(serverSocket, handleMap);
//		}
	}

	// Handler를 등록하는 Method
	public void registerHandler(EventHandler handler) {
		// put(Handler의 Header, Handler)
		handleMap.put(handler.getHandler(), handler);
	}

	// getHandler()를 사용하지 않고 XMl의 header를 가져와서 등록할 때 사용하는 MEthod
	public void registerHandelr(String header, EventHandler handler) {
		handleMap.put(header, handler);
	}

	public void removeHandler(EventHandler handler) {
		handleMap.remove(handler.getHandler());
	}
}
