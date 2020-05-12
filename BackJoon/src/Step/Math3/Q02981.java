package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시간초과로 실패
// 기본 알고리즘 구성을 다음 사이트를 참고 : https://pangsblog.tistory.com/62
public class Q02981 {
	static int GCD(int a, int b) {
		if(b == 0)
			return a;
		return GCD(b, a % b);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 개수만큼의 크기를 가지는 배열 선언
		int[] numbers = new int[N];
		
		// 시간 초과 코드
//		int max = Integer.MIN_VALUE;
		// 배열 입력
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			// 시간 초과 코드
//			max = Math.max(max, numbers[i]);
		}
		// 배열 정렬
		Arrays.sort(numbers);
		
		// A[1] % M = A[1] - (A[1] / M) * M
		// A[2] % M = A[2] - (A[2] / M) * M
		// A[1] % M= A[2] % M
		
		// A[1] - A[2] = M * (A[1] / M  -  A[2] / M) 
		// A[2] - A[3] = M * (A[2] / M  -  A[3] / M)
		// A[N-1] - A[N] = M * (A[N-1] / M - A[N] / M)
		
		
		// A[1] - A[0] 에서 A[i] - A[i-1] 까지의 최대 공약수
		// a, b, c 세 수의 최대 공약수를 구할 때, 
		// ((a, b) 의 최대공약수, c) 의 최대공약수와 같다.
		int val = numbers[1] - numbers[0];
		for(int i = 2; i < N; i++) {
			val = GCD(val, numbers[i] - numbers[i - 1]);
		}
		
		// 구해진 최대 공약수의 약수중 1을 제외한 나머지 값을 순서대로 출력
		for(int i = 2; i <= val; i++) {
			if(val % i == 0)
				System.out.print(i + " ");
		}
		
		// 시간 초과 코드
//		int index = 2;
//		A : while(true) {
//			if(index > max)
//				break;
//			
//			int rest = numbers[0] % index;
//			for(int i = 1; i < N; i++) {
//				if(numbers[i] % index != rest) {
//					index++;
//					continue A;
//				}
//			}
//			
//			System.out.println(index++);
//		}
	}

}
