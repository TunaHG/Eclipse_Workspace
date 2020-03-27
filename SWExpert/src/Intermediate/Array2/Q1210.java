package Intermediate.Array2;

import java.util.Scanner;

public class Q1210 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 100 x 100 배열을 만드는데,
		// 맨 왼쪽열과 맨 오른쪽열에서 그 왼쪽열과 오른쪽열을 비교해야되므로 열만 2를 추가
		int arr[][] = new int[100][102];
		
		// 전체 테스트 케이스 개수
		int T = 10;
		// 테스트 케이스 개수 만큼 반복
		while(T-- > 0) {
			// 테스트 케이스 번호
			int num = scan.nextInt();
			
			// 각 테스트 케이스마다 배열입력받음
			for(int i = 0; i < 100; i++) {
				// 열을 2개 추가해줬으니 열을 의미하는 j값의 범위가 변경된것에 주의
				for(int j = 1; j <= 100; j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			
			// 결과갑 초기화
			int result = 1;
			// 전체 열을 반복하는 반복문, for문 내에 while문을 쓸것인데 for문을 break시킬 예정이므로 A : 를 사용하여 이름을 붙여줌
			A : for(int i = 1; i <= 100; i++) {
				// 첫행의 열값이 1이라면 시작, 아니면 다음열
				if(arr[0][i] == 1) {
					// 값이 1인 배열들을 탐색할 row, col변수 선언
					int row = 0;
					int col = i;
					// 왼쪽과 오른쪽 방향을 의미할 direction 생성 (-1 : 왼쪽, 0 : 아래, 1 : 오른쪽)
					int direction = 0;
					// 마지막행에 도달하지 않는한 계속 반복
					while(row < 100) {
						// 마지막행에 도달했을때
						if(row == 99) {
							// 그 결과값이 2라면 결과값에 시작 열을 저장하고 for문을 break
							if(arr[row][col] == 2) {
								result = i - 1;
								break A;
							}
							// 결과값이 2가 아니라면 다음 사다리를 타기위해 for문을 continue
							else {
								continue A;
							}
						}
						// 왼쪽또는 오른쪽에 값이 1이면 아래의 값이 1이여도 왼쪽또는 오른쪽으로 먼저가도록 IF문을 먼저 선언
						// 오른쪽 배열의 값이 1이고, 왼쪽으로 이동중이던 것이 아니라면
						if(arr[row][col + 1] == 1 && direction != -1) {
							// 방향을 오른쪽으로 설정
							direction = 1;
							// 오른쪽으로 이동
							col++;
							// 다음 IF문들은 탐색할 이유가 없음
							continue;
						}
						// 왼쪽 배열의 값이 1이고, 오른쪽으로 이동중이던 것이 아니라면
						if(arr[row][col - 1] == 1 && direction != 1) {
							// 방향을 왼쪽으로 설정
							direction = -1;
							// 왼쪽으로 이동
							col--;
							// 다음 IF문을 탐색할 이유가없음
							continue;
						}
						// 해당 IF문 까지 도달했다는 것은 왼쪽 또는 오른쪽으로 이동하다가 전부 이동하고 아래로 이동해야하는 경우가 됨
						// 아래 배열의 값이 1이거나 2라면
						if(arr[row + 1][col] == 1 || arr[row + 1][col] == 2) {
							// 방향을 아래로 설정
							direction = 0;
							// 아래로 이동
							row++;
							continue;
						}
					}
				}
			}
			// 각 테스트케이스마다 결과값 출력
			System.out.println("#" + num + " " + result);
		}
	}

}
