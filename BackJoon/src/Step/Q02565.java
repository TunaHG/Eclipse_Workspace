package Step;

import java.io.*;
import java.util.StringTokenizer;

public class Q02565 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int elec[] = new int[501];
		int dp[] = new int[501];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			elec[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= 500; i++) {
			if(elec[i] > 0) dp[i] = 1;
			else continue;
			for(int j = 1; j < i; j++) {
				if(elec[i] > elec[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
	}

}
