package Step.Array1;

import java.util.Scanner;

public class Q04344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();
		for(int i = 0; i < C; i++) {
			int N = scan.nextInt();
			int arr[] = new int[N];
			int sum = 0;
			for(int j = 0; j < N; j++) {
				arr[j] = scan.nextInt();
				sum += arr[j];
			}
			double avg = (double)sum / N;
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(arr[j] > avg) cnt++;
			}
			double result = (double)cnt / N * 100;
			System.out.println(String.format("%.3f" + "%%", result));
		}
	}

}
