package MultiThread;

// Thread Class를 상속하여 정수를 생산하는 생산자 Thread Class를 선언함
public class Producer extends Thread {
	// 생산된 정수를 저장할 Buffer 객체를 생성자를 통해 초기화
	private Buffer buffer;
	
	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	// 생산자 Thread는 run() 메소드에서
	// Buffer 객체의 put() 메소드를 10번 호출해서 Buffer에 숫자를 저장하고
	// 이후 sleep() 메소드를 이용하여 랜덤하게 Thread의 수행을 중지함.
	public void run() {
		for(int i = 0; i < 10; i++) {
			// 생산자 Thread는 put() 메소드를 호출
			buffer.put(i);
			try {
				sleep((int) Math.random() * 100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
