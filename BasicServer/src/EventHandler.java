import java.io.InputStream;

public interface EventHandler {
	
	// Handler마다 가지고 있는 고유의 키값을 반환하는 Method
	// HandlerMap에 키값으로 등록하기 위해
	public String getHandler();
	
	// 데이터를 받아서 처리하는 Method
	public void handleEvent(InputStream inputStream);
}
