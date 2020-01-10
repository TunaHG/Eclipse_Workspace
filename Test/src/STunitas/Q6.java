package STunitas;

import java.util.Scanner;

public class Q6 {
	static int num;
	static int lim = 4;
	static int cnt;
	// 재귀함수 생성
	public static void fourSum(int startNum, int sum, int seq) {
		// 4번째 수에 도달했으면서 sum이 num이므로 cnt + 1후 return
		if(sum == num && seq == lim) {
			cnt++;
			return;
		}
		// 4번째 수에 도달했는데 sum이 num이 아니면 그냥 return
		if(seq >= lim) return;
		
		// 2+1+1+1과 1+1+1+2와 같은 중복을 없애기 위해 후반에 나오는 숫자는 전반에 나온 숫자보다 작을수 없도록 하여 반복
		for(int i = startNum; i < num - 2; i++) {
			fourSum(i, sum + i, seq + 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 입력
		int T = sc.nextInt();
		
		// 테스트 케이스만큼 반복
		while(T-- > 0) {
			// 목표 수 입력
			num = sc.nextInt();
			
			// 카운트 초기화
			cnt = 0;

			// 4 이하면 계산하지 않아도 0임
			if(num < 4) System.out.println(0);
			else {
				// 재귀함수 호출
				fourSum(1, 0, 0);
				// 계산된 경우의 수 출력
				System.out.println(cnt);
			}
		}
		sc.close();
	}

}
/*
2
3
5

0
1
*/