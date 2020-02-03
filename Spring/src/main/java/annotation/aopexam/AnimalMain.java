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