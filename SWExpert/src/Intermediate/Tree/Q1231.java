package Intermediate.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1231 {
	// 입력받는 tree를 저장할 변수 (DFS, main 두 method에서 사용하기 때문에 static선언)
	static String[][] tree;
	// tree를 탐색할 DFS method
	public static void DFS(int target) {
		// 본인의 왼쪽 자식노드가 존재한다면, 재귀함수 호출
		if(tree[target][1] != null) {
			DFS(Integer.parseInt(tree[target][1]));
		}
		// 본인의 String 출력
		System.out.print(tree[target][0]);
		// 본인의 오른쪽 자식노드가 존재한다면, 재귀함수 호출
		if(tree[target][2] != null) {
			DFS(Integer.parseInt(tree[target][2]));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트케이스 10번만큼 번호를 가지고 반복
		for(int testNum = 1; testNum <= 10; testNum++) {
			// 총 tree의 개수 입력
			int N = Integer.parseInt(br.readLine());
			// tree의 개수만큼 배열 선언
			// 각 index자체를 node의 번호로 사용하기 위해 N+1만큼 선언
			// 2차원 중 [0]은 해당 node의 data, [1]은 왼쪽 자식노드, [2]는 오른쪽 자식노드
			tree = new String[N + 1][3];
			// tree의 개수만큼 반복
			while(N-- > 0) {
				// 해당 node의 정보 입력
				String[] node = br.readLine().split(" ");
				// node의 위치
				int loc = Integer.parseInt(node[0]);
				// node의 data 입력
				tree[loc][0] = node[1];
				// node의 길이에 따라 입력값이 변경
				// node의 길이가 4라면 왼쪽, 오른쪽 자식노드가 모두 존재함을 의미
				if(node.length == 4) {
					// 각 자식노드의 위치를 입력
					tree[loc][1] = node[2];
					tree[loc][2] = node[3];
				} 
				// node의 길이가 3이라면 왼쪽 자식노드만 존재함을 의미
				else if(node.length == 3) {
					// 왼쪽 자식노드의 위치를 입력
					tree[loc][1] = node[2];
					// 오른쪽 자식노드는 존재하지 않으므로 null(default가 null이므로 처리하지 않아도 충분)
					tree[loc][2] = null;
				} 
				// node의 길이가 2라면 자식노드가 존재하지 않음을 의미
				else {
					// 각 자식노드에 null값 입력(default가 null값이므로 처리하지 않아도 충분
					tree[loc][1] = null;
					tree[loc][2] = null;
				}
			}
			
			// DFS를 시작할 root node 입력
			int target = 1;
			// 각 테스트케이스마다 DFS를 진행하며 결과 출력
			System.out.print("#" + testNum + " ");
			DFS(target);
			System.out.println();
		}
	}

}
