package Intermediate.Stack1;

import java.io.*;

public class Q1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// (, {, [, <에 해당하는 개수를 Count할 배열 선언
		int[] arr;
		// 결과값을 가질 변수 선언
		int result;
		// 테스트 케이스 10개만큼 반복
		for(int tNum = 1; tNum <= 10; tNum++) {
			// 결과값 1로 초기화 (문제가 없으면 1로 출력할 것이기 떄문에)
			result = 1;
			// 주어지는 문자열의 길이 입력
			int len = Integer.parseInt(br.readLine());
			
			// Count할 배열 초기화
			arr = new int[4];
			
			// 주어지는 문자열 입력
			String str = br.readLine();
			// 문자열의 길이만큼 반복하는 반복문
			A : for(int i = 0; i < len; i++) {
				// 첫번째 문자부터 끝문자까지 switch-case문을 통하여 구현
				// switch-case문이기 때문에 각 break를 선언해야함에 조심
				switch(str.charAt(i)) {
				// '('라면 배열의 0번째 값을 1추가
				case '(':
					arr[0]++;
					break;
				// ')'라면 배열의 0번째 값이 0보다 큰지 확인
				case ')':
					if(arr[0] > 0) {
						// 0보다 크다면 (가 나왔었다는 의미이므로 1줄이고 break
						arr[0]--;
						break;
					}
					// 해당 Code가 실행된다는 것은 배열의 0번째 값이 0보다 크지 않다는 의미이므로
					// '('가 나온적이 없거나 이미 나온 '('는 ')'로 이미 전부 상쇄된 상황
					// 그러므로 ')'가 잘못나온것이 됨. 그렇다면 해당 문자열은 유효하지 않으므로 결과값에 0을 입력하고 반복문 종료
					result = 0;
					break A;
				// '(', ')'의 동작에서 배열의 Index만을 변경한 것이므로 주석을 생략
				case '{':
					arr[1]++;
					break;
				case '}':
					if(arr[1] > 0) {
						arr[1]--;
						break;
					}
					result = 0;
					break A;
				case '[':
					arr[2]++;
					break;
				case ']':
					if(arr[2] > 0) {
						arr[2]--;
						break;
					}
					result = 0;
					break A;
				case '<':
					arr[3]++;
					break;
				case '>':
					if(arr[3] > 0) {
						arr[3]--;
						break;
					}
					result = 0;
					break A;
				}
			}
			// 결과값 출력
			System.out.println("#" + tNum + " " + result);
		}
	}

}
