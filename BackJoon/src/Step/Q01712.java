package Step;

import java.util.Scanner;

public class Q01712 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		long A = scan.nextLong();
		long B = scan.nextLong();
		long C = scan.nextLong();
		if((C - B) <= 0){
            System.out.print("-1");
        }
		else {
			long sum = (A / (C - B)) + 1;
			System.out.print(sum);
		}
	}

}
