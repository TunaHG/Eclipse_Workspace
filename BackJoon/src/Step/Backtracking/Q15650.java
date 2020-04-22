package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q15650 {
	// (BT()에서 사용하기 때문에 전역변수로 선언)
	static int M;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 주어지는 두 값을 입력받음
		String[] str = br.readLine().split(" ");
		// 값의 범위를 의미하는 변수 입력
		M = Integer.parseInt(str[0]);
		// 고르는 값의 개수를 의미하는 변수 입력
		N = Integer.parseInt(str[1]);
		
		// 시작값을 입력하며 재귀함수 호출
		for(int i = 1; i <= M; i++) {
			// 시작값을 입력하며 방문기록을 초기화해야함
			visited = new boolean[M + 1];
			// 시작값의 방문기록을 true로 변경
			visited[i] = true;
			// 재귀함수 호출
			BT(String.valueOf(i), i, 1);
		}
	}
	
	// 시작값부터 N개를 골라서 출력할 재귀함수
	public static void BT(String str, int num, int size) {
		// N개가 선택되었다면 출력하고 재귀함수 종료
		if(size >= N) {
			System.out.println(str);
			return ;
		}
		// 값의 방문기록 true로 변경
		visited[num] = true;
		
		// num보다 큰 값들을 탐색하며 방문한적 없는 값에 대해 재귀함수 호출
		for(int i = num; i <= M; i++) {
			if(!visited[i]) {
				BT(str + " " + i, i, size + 1);
				// 재귀함수 호출 이후에는 방문기록 초기화
				visited[i] = false;
			}
		}
	}
}
