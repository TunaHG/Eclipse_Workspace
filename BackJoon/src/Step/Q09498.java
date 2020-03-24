package Step;

import java.util.Scanner;

public class Q09498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		if(num >= 90) {
			System.out.print("A");
		} else if(num >= 80) {
			System.out.print("B");
		} else if(num >= 70) {
			System.out.print("C");
		} else if(num >= 60) {
			System.out.print("D");
		} else {
			System.out.print("F");
		}
	}

}
