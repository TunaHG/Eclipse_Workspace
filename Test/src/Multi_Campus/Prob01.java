package Multi_Campus;

public class Prob01 {

	public static void main(String[] args) {
		// Q1.
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + "=" + i*j);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		// Q2.
		double sum1 = 0;
		for(double i = 1.; i <= 9; i++) {
			sum1 += i / (i + 1);
		}
		System.out.printf("%.2f\n",sum1);
		
		// Q3.
		int sum2 = 0;
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				sum2 += j;
			}
		}
		System.out.println(sum2);
	}

}
