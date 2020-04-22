package Step.DP1;

import java.util.Scanner;

public class Q10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		// �ڸ����� ������� ��Ÿ�� ��� 0 ~ 10�� ������ ���ڸ� ��Ÿ�� ��
		long dp[][] = new long[101][11];
		
		// �ڸ����� �Ѱ��� 1 ~ 9�� ù���� 1
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		// �ڸ����� �ΰ��ΰ� ���� ���ϴ� �ڸ������� �ݺ���
		for(int i = 2; i <= N; i++) {
			// ������ �ڸ����� 0�� ���� ������ ���� 1�� ������ ����
			dp[i][0] = dp[i - 1][1];
			// ������ �ڸ��� 1���� 9������ �ݺ���
			for(int j = 1; j <= 9; j++) {
				// �� ������ �ڸ����� ���� ���� �������ڸ��� -1�� �������ڸ��� +1�� ���� �հ� ����
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}
		
		// ������� ������ ����
		long sum = 0;
		// 0���� 9������ ��Ÿ�� Ƚ���� ������� ����
		for(int i = 0; i <= 9; i++) {
			sum += dp[N][i];
		}
		// ����� ���
		System.out.println(sum % 1000000000);
		
//		int dp = 9;
//		
//		int cnt = 0, start, end, SW;
//		if(N >= 2) {
//			cnt = 0;
//			start = (int)Math.pow(10, N - 1);
//			end = (int)Math.pow(10, N);
//			for(int j = start; j < end; j++) {
//				String str = String.valueOf(j);
//				SW = 0;
//				for(int k = 1; k < str.length(); k++) {
//					int diff = str.charAt(k) - str.charAt(k - 1);
//					if(diff != 1 && diff != -1) break;
//					if(k == str.length() - 1) {
//						SW = 1;
//					}
//				}
//				if(SW == 1) cnt++;
//			}
//			dp = cnt;
//		}
//		System.out.println(dp);
	}

}
