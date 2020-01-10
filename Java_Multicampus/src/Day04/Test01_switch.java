package Day04;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test01_switch {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Start App...");

		Scanner sc = new Scanner(new FileInputStream("C://lib/score.txt"), "UTF-8");
		int kor, eng, math;
		String name;

		name = sc.next();
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		sc.nextLine();

		double sum = kor + eng + math;
		double avg = sum / 3.;

		System.out.printf("Your Name : %s%n", name);
		System.out.printf("Kor : %d, Eng : %d, Math : %d%n", kor, eng, math);
		System.out.printf("Avg : %.2f, ", avg);

		char grade = 'F';
		switch ((int) avg / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';
		}

		System.out.printf("Grade : %c%n", grade);

		switch (grade) {
		case 'A':
			System.out.println("참 잘했어요!");
			break;
		case 'B':
			System.out.println("조금 아쉽네요");
			break;
		case 'C':
			System.out.println("노력해야겠어요!");
			break;
		case 'D':
			System.out.println("재수강각");
			break;
		case 'F':
			System.out.println("학고각");
			break;
		}

		if (sc != null)
			sc.close();
		sc = null;
		return;
	}

}
