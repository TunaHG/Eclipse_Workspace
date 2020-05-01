package Step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		// 동전의 종류 개수 입력
		int N = Integer.parseInt(NK[0]);
		// 맞춰야 하는 금액 입력
		int K = Integer.parseInt(NK[1]);
		
		// 동전의 종류 선언 및 입력
		int[] money = new int[N];
		for(int i = N - 1; i >= 0; i--) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		// 총 동전의 개수를 Counting할 변수 선언 및 초기화
		int cnt = 0;
		// 동전의 종류 탐색
		for(int i = 0; i < N; i++) {
			// K에서 해당 동전의 종류로 나눈 값을 동전의 개수로 추가
			// K가 4200일때, 1000을 만나면 4개의 개수를 추가
			cnt += K / money[i];
			// K는 나머지값을 입력
			// K가 4200일때, 1000을 만나면 K는 남은 200이 됨
			K = K % money[i];
		}
		
		// 동전의 개수 출력
		System.out.println(cnt);
	}

}
