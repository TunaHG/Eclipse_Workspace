package Step.BruteForce;

import java.util.Scanner;

public class Q02798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				for(int k = j + 1; k < N; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(sum > M) continue;
					else if(max < sum) max = sum;
				}
			}
		}
		
		System.out.print(max);
	}

}
