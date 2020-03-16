package MultiThread;

// Thread를 상속하는 SimpleThread Class 선언
class SimpleThread extends Thread {
	private String threadName;
	
	public SimpleThread(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		// 5번 반복하면서 0부터 4까지의 정수를 출력
		for(int i = 0; i < 5; i++) {
			System.out.println(threadName + " : " + i);
		}
		System.out.println("---> " + threadName + " 수행 종료");
	}
}

public class PriorityTest {
	public static void main(String[] args) {
		// Program의 시작 메시지를 출력하여 Thread의 동작 시점을 확인
		System.out.println("===> Program Start");
		
		SimpleThread first = new SimpleThread("First Thread");
		SimpleThread second = new SimpleThread("Second Thread");
		
		first.setPriority(Thread.MIN_PRIORITY);
		second.setPriority(Thread.MAX_PRIORITY);
		
		first.start();
		second.start();
		
		// Program의 종료 메시지를 출력하여 Thread의 종료 시점을 확인
		System.out.println("===> Program End");
	}
}
