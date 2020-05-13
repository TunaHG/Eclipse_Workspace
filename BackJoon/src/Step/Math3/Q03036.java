package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q03036 {
	// 최대공약수 구하는 재귀함수
	static int GCD(int num1, int num2) {
		// 재귀호출을 살펴보면 num2는 num1 % num2이므로 이 값이 0이라면 종료한다.
		if(num2 == 0)
			return num1;
		// num1 % num2의 값이 0일 때의 num2가 최대 공약수이다.
		return GCD(num2, num1 % num2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 링의 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 링의 반지름을 입력받을 배열 선언
		int[] ring = new int[N];
		// 링의 반지름 입력
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			ring[i] = Integer.parseInt(input[i]);
		}
		
		// 첫 번째 링의 반지름 값
		int num1 = ring[0];
		// 두 번째부터 마지막까지의 링의 반지름 값
		for(int i = 1; i < N; i++) {
			int num2 = ring[i];
			// 두 값의 최대공약수 산출
			int gcd = GCD(num1, num2);
			 
			// 기약분수 형태로 나타내야 하므로 각 값을 최대공약수로 나눈 값으로 출력
			System.out.println((num1 / gcd) + "/" + (num2 / gcd));
		}
	}

}
