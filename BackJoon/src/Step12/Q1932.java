package Step12;
import java.util.Scanner;

public class Q1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		// 첫번째 행과 열에는 0의 값을 넣기 위해서 사이즈를 1씩 크게 배열 선언
		int arr[][] = new int[n + 1][n + 1];
		
		// 두번째 행부터 삼각형을 만들기 위해 1부터 n까지 첫번째 반복문
		for(int i = 1; i <= n; i++) {
			// 삼각형의 크기가 행이 1씩 늘어날수록 열도 1씩 늘어나므로 1부터 i까지 두번째 반복문
			for(int j = 1; j <= i; j++) {
				// 삼각형 해당 위치의 크기를 잠시 저장할 임시 변수 입력
				int tmp = scan.nextInt();
				// 임시 변수와 그 위의 삼각형 값들의 합들을 계산해서 더 큰값을 입력
				arr[i][j] = tmp + Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
			}
		}
		// 최대값을 비교하기 위한 결과 초기값 설정
		int result = arr[n][1];
		// 마지막 행의 모든 값을 비교하며 가장 큰 값을 결과로 설정
		for(int i = 2; i <= n; i++) {
			result = Math.max(result, arr[n][i]);
		}
		
		System.out.print(result);
	}

}
