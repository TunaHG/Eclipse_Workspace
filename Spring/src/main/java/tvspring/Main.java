package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 객체 변경시 코드 수정 불가피 = 결합도 높다, coupling 높다(나쁜 코드)
		// 객체를 변경했을 때 메소드가 전부 다르기 때문에 메소드도 전부 바꿔줘야 하기 때문
		// Dependency : 위임, Spring으로부터 생성
		ApplicationContext factory = new ClassPathXmlApplicationContext("tvspring/tv.xml");
		
		TV tv = factory.getBean("tv", TV.class);
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		TV tv2 = factory.getBean("tv2", TV.class);
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
	}

}
