package Step;

import java.util.Scanner;

public class Q01546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		double score[] = new double[N];
		double max = 0;
		for(int i = 0; i < N; i++) {
			score[i] = scan.nextInt();
			if(score[i] > max) {
				max = score[i];
			}
		}
		double sum = 0;
		for(int i = 0; i < N; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		System.out.println(sum / N);
	}

}
