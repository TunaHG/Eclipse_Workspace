package Step.BruteForce;

import java.util.Scanner;

public class Q01436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		scan.close();
		int num = 1;
		while(N > 0) {
			num++;
			String str = String.valueOf(num);
			if(str.contains("666")) {
				N--;
			}
		}
		System.out.print(num);
	}

}
