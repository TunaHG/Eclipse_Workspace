package Intermediate.Array2;

import java.util.Scanner;

public class Q1209 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 100 x 100 크기의 배열 선언
		int arr[][] = new int[100][100];
		
		// 테스트케이스 10번 변수선언
		int T = 10;
		// 테스트케이스 10번만큼 반복
		while(T-- > 0) {
			// 주어지는 테스트케이스 번호 입력 
			int testNum = scan.nextInt();
			// 주어지는 배열의 값 입력
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			
			// 최대값을 입력받을 결과값 변수
			int result = 0;
			// 각 대각선의 합을 입력받을 변수
			int crossSum1 = 0, crossSum2 = 0;
			// 배열의 행의 크기만큼 반복
			for(int i = 0; i < 100; i++) {
				// 열의 합과 행의 합을 0으로 초기화
				int rowSum = 0, colSum = 0;
				// 배열의 열의 크기만큼 반복
				for(int j = 0; j < 100; j++) {
					// 행의 합은 i를 행으로 j를 열로 사용하면 산출됨
					rowSum += arr[i][j];
					// 열의 합은 i를 열로 j를 행으로 사용하면 산출됨
					colSum += arr[j][i];
					// i + j가 99가 되면 오른쪽위부터 왼쪽아래까지 진행되는 대각선의 합이 산출됨
					if(i + j == 99)
						crossSum1 += arr[i][j];
					// i값과 j값이 같으면 왼쪽위부터 오른쪽아래까지 진행되는 대각선의 합이 산출됨
					if(i == j)
						crossSum2 += arr[i][j];
				}
				// 행의합과 열의합, 최대값으로 입력되어 있던 값 3개를 비교하여 최대값을 갱신
				result = Math.max(result, Math.max(rowSum, colSum));
			}
			// 최대값으로 입력되어 있던 값과 각 대각선의 합을 비교하여 최대값을 갱신
			result = Math.max(result, Math.max(crossSum1, crossSum2));
			// 테스트케이스마다 결과를 출력
			System.out.println("#" + testNum + " " + result);
		}
	}

}
