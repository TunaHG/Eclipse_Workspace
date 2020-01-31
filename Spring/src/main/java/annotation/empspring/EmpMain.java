package annotation.empspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		// emp.xml >> Spring Bean Configuration XML
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/empspring/emp.xml");
		
		// 스프링 xml 설정내용 객체생성 1 - Singleton 방식 (같은이름의 같은타입의 Bean은 한번만 생성됨)
		EmpDAO dao = factory.getBean("empDAO", EmpDAO.class);
//		dao.insertEmp();
		
		// 2 (이전의 Bean을 사용)
//		EmpDAO dao2 = factory.getBean("dao", EmpDAO.class);
	}

}
