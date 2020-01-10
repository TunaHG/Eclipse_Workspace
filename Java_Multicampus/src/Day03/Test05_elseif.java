package Day03;

import java.io.FileInputStream;
import java.util.Scanner;

public class Test05_elseif {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Start App...");
		Scanner sc = new Scanner(new FileInputStream("C://lib/score.txt"));

		int kor, eng, math;
		String name;

		System.out.println("Input Name, Kor, Eng, Math Score.");
		System.out.println("ex)홍길동 90 90 90");
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
		if(avg >= 90) grade = 'A';
		else if(avg >= 80) grade = 'B';
		else if(avg >= 70) grade = 'C';
		else if(avg >= 60) grade = 'D';
		
		System.out.printf("Grade : %c%n", grade);

		if(sc != null) sc.close();
		sc = null;
		return;
	}

}
