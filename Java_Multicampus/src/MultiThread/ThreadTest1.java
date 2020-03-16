package MultiThread;

//java.lang.Thread Class를 상속한 Class를 선언
class MyThread extends Thread {
	String threadName;
	
	public MyThread(String threadName) {
		this.threadName = threadName;
	}
	
	// Thread의 기능을 구현하는 Method
	// run() Method를 Overriding하여 Thread가 처리할 실질적인 로직을 구현함
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + threadName);
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---> " + threadName + " 수행 종료");
	}
}

public class ThreadTest1 {
	public static void main(String args[]) {
		// Program의 시작 메시지를 출력하여 Thread의 동작 시점을 확인
		System.out.println("===> Program Start");
		
		// 두 개의 Thread 객체를 생성
		MyThread first, second;
		first = new MyThread("First Thread");
		second = new MyThread("Second Thread");
		
		// start() Method를 호출하여 Thread를 동작시킴
		first.start();
		second.start();
		
		// Program의 종료 메시지를 출력하여 Thread의 종료 시점을 확인
		System.out.println("===> Program End");
	}
}
