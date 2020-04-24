package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	static int[][] arr = new int[9][9];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		
	}
	public static void DFS() {
		
	}
}
