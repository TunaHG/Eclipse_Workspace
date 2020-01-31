package annotation.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/Test/test.xml");
		
		TestService service = factory.getBean("service", TestService.class);
		TestVO vo = service.test();
		System.out.println(vo.getMember1() + " : " + vo.getMember2());
	}
}
