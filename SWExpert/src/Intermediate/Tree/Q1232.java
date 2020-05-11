package Intermediate.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1232 {
	// 이진트리를 저장할 tree배열 변수
	static String[][] tree;
	// 이진트리의 중위연산을 수행할 DFS 재귀method
	static double DFS(int target) {
		// 연산자를 비교할 변수
		String operator = "+-*/";
		// node의 data가 연산자가 아니라면
		if (!operator.contains(tree[target][0]))
			// 숫자라는 의미이므로 DFS를 더 진행하지 않고 숫자를 반환
			return Double.parseDouble(tree[target][0]);

		// 연산자라면 왼쪽 부분트리와 오른쪽 부분트릐의 연산을 진행
		double num1 = DFS(Integer.parseInt(tree[target][1]));
		double num2 = DFS(Integer.parseInt(tree[target][2]));

		// DFS의 결과값 변수
		double result = 0;
		// 각 연산자에 해당하는 연산을 수행
		switch (tree[target][0]) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		// 결과값 return
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 10번만큼 반복
		for (int testNum = 1; testNum <= 1; testNum++) {
			// node(정점)의 개수 입력
			int N = Integer.parseInt(br.readLine());

			// node의 개수를 통한 tree의 크기 선언
			// 2차원배열로 선언하고 [3]의 크기를 지정한 이유
			// => 해당 node의 data를 저장할 첫 번째 공간, 왼쪽자식을 저장할 두 번째 공간, 오른쪽자식을 저장할 세 번째 공간
			//    완전 이진트리라면 이 방법을 사용하지 않아도 된다.(문제에서 완전이진트리라고 언급하지 않았음)
			tree = new String[N + 1][3];
			// node의 개수만큼 반복하여 값을 입력
			for (int i = 0; i < N; i++) {
				// node의 정보 입력
				String[] node = br.readLine().split(" ");
				// node의 첫번째값은 node번호이다.
				int nodeNum = Integer.parseInt(node[0]);

				// node의 data입력
				tree[nodeNum][0] = node[1];
				// node의 크기가 3보다 크면, 왼쪽 자식이 존재한다는 의미
				if (node.length >= 3)
					tree[nodeNum][1] = node[2];
				// node의 크기가 4보다 크면, 오른쪽 자식이 존재한다는 의미
				if (node.length >= 4)
					tree[nodeNum][2] = node[3];
			}

			// 재귀함수를 호출하여 결과값 연산
			double result = DFS(1);
			// 결과값 출력
			System.out.println("#" + testNum + " " + (int) result);
		}
	}

}
