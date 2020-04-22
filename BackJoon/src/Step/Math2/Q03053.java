package Step.Math2;

import java.util.Scanner;

public class Q03053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int r = scan.nextInt();
		scan.close();
		double taxi = 2 * r * r;
		
		System.out.printf("%.6f\n", Math.PI * (r * r));
		System.out.printf("%.6f", taxi);
	}

}
