package annotation.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("annotation/aop1/aop.xml");
		
		Member m = container.getBean("member", Member.class);
		Board b = container.getBean("board", Board.class);
		
//		공통관심 = 횡단관심 = Aspect Class (Spring AOP : 자동으로 같이 실행)
//		Common c = container.getBean("common", Common.class);
		
		
		m.login("spring");
		b.insertBoard(100);
		b.getList();
		m.logout();
	}

}
