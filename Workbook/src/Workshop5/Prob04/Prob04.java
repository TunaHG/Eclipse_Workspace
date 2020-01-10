package Workshop5.Prob04;

public class Prob04 {

	public static void main(String[] args) {
		Student studentArray[] = {
				new Student("홍길동", 15, 171, 81),
				new Student("한사람", 13, 183 ,72),
				new Student("임걱정", 16, 175, 65)
		};
		
		int ageSum = 0;
		int heightSum = 0;
		int weightSum = 0;
		System.out.println("이름\t나이\t신장\t몸무게");
		for (int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i].getName() + "\t" + studentArray[i].getAge() + "\t" +
		studentArray[i].getHeight() + "\t" + studentArray[i].getWeight());
			ageSum += studentArray[i].getAge();
			heightSum += studentArray[i].getHeight();
			weightSum += studentArray[i].getWeight();
		}
		System.out.println();
		System.out.printf("나이의 평균: %.2f\n", ageSum / 3.);
		System.out.printf("신장의 평균: %.2f\n", heightSum / 3.);
		System.out.printf("몸무게의 평균: %.2f", weightSum / 3.);
	}

}
