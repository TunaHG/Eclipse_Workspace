package Intermediate.Stack1;

import java.io.*;

public class Q1217 {
	// 거듭제곱을 진행하는 재귀함수
	public static int multiply(int N, int M) {
		// M이 1보다 작아지면 1을 return
		if(M < 1)
			return 1;
		// N, M - 1을 인자로 가지는 재귀함수 호출과 해당 재귀함수의 결과값에 N을 곱함
		return N * multiply(N, M - 1); 
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수
		int T = 10;
		
		// 테스트 케이스 개수만큼 반복
		while(T-- > 0) {
			// 테스트 케이스 넘버 입력
			int tNum = Integer.parseInt(br.readLine());

			// 주어지는 값 N, M 입력
			String[] input = br.readLine().split(" ");
			
			// 재귀함수 호출
			int result = multiply(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			
			// 각 테스트 케이스마다 결과값 출력
			System.out.println("#" + tNum + " " + result);
		}
	}

}
