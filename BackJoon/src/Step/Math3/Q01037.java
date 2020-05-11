package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01037 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받는 약수의 개수
		int N = Integer.parseInt(br.readLine());
		
		// 입력받는 약수
		String[] factor = br.readLine().split(" ");
		
		// 약수들의 최대값과 최소값 탐색
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		// 전체 약수를 탐색
		for(int i = 0; i < N; i++) {
			// 최소값과 최대값 탐색
			max = Math.max(max, Integer.parseInt(factor[i]));
			min = Math.min(min, Integer.parseInt(factor[i]));
		}
		
		// 최대값과 최소값을 곱하면 결과값
		System.out.println(max * min);
	}

}
