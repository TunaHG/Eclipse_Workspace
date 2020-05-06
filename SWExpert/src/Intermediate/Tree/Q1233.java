package Intermediate.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 결과값 변수
		int result;
		// 연산자가 포함된 String (비교를 위해 존재)
		String operator = "+-*/";
		// tree를 저장할 배열 변수
		String[] tree;
		// 각 테스트케이스마다 번호를 가지도록 반복문
		for(int testNum = 1; testNum <= 10; testNum++) {
			// 결과값 초기화
			result = 1;
			// node개수 입력
			int N = Integer.parseInt(br.readLine());
			// node개수만큼 tree크기 설정(각 index를 node의 번호로 사용하기 위해 +1의 크기로 설정)
			tree = new String[N + 1];
			
			// node의 개수만큼 반복
			while(N-- > 0) {
				// 각 node의 정보 입력
				String[] node = br.readLine().split(" ");
				
				// 각 node의 data 입력
				tree[Integer.parseInt(node[0])] = node[1];
				// 각 node의 data가 연산자가 아닌 숫자일때, node의 크기가 3이상이란 것은 자식노드가 존재한다는 의미
				// 숫자일때 자식노드가 존재하면 수식이 에러
				if(!operator.contains(node[1]) && node.length >= 3) {
					// 결과값 0
					result = 0;
				}
			}
			// 각 테스트케이스마다 결과값 출력
			System.out.println("#" + testNum + " " + result);
		}
	}

}
