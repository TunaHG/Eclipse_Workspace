package Step12;
import java.util.Scanner;

public class Q10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		// 자릿수가 몇개인지를 나타낼 행과 0 ~ 10인 마지막 숫자를 나타낼 열
		long dp[][] = new long[101][11];
		
		// 자릿수가 한개인 1 ~ 9의 첫값은 1
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		// 자릿수가 두개인것 부터 원하는 자릿수까지 반복문
		for(int i = 2; i <= N; i++) {
			// 마지막 자리수가 0인 값은 이전의 행의 1의 개수와 같음
			dp[i][0] = dp[i - 1][1];
			// 마지막 자리수 1부터 9까지의 반복문
			for(int j = 1; j <= 9; j++) {
				// 각 마지막 자리수는 이전 행의 마지막자리수 -1과 마지막자리수 +1의 값의 합과 같음
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}
		
		// 결과값을 저장할 변수
		long sum = 0;
		// 0부터 9까지의 나타난 횟수를 결과값에 더함
		for(int i = 0; i <= 9; i++) {
			sum += dp[N][i];
		}
		// 결과값 출력
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
