package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나는 퀸이 놓였을 때 다음 퀸이 오지 못할 장소를 미리 표기해두도록 코딩했음.
// 48줄 코딩한사람은 다음 퀸이 오는 위치에서 범위를 탐색하여 이전퀸들이 있는지를 파악했음
public class Q09663 {
	static int N;
	static boolean visited[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		int arr[][] = new int[N][N];
		result = 0;
		
		// 첫 번째 행의 모든 열을 탐색하는 반복문
		for(int i = 0; i < N; i++) {
			// 배열 초기화
			arr = new int[N][N];
			// 재귀함수 호출
			nQueen(arr, 0, i);
		}
		System.out.println(result);
	}
	public static void nQueen(int[][] arr, int row, int col) {
		// 입력받은 row, col위치에 Queen이 놓여졌다는 의미이므로
		// Queen의 위치에서 놓을 수없는 모든 장소에 1을 입력
		
		// 현재 Queen의 위치에 1을 입력
		arr[row][col]++;
		// 오른쪽으로 향하는 부분에 전부 1을 입력
		for(int i = col + 1; i < N; i++) {
			arr[row][i]++;
		}
		// 아래로 향하는 부분에 전부 1을 입력
		for(int i = row + 1; i < N; i++) {
			arr[i][col]++;
		}
		// 왼쪽 아래로 향하는 대각선에 해당하는 부분에 전부 1을 입력
		for(int i = col; i > 0; i--) {
			if(row + col + 1 - i >= N)
				break;
			arr[row + col + 1 - i][i - 1]++;
		}
		// 오른쪽 아래로 향하는 대각선에 해당하는 부분에 전부 1을 입력
		for(int i = col + 1; i < N; i++) {
			if(row - col + i >= N)
				break;
			arr[row - col + i][i]++;
		}

		// N-1 행에 도달했다는 의미는 N-1 행에 Queen을 놓을 장소가 존재한다는 의미
		// 놓을 장소가 존재하면 놓고 끝이므로 결과값에 1을 더하고 재귀함수 종료
		// 재귀함수의 처음이 아닌 아래에 둔 이유는 재귀함수가 종료되고 값을 되돌리는 과정에
		// 마지막 과정이 포함되어야 하기 때문
		if(row >= N - 1) {
			result++;
			return ;
		}
		
		// 다음 행의 모든 열에 대해 살펴보기 위한 반복문
		for(int i = 0; i < N; i++) {
			// 1이 아닌 값이 나오면 Queen을 놓을 수 있는 장소임을 의미
			if(arr[row + 1][i] == 0) {
				nQueen(arr, row + 1, i);
				// arr배열은 주소값이 넘어가서 1로 변경한값이 원래대로 돌아오지 않으므로
				// 1로 변경했던 모든값들은 0으로 변경해줘야함
				// 
				arr[row + 1][i]--;
				// 오른쪽으로 향하는 부분에 전부 0을 입력
				for(int j = i + 1; j < N; j++) {
					arr[row + 1][j]--;
				}
				// 아래로 향하는 부분에 전부 0을 입력
				for(int j = row + 1  + 1; j < N; j++) {
					arr[j][i]--;
				}
				// 왼쪽 아래로 향하는 대각선에 해당하는 부분에 전부 0을 입력
				for(int j = i; j > 0; j--) {
					if(row + 1  + i + 1 - j >= N)
						break;
					arr[row + 1  + i + 1 - j][j - 1]--;
				}
				// 오른쪽 아래로 향하는 대각선에 해당하는 부분에 전부 0을 입력
				for(int j = i + 1; j < N; j++) {
					if(row + 1  - i + j >= N)
						break;
					arr[row + 1  - i + j][j]--;
				}
			}
		}
	}
}
