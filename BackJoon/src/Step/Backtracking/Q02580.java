package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 10칸을 가진 visited[]을 생성하여, 1 ~ 9의 숫자가 존재하는지를 체크한다.
// 특정 칸이 비어있을 때, 해당 행과 열과 속하는 9칸의 숫자들을 탐색하여 이미 존재하는 숫자의 visited[]를 true로 만든다.
// 1 ~ 9중 visited[]가 false인 숫자를 넣는다.
// 속하는 9칸을 탐색할 땐, 3으로 나눈 몫과 나머지를 이용한다.
// 1개의 숫자만 false라면 해당 숫자를 넣고 종료, 여러 개의 숫자가 false라면 전부 넣어봐야 한다.
// 전부 넣어보는 경우, 하나의 숫자를 넣고 다음 빈칸을 탐색한다.
// 다음 빈칸에 들어올수 있는 수가 없을 경우 이전으로 돌아오며 전부 넣어보는 경우의 칸까지 돌아와서 다음 숫자를 넣고 다시 진행한다.
// 비어있는 칸이 나올때마다 visited[]배열은 초기화시키고 살펴봐야한다.

// DFS Method내에서 다음 빈칸을 탐색해야되나? 그럼 시작은 그냥 0,0위치로 보내버리고...?
public class Q02580 {
	// 스도쿠 전체를 저장할 변수
	static int[][] arr = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스도쿠에서 빈칸을 의미하는 공간을 저장할 List변수
		List<Integer[]> list = new ArrayList<>();
		
		// 스도쿠 칸 입력받기
		for(int i = 0; i < 9; i++) {
			// 한줄씩 입력받아서 스도쿠 칸 채우기
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
				// 0이 빈 공간을 의미하므로 List에 추가
				if(arr[i][j] == 0)
					list.add(new Integer[] {i, j});
			}
		}
		
		// List와 List의 index를 이용하여 DFS 진행
		DFS(list, 0);
	}
	public static void DFS(List<Integer[]> list, int seq) {
		// 스도쿠의 빈칸을 채우는 결과가 여러개가 나올 수 있지만, 그 중 첫번째를 선택하기 위하여
		// Testcase 중에 전부 빈칸이 되어있는 case가 존재한다고 함, 그럴경우 여러개의 스도쿠 결과가 나오기 때문에 첫번째 결과에서 종료해야함
		// List의 size보다 크거나 같아진다면 (클 경우는 없겠지만,) 
		if(seq >= list.size()) {
			// 현재 상태의 스도쿠 출력
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			// 프로그램 종료
			System.exit(0);
		}
		boolean[] visited = new boolean[10];
		
		Integer[] tmp = list.get(seq);
		int row = tmp[0];
		int col = tmp[1];
		
		for(int i = 0; i < 9; i++) {
			visited[arr[row][i]] = true;
			visited[arr[i][col]] = true;
		}
		int tmpRow = row / 3, tmpCol = col / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				visited[arr[tmpRow * 3 + i][tmpCol * 3 + j]] = true;
			}
		}
		
		for(int i = 1; i < 10; i++) {
			if(!visited[i]) {
				arr[row][col] = i;
				DFS(list, seq + 1);
				arr[row][col] = 0;
			}
		}
	}
}
