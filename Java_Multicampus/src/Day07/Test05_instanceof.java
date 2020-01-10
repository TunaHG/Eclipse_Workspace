package Day07;

public class Test05_instanceof {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog[] d;
		Fish[] f;
		Animal[] animals = {
				new Dog("진돗개", "캐리"),
				new Fish("쿠피"),
				new Fish("재피"),
				new Dog("시베리안허스키", "해피")
		};
		
		for(Animal data : animals) {
			if(data instanceof Dog) ((Dog)data).print();
			if(data instanceof Fish) ((Fish)data).print();
			data.breath();
		}
	}

}
