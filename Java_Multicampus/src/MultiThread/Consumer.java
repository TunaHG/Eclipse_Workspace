package MultiThread;

// Thread Class를 상속하여 Buffer 객체에 저장된 숫자를 소비하는 소비자 Thread를 선언
public class Consumer extends Thread {
	// 소비자가 소비할 숫자가 저장된 Buffer 객체를 생성자를 통해 초기화함
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	// 소비자 Thread는 run()메소드에서
	// Buffer 객체의 get()메소드를 10번 호출해서
	// Buffer에 저장된 숫자를 하나씩 소비함
	public void run() {
		for(int i = 0; i < 10; i++) {
			buffer.get();
		}
	}
}
