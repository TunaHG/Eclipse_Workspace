package Day03;

import java.util.Scanner;

public class Test03_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = null;
		int kor = 0, math = 0;

//		System.out.println(name.length());
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Name : ");
		name = sc.nextLine();
		System.out.print("Input Korean Score : ");
		kor = Integer.parseInt(sc.nextLine());
		System.out.print("Input Math Score : ");
		math = sc.nextInt();
		sc.nextLine();

		System.out.printf("Name : %s, Korean : %d, Math : %d%n", name, kor, math);

		double avg = (kor + math) / 2.;

		System.out.printf("avg : %.2f, Result : %s", avg, avg >= 80 ? "Pass" : "Fail");

		sc.close(); // 자원반납
		sc = null; // gc, 메모리 정리
		return;
	}

}
