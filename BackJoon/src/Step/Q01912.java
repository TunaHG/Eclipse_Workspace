package Step;

import java.util.Scanner;

public class Q01912 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[] = new int[N];
		int dp[] = new int[N + 1];
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
			dp[i + 1] = arr[i];
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i] + dp[i - 1]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		// 1차원 배열로 연속된 값을 전부 탐색하는 방법 - 시간초과
//		int N = scan.nextInt();
//		int arr[] = new int[N];
//		int dp[] = new int[N];
//		for(int i = 0; i < N; i++) {
//			arr[i] = scan.nextInt();
//		}
//		
//		int max = Integer.MIN_VALUE;
//		int sum = 0;
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j <= i; j++) {
//				sum = 0;
//				for(int k = j; k <= i; k++) {
//					sum += arr[k];
//				}
//				max = Math.max(max, sum);
//			}
//		}
//		System.out.println(max);
		// 2차원 배열 사용한 방법 - 메모리초과
//		int N = scan.nextInt();
//		int arr[] = new int[N];
//		int dp[][] = new int[N + 1][N + 1];
//		int max = Integer.MIN_VALUE;
//		for(int i = 0; i < N; i++) {
//			arr[i] = scan.nextInt();
//			dp[1][i + 1] = arr[i];
//			max = Math.max(max, arr[i]);
//		}
//		
//		for(int i = 2; i <= N; i++) {
//			for(int j = i; j <= N; j++) {
//				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] - dp[i - 2][j - 1];
//				max = Math.max(max, dp[i][j]);
//			}
//		}
//		
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= N; j++) {
//				System.out.print(dp[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println(max);
	}

}
