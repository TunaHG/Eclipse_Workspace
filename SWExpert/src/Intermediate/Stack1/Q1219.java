package Intermediate.Stack1;

import java.io.*;
import java.util.StringTokenizer;

public class Q1219 {
	// 순서쌍이 저장될 2차원 배열 선언
	// 행은 특정 노드를 의미하며, 열은 해당 행이 의미하는 노드에서 뻗어나가는 노드를 의미함
	static int[][] arr;
	// 방문했던 위치는 다시 방문하지 않기 위한 배열 선언
	static boolean[] visited;
	// 출력할 결과값이 저장될 변수 선언
	// 재귀함수에서 값을 변경해주고 메인함수에서 출력할 것이므로 전역변수로 선언
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트케이스 개수
		int T = 10;
		// 주어진 문자열을 나눠서 사용할 StringTokenizer 선언
		StringTokenizer st;
		
		// 테스트케이스만큼 반복
		while(T-- > 0) {
			// 순서쌍이 저장될 배열 초기화
			arr = new int[100][100];
			// 방문했던 위치 배열 초기화
			visited = new boolean[100];
			// 결과값 초기화
			result = 0;
			
			// 테스트케이스 넘버랑 순서쌍 개수를 가진 문자열 객체화
			st = new StringTokenizer(br.readLine());
			
			// 테스트 케이스 넘버 가져오기
			int tNum = Integer.parseInt(st.nextToken());
			// 순서쌍 개수 가져오기
			int pairCount = Integer.parseInt(st.nextToken());
			
			// 순서쌍들의 문자열 객체화
			st = new StringTokenizer(br.readLine());
			// 순서쌍 개수만큼 반복
			while(pairCount-- > 0) {
				// 순서쌍의 첫번째 값으로 특정 노드를 의미하는 값
				int row = Integer.parseInt(st.nextToken());
				// 순서쌍의 두번째 값으로 특정 노드에서 뻗어나갈수 있는 노드를 의미하는 값
				int col = Integer.parseInt(st.nextToken());
				// 2차원 배열의 값을 1로 변경
				arr[row][col] = 1;
			}
			
			// 시작 노드인 A를 의미하는 0이 target
			int target = 0;
			// 재귀함수 호출
			DFS(target);
			
			// 결과값 출력
			System.out.println("#" + tNum + " " + result);
		}
	}
	// 노드를 탐색하는 재귀함수
	public static void DFS(int target) {
		// 이미 방문했던 노드라면 이후의 결과도 알고있기 때문에 바로 return
		if(visited[target])
			return;
		
		// 방문한적 없는 노드이기에 해당 Code가 실행되므로 방문했음을 의미하도록 true로 변경
		visited[target] = true;
		
		// 2차원 배열에서 모든 열을 탐색하기 위한 반복문
		for(int i = 0; i < 100; i++) {
			// 배열값이 1이고 방문한적이 없는 노드라면 재귀함수 호출
			if(arr[target][i] == 1 && visited[i] == false) {
				// 99는 도착 지점을 의미하므로 해당 값이 나온다면 도착 지점에 정상적으로 도착할 수 있다는 의미
				if(i == 99) {
					// 결과값을 1로 변경후 return
					// TODO : DFS자체를 끝내버리고 싶은데 이전에 진행중인 DFS까지 끝낼수 있는 방법이 있는지 알아봐야함
					result = 1;
					return;
				}
				// 재귀함수 호출
				DFS(i);
			}
		}
	}
}
