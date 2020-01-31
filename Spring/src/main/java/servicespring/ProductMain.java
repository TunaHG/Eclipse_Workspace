package servicespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("servicespring/product.xml");
		
		// No Sale
		ProductService service1 = factory.getBean("service1", ProductService.class); 
		ProductVO vo1 = service1.sell();
		System.out.println(vo1);
		
		// December Sale
		ProductService service2 = factory.getBean("service2", ProductService.class); 
		ProductVO vo2 = service2.sell();
		System.out.println(vo2);
		
		// May Sale
		ProductService service3 = factory.getBean("service3", ProductService.class); 
		ProductVO vo3 = service3.sell();
		System.out.println(vo3);
	}

}
