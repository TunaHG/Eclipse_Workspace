package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[][] DP = new int[N + 1][N + 2];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i + 1; j++) {
				if(j == 1 || j == i + 1)
					DP[i][j] = 1;
				else
					DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j]) % 10007;
			}
		}
		
		System.out.println(DP[N][K + 1]);
	}

}
