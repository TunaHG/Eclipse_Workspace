package Intermediate.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1226 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 필요한 변수 선언
		// Queue는 row와 col을 가지고 있는 1차원배열로 Generic을 선언
		Queue<Integer[]> queue;
		int[][] maze;
		boolean[][] visited;
		
		// Test Case 개수 선언
		int T = 10;
		// Test Case개수만큼 반복
		while(T-- > 0) {
			// 선언한 변수들 초기화
			queue = new LinkedList<Integer[]>();
			maze = new int[16][16];
			visited = new boolean[16][16];
			
			// Test Case Number 입력
			int tNum = Integer.parseInt(br.readLine());
			
			// maze값 입력
			for(int i = 0; i < 16; i++) {
				String[] tmp = br.readLine().split("");
				for(int j = 0; j < 16; j++) {
					maze[i][j] = Integer.parseInt(tmp[j]);
					if(maze[i][j] == 2) {
						queue.add(new Integer[] {i, j});
					}
				}
			}
			// 결과값 초기화
			int result = 0;
			// Queue가 공백상태가 될때까지 반복문
			while(!queue.isEmpty()) {
				// 원소하나를 추출하여 row값과 col값으로 분리
				Integer[] target = queue.poll();
				int row = target[0];
				int col = target[1];
				
				// 해당 위치를 방문했다고 표시
				visited[row][col] = true;
				
				// 해당 위치의 maze값이 3이라면 도착점에 도달했으므로 결과값을 1로 수정하고 반복문 종료
				if(maze[row][col] == 3) {
					result = 1;
					break;
				}
				// 해당 위치에서 상하좌우로 1이 아닌 위치와 방문한 적이 없는 위치만 갈 수 있음
				// 그러한 위치들만 Queue에 Add
				if(maze[row + 1][col] != 1 && visited[row + 1][col] != true)
					queue.add(new Integer[] {row + 1, col});
				if(maze[row - 1][col] != 1 && visited[row - 1][col] != true)
					queue.add(new Integer[] {row - 1, col});
				if(maze[row][col + 1] != 1 && visited[row][col + 1] != true)
					queue.add(new Integer[] {row, col + 1});
				if(maze[row][col - 1] != 1 && visited[row][col - 1] != true)
					queue.add(new Integer[] {row, col - 1});
			}
			// 각 Test Case마다 결과 출력
			System.out.println("#" + tNum + " " + result);
		}
	}

}
