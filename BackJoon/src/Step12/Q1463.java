package Step12;
import java.util.Scanner;

public class Q1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		// 횟수를 값으로 넣을 배열 선언
		int dp[] = new int[N + 1];
		
		// 1은 연산할 필요가 없으니 횟수가 0
		dp[1] = 0;
		// N이 2이상이라면 2는 2로 나누면 1이므로 1
		if(N >= 2) dp[2] = 1;
		// N이 3이상이라면 3은 3으로 나누면 1이므로 1
		if(N >= 3) dp[3] = 1;
		
		// 이후 원하는 숫자 N까지 반복문
		for(int i = 4; i <= N; i++) {
			// 기본적으로 이전의 숫자에서 1을 늘리면 최소수
			dp[i] = dp[i - 1] + 1;
			// 2로 나누어질 경우 위의 기본 최소수와 2로 나누었을 때의 횟수 +1 중 최소값 비교
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			// 3으로 나누어질 경우 위의 기본 최소수와 3으로 나누었을 때의 횟수 +1 중 최소값 비교 
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		// 원하는 숫자의 최소횟수 출력
		System.out.print(dp[N]);
	}

}
// 출처 : https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787315353&proxyReferer=https%3A%2F%2Fwww.google.com%2F