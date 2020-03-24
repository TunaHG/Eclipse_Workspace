package Step;

import java.util.Scanner;

public class Q11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int A[] = new int[N];
		int dp[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
			dp[i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] > A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				} 
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
