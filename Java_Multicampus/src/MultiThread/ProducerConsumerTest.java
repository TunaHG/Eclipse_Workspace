package MultiThread;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		// 생산자와 소비자 Thread가 사용할 Buffer 객체를 생성
		Buffer buffer = new Buffer();
		
		// 생산자와 소비자 Thread 객체를 Buffer 객체를 인자로 하여 각각 생성
		Producer prod = new Producer(buffer);
		Consumer cons = new Consumer(buffer);
		
		// 생성된 생산자와 소비자 Thread 객체를 start()메소드를 호출하여 실행
		prod.start();
		cons.start();
	}
}
