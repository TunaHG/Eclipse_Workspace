package Step.Practice1;

import java.util.Scanner;

public class Q10817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		if(num1 > num2) {
			if(num2 > num3) {
				System.out.print(num2);
			} else {
				if(num1 > num3) {
					System.out.print(num3);
				} else {
					System.out.print(num1);
				}
			}
		} else {
			if(num1 > num3) {
				System.out.print(num1);
			} else {
				if(num2 > num3) {
					System.out.print(num3);
				} else {
					System.out.print(num2);
				}
			}
		}
	}
}
