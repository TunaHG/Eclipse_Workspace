package Step;

import java.util.Scanner;

public class Q02156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[] = new int[N + 1];
		int dp[] = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		
		dp[1] = arr[1];
		if(N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}
		
		System.out.println(dp[N]);
	}

}
// ��ó : https://zoonvivor.tistory.com/133