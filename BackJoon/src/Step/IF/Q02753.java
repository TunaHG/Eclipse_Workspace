package Step.IF;

import java.util.Scanner;

public class Q02753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					System.out.print(1);
				} else {
					System.out.print(0);
				}
			} else {
				System.out.print(1);
			}
		} else {
			System.out.print(0);
		}
	}

}
