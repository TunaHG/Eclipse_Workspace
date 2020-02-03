package annotation.aopexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("annotation/aopexam/animal.xml");
		
		Animal[] ani = new Animal[3];
		ani[0] = container.getBean("cat", Animal.class);
//		ani[0] = (Animal)container.getBean("cat");
		ani[1] = container.getBean("dog", Animal.class);
		ani[2] = container.getBean("rabbit", Animal.class);
		
		for(Animal x : ani) {
			x.lunch();
			System.out.println();
			
//			aspect-around 일부 >> lunch() >> aspect-around 일부
//			그래서 around로 호출되는 메소드인 q()의 return값이 void기 때문에 null이 나온다.
//			이를 제대로 작동하도록 만들기 위해서는 q()에서 return type을 Object로 지정해준 후 proceed()로 나오는 결과물의 변수를 try밖으로 꺼낸 후 return한다.
//			String str = x.lunch();
//			System.out.println(str); // null
		}
	}

}

/*
오늘 점심에 뭐 먹었어요?
생선을 먹었습니다.
냥이-생선 먹었군요.

오늘 점심에 뭐먹었어요?
사료를 먹었습니다.
강아지-사료 먹었군요.

오늘 점심에 뭐먹었어요?
당근을 먹었습니다.
토끼-당근 먹었군요.
*/