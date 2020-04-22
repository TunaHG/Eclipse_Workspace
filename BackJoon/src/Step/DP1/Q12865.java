package Step.DP1;

import java.util.Scanner;

public class Q12865 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 물품의 수
		int N = scan.nextInt();
		// 버틸 수 있는 무게 (최대무게)
		int K = scan.nextInt();
		
		// 물품의 무게를 저장할 Array
		int weight[] = new int[N + 1];
		// 물품의 가치를 저장할 Array
		int value[] = new int[N + 1];
		// 행은 몇번째 아이템인지를 의미하고, 열은 전체 무게를 의미하는 DP Array
		int dp[][] = new int[N + 1][K + 1];		
		
		// 무게와 가치 Array 값 입력
		for(int i = 1; i <= N; i++) {
			weight[i] = scan.nextInt();
			value[i] = scan.nextInt();
		}
		
		// DP
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				// 기본적으로 해당 값은 위의 값이다.
				dp[i][j] = dp[i - 1][j];
				// 전체 무게를 의미하는 j에서 자신의 무게를 의미하는 weight[i]를 뺐을때 0이상이라는 것이 무게가 남아서 i번째 아이템이 들어갈 수 있다는 의미.
				if(j - weight[i] >= 0) {
					// 위의 값과 전체무게 j에서 자신의 무게 weight[i]를 뺀 값에 해당하는 무게를 이전 아이템의 값에서 가져와서 자신값을 더한값을 비교한다.
					// Backjoon에서 주어진 테스트 케이스를 예시로 들어보면,
					// 7의 무게를 가질수 있는 7번째 열에서 3번째 아이템의 무게 3을 빼면 4가 남는다.
					// 그렇다면 2번째 아이템을 의미하는 행에서 무게 4에 해당하는 열의 값을 가져온다.
					// 가져온 값과 3번째 아이템의 가치를 더해서 2번째아이템의 무게7에 해당하는 가치와 비교한다는 것.
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
//		for(int i = 0; i <= N; i++) {
//			for(int j = 0; j <= K; j++) {
//				System.out.print(dp[i][j] + "\t");
//			}
//			System.out.println();
//		}
	}
}
//8 4
//1 3
//1 6
//1 3
//1 3
//1 3
//1 2
//1 5
//1 8