package Step.Math1;

import java.util.Scanner;

public class Q02869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		int V = scan.nextInt();
		
//		int day = 0;
//		int height = 0;
//		while(true) {
//			day++;
//			height += A;
//			if(height == V) break;
//			
//			height -= B;
//		}
		int day;
		int exceptLast = V - A;
		int heightPerDay = A - B;
		if(exceptLast % heightPerDay == 0) {
			day = exceptLast / heightPerDay + 1;
		} else {
			day = exceptLast / heightPerDay + 2;
		}
		System.out.println(day);
	}

}
