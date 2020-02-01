package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// Dependency : 위임, Spring으로부터 생성
		ApplicationContext container = new ClassPathXmlApplicationContext("tvspring/tv.xml");
		
		TV tv = container.getBean("tv", TV.class);
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		TV tv2 = container.getBean("tv2", TV.class);
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
	}

}
