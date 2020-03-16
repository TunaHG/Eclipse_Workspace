package MultiThread;

public class Buffer {
	// 생산된 숫자를 저장할 contents 변수를 선언
	private int contents;
	// 생산자와 소비자 Thread를 번갈아 수행하기 위해서 flag 변수를 선언
	private boolean flag = false;
	
	// * 매개변수로 받은 정수를 contents 변수에 저장하고 생산된 숫자 정보를 화면에 출력하는 put()메소드를 구현함
	// * put()메소드는 한 순간에 하나의 Thread만 접근할 수 있도록 synchronized를 붙여 동기화시킴
	// * put()메소드는 flag 변수값이 true일 때, 현재 Thread를 wait 상태로 보내고, 
	//   false일 때는 flag를 true로 변경한 후에 wait상태에 있는 Thread들을 
	//   notifyAll()메소드를 호출하여 실행 가능 상태로 변경함
	// 버퍼에 데이터를 저장하는 메소드로서 동기화한다.
	public synchronized void put(int value) {
		if(flag == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contents = value;
		flag = true;
		System.out.println("생산자 : 생산 " + contents);
		notifyAll();
	}
	
	// * contents 변수에 저장된 숫자 정보를 소비하는 get()메소드를 구현함
	// * get()메소드는 한 순간에 하나의 Thread만 접근할 수 있도록 synchronized를 붙여 동기화시킴
	// * get()메소드는 flag 변수값이 true일 때, 현재 Thread를 wait 상태로 보내고,
	//   false일 때는 flag를 false로 변경한 후에 wait 상태에 있는 Thread들을
	//   notifyAll()메소드를 호출하여 실행 가능 상태로 변경함
	// 버퍼에서부터 데이터를 가져가는 메소드로서 동기화한다.
	public synchronized void get() {
		if(flag == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("소비자 : 소비 " + contents);
		
		flag = false;
		notifyAll();
	}
}
