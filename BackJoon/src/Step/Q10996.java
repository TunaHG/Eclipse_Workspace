package Step;

import java.util.Scanner;

public class Q10996 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 주어진 값 입력받기
		int N = scan.nextInt();
		// 입력받은 값으로 출력할 값이 들어갈 2차원 배열 생성
		char arr[][] = new char[N * 2][N];
		
		// N이 1이라면 배열과 상관없이 동작
		if(N == 1) {
			// *하나 출력
			System.out.print("*");
			// Method 종료해서 이후의 출력이 실행되지 못하게함
			return;
		}
		// N이 1이 아니라면
		else {
			// N * 2의 행을 탐색할 반복문
			for(int i = 0; i < N * 2; i++) {
				// i값이 짝수라면 첫 열의 값은 *
				if(i % 2 == 0) 
					arr[i][0] = '*';
				// i값이 홀수라면 첫 열의 값은 공백
				else
					arr[i][0] = ' ';
				// 첫 열의 값을 이용하여 두번째 열부터 값을 채우는 반복문
				for(int j = 1; j < N; j++) {
					// 이전 열의 값이 *라면 해당 열의 값은 공백
					if(arr[i][j - 1] == '*')
						arr[i][j] = ' ';
					// 이전 열의 값이 공백이라면 해당 열의 값은 *
					else
						arr[i][j] = '*';
				}
			}
		}
		
		// 전체 배열 출력
		for(int i = 0; i < N * 2; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
