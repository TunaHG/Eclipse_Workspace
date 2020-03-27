package Intermediate.Array2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q1211 {

	public static void main(String[] args) throws IOException {
		// Q1210과 다르게 Scanner가 아닌 BufferedReader를 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 100 x 100 배열을 만드는데,
		// 맨 왼쪽열과 맨 오른쪽열에서 그 왼쪽열과 오른쪽열을 비교해야되므로 열만 2를 추가
		int arr[][] = new int[100][102];
		
		// 전체 테스트케이스 개수
		int T = 10;
	
		// 테스트 케이스 개수만큼 반복
		while(T-- > 0) {
			// 각 테스트 케이스 번호
			int num = Integer.parseInt(br.readLine());

			// 각 테스트 케이스마다 배열입력받음
			for(int i = 0; i < 100; i++) {
				// 한 줄을 입력받은 후 공백으로 나눔
				String[] str = br.readLine().split(" ");
				// 공백으로 나눈 한 줄을 배열에 입력
				// 열을 2개 추가해줬으니 열을 의미하는 j값의 범위가 변경된것에 주의
				for(int j = 1; j <= 100; j++) {
					// split으로 나눈 배열을 String[]이므로 int로 변환
					arr[i][j] = Integer.parseInt(str[j - 1]);
				}
			}
			
			// 결과값 시작 부분의 X값을 입력받을 변수
			int resultCol = 0;
			// 최소이동거리를 비교하기위한 변수
			int resultCnt = Integer.MAX_VALUE;
			// 모든 열 탐색할 반복문
			A : for(int i = 1; i <= 100; i++) {
				// 최소이동거리를 각 열마다 입력받을 변수, 추후에 resultCnt와 비교
				int cnt = 0;
				// 첫행의 열값이 1이라면 시작, 아니면 다음열
				if(arr[0][i] == 1) {
					// 값이 1인 배열들을 탐색할 row, col변수 선언
					int row = 0;
					int col = i;
					// 왼쪽과 오른쪽 방향을 의미할 direction 생성 (-1 : 왼쪽, 0 : 아래, 1 : 오른쪽)
					int direction = 0;
					while(row < 100) {
						// 마지막행에 도달했을때
						if(row == 99) {
							// 현재 열이 입력된 최소이동거리보다 작다면
							if(cnt <= resultCnt) {
								// 결과값 갱신
								resultCnt = cnt;
								// 맨 처음 2차원 배열의 열의 크기를 102로 지정했으므로 1을 빼줘야함
								resultCol = i - 1;
							}
							// 다음 열을 탐색
							continue A;
						}
						// 왼쪽또는 오른쪽에 값이 1이면 아래의 값이 1이여도 왼쪽또는 오른쪽으로 먼저가도록 IF문을 먼저 선언
						// 오른쪽 배열의 값이 1이고, 왼쪽으로 이동중이던 것이 아니라면
						if(arr[row][col + 1] == 1 && direction != -1) {
							// 방향을 오른쪽으로 설정
							direction = 1;
							// 오른쪽으로 이동
							col++;
							// 이동거리 + 1
							cnt++;
							// 다음 IF문들은 탐색할 이유가 없음
							continue;
						}
						// 왼쪽 배열의 값이 1이고, 오른쪽으로 이동중이던 것이 아니라면
						if(arr[row][col - 1] == 1 && direction != 1) {
							// 방향을 왼쪽으로 설정
							direction = -1;
							// 왼쪽으로 이동
							col--;
							// 이동거리 + 1
							cnt++;
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
							// 이동거리 + 1
							cnt++;
							continue;
						}
					}
				}
			}
			System.out.println("#" + num + " " + resultCol);
		}
		br.close();
	}

}
