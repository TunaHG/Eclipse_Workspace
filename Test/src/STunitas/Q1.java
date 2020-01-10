package STunitas;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		
		// 열차 수, 개조 가능한 최대비용, 최대속력(결과), 개조비용 합, 최소속력
		int N, M, num, sum, min;
		// 열차 속도, 개조 비용 배열
		int train[], cost[];
		
		// T만큼 반복
		while(T-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			train = new int[N];
			cost = new int[N];
			min = 1000000000;
			
			for(int i = 0; i < N; i++) {
				train[i] = sc.nextInt();
				if(train[i] < min) min = train[i];
			}
			for(int i = 0; i < N; i++) {
				cost[i] = sc.nextInt();
			}
			
			// 최대속력 초기화
			num = min + 1;
			while(true) {
				// 개조비용 합 초기화
				sum = 0;
				// 열차 개수만큼 반복
				for(int i = 0; i < N; i++) {
					// 열차 속도가 최대속도보다 빠르다면 합산하지 않음
					if(num <= train[i]) continue;
					// (최대속도 - 속도) * 개조비용을 각 열차마다 계산하여 합산
					sum += (num - train[i]) * cost[i];
				}
				// 개조비용 합이 최대비용을 넘을 때 반복문 out
				if(sum > M) {
					num--;
					break;
				}
				// 최대속도 + 1
				num++;
			}
			// 결과 출력
			System.out.println(num);
		}
		sc.close();
	}

}
/*
3
5 100
1 2 3 4 5
5 4 3 2 1
5 10
1 2 3 4 5
5 4 3 2 1
5 1
1 2 3 4 5
5 4 3 2 1

9
2
1
*/