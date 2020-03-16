package MultiThread;

public class SingleThreadTest {
	// 클래스 내부에 main()메소드 하나를 가지는 형태로 작성
	public static void main(String[] args) {
		System.out.println("Single Thread 프로그램 수행...");
		// 0부터 9까지의 숫자를 출력하는 프로그램
		for(int i = 0; i < 10; i++) {
			// 현재 실행중인 Thread 객체의 이름에 발생된 숫자를 결합하여 출력
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " : " + i);
		}
	}

}
