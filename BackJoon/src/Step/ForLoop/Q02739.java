package Step.ForLoop;

import java.util.Scanner;

public class Q02739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		for(int i = 1; i <= 9; i++) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
	}

}
