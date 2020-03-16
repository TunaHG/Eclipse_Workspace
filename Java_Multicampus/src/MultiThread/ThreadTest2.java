package MultiThread;

// java.lang.Runnable Interface를 구현한 RunnableThread Class 선언
class RunnableThread implements Runnable{
	String threadName;
	
	public RunnableThread(String threadName) {
		this.threadName = threadName;
	}
	// run() Method를 Overriding하여 Thread가 처리할 실질적인 로직을 구현함
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + threadName);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println("---> " + threadName + " 수행 종료");
	}
}

public class ThreadTest2 {
	public static void main(String[] args) {
		// Program의 시작 메시지를 출력하여 Thread의 동작 시점을 확인
		System.out.println("===> Program Start");
				
		// 두 개의 Thread 객체를 생성
		Thread thread1 = new Thread(new RunnableThread("First Thread"));
		Thread thread2 = new Thread(new RunnableThread("Second Thread"));
				
		// start() Method를 호출하여 Thread를 동작시킴
		thread1.start();
		thread2.start();
				
		// Program의 종료 메시지를 출력하여 Thread의 종료 시점을 확인
		System.out.println("===> Program End");
	}
}
