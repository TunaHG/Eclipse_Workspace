package nonspring;

public class Main {

	public static void main(String[] args) {
		// 객체 변경시 코드 수정 불가피 = 결합도 높다, coupling 높다(나쁜 코드)
		// 객체를 변경했을 때 메소드가 전부 다르기 때문에 메소드도 전부 바꿔줘야 하기 때문
		// Dependency : 직접 객체 생성
		TV tv = new MultiTV();
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		System.out.println();
		
		// Dependency : 위임, 다른 객체로부터 생성
		TVFactory factory = new TVFactory();
		tv = factory.getTV(args[0]); // Run Configuration - arguments에 Other를 입력한 후 실행
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
	}

}
