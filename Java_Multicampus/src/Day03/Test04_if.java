package Day03;

import java.util.Scanner;

public class Test04_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start App...");
		Scanner sc = new Scanner(System.in);

		System.out.println("If you want to exit Input 'quit'");
		String msg = sc.nextLine();

		if (msg.toLowerCase().equals("quit".toLowerCase())) {
			System.out.println("Close App...");
			if (sc != null) {
				sc.close();
				sc = null;
			}
			return;
		}

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
		System.out.printf("Avg : %.2f%n", avg);
		

		if (avg >= 80) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		sc.close();
		sc = null;
		return;
	}

}
