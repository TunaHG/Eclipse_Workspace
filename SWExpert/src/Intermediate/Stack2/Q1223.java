package Intermediate.Stack2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1223 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연산자를 저장할 Stack 선언
		Stack<String> stack;
		
		// 테스트 케이스 10번만큼 반복 (결과값에 테스트 케이스 번호를 출력하기 위해 1부터 10까지)
		for(int i = 1; i <= 10; i++) {
			// Stack 초기화
			stack = new Stack<>();
			// 주어지는 문자열의 길이 입력
			int len = Integer.parseInt(br.readLine());
			// 후위표현식을 저장할 String변수 선언 및 초기화
			String postfix = "";
			
			// 주어지는 문자열을 배열로 나눠서 저장
			String[] str = br.readLine().split("");
			// 주어진 문자열의 길이만큼 반복
			for(int j = 0; j < len; j++) {
				// '+'가 나오면
				if(str[j].equals("+")) {
					// '+'아닌 모든 연산자는 '*'이다.
					// '*'은 '+'보다 우선순위가 높기때문에 '+'가 들어가기 전에 전부 나와야한다.
					// '+'가 top이여도 해당 '+'를 pop하고 현재 연산자인 '+'를 push할 것이다.
					// 그러므로 stack에 저장된 모든 연산자를 후위표현식에 추가
					while(!stack.isEmpty()) {
						postfix += stack.pop();
					}
					// Stack의 모든 연산자를 출력했으므로 현재 연산자인 '+'를 push
					stack.push(str[j]);
				}
				// '*'가 나오면
				else if(str[j].equals("*")) {
					// 현재 Stack이 비어있는지 확인
					if(!stack.isEmpty()) {
						// top이 '+'인지 확인
						if(stack.peek().equals("+")) {
							// '+'라면 현재 연산자 '*'를 push하여 저장
							stack.push(str[j]);
						} else {
							// '+'가 아니라면 '*'이라는 의미이므로 pop하여 top을 후위표현식에 추가
							postfix += stack.pop();
							// 현재연산자인 '*'를 push하여 저장
							stack.push(str[j]);
						}
					} else {
						// Stack이 비어있으므로 현재 연산자 '*'를 push하여 저장
						stack.push(str[j]);
					}
				} else {
					// '+'와 '*'가 둘다 아니면 피연산자인 숫자이므로 후위표현식에 추가
					postfix += str[j];
				}
			}
			// 중위표현식 전부를 탐색후 Stack에 남은 연산자를 후위표현식에 추가
			while(!stack.isEmpty()) {
				postfix += stack.pop();
			}
			
//			System.out.println(postfix);
			
			// 후위표현식을 split을 사용하여 배열로 변환
			String[] postfixArr = postfix.split("");
			int num1, num2;
			// 후위표현식의 길이만큼 반복
			for(int j = 0; j < len; j++) {
				// 각 연산자가 나올때마다 Stack에 저장된 두개의 피연산자를 꺼내서 연산후 다시 Stack에 push하여 저장
				if(postfixArr[j].equals("+")) {
					num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push(String.valueOf(num1 + num2));
				} else if(postfixArr[j].equals("*")) {
					num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push(String.valueOf(num1 * num2));
				} else {
					// 피연산자는 바로 push하여 저장
					stack.push(postfixArr[j]);
				}
			}
			
			// 각 테스트케이스마다 결과값 출력
			System.out.println("#" + i + " " + stack.pop());
		}
	}

}
