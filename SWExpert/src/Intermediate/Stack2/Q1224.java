package Intermediate.Stack2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1224 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 연산자를 저장할 Stack 선언
		Stack<String> stack;

		// 테스트 케이스 10번만큼 반복 (결과값에 테스트 케이스 번호를 출력하기 위해 1부터 10까지)
		for (int i = 1; i <= 10; i++) {
			// Stack 초기화
			stack = new Stack<>();
			// 주어지는 문자열의 길이 입력
			int len = Integer.parseInt(br.readLine());
			// 후위표현식을 저장할 String변수 선언 및 초기화
			String postfix = "";

			// 주어지는 문자열을 배열로 나눠서 저장
			String[] str = br.readLine().split("");
			// 주어진 문자열의 길이만큼 반복
			for (int j = 0; j < len; j++) {
				// 현재 배열의 값이 어떤 연산자인지 피연산자인지 확인
				if (str[j].equals("+")) {
					// '+'가 나오면 Stack이 비어있는지 확인
					if (!stack.isEmpty()) {
						// 비어있지 않다면 '('가 나올때까지 전부 pop하여 후위표현식에 추가
						while (!stack.peek().equals("(")) {
							postfix += stack.pop();
						}
						// 현재 연산자 '+'를 push하여 저장
						stack.push(str[j]);
					} else {
						// Stack이 비어있다면 현재 연산자를 push하여 저장
						stack.push(str[j]);
					}
				} else if (str[j].equals("*")) {
					// '*'가 나오면 Stack이 비어있는지 확인
					if (!stack.isEmpty()) {
						// 비어있지 않다면 top이 무엇인지 확인
						if (stack.peek().equals("+")) {
							// top이 '+'라면 현재연산자 '*'를 push하여 저장
							stack.push(str[j]);
						} else if (stack.peek().equals("(")) {
							// top이 '('라면 현재연산자 '*'를 push하여 저장
							stack.push(str[j]);
						} else {
							// top이 ')'또는 '*'라면 top을 pop하여 후위표현식에 추가
							postfix += stack.pop();
							// 현재연산자 '*'를 push하여 저장
							stack.push(str[j]);
						}
					} else {
						// Stack이 비어있다면 현재연산자 '*'를 push하여 저장
						stack.push(str[j]);
					}
				} else if (str[j].equals("(")) {
					// '('가 나오면 Stack에 push하여 저장
					stack.push(str[j]);
				} else if (str[j].equals(")")) {
					// ')'가 나오면 '('가 나올때까지 전부 pop하여 후위표현식에 추가하고, '('와 ')' 둘다 버림
					if (!stack.isEmpty()) {
						while (!stack.peek().equals("(")) {
							postfix += stack.pop();
						}
						stack.pop();
					}
				} else {
					postfix += str[j];
				}
			}
			while (!stack.isEmpty()) {
				postfix += stack.pop();
			}

//			System.out.println(postfix);

			// 후위표현식을 split을 사용하여 배열로 변환
			String[] postfixArr = postfix.split("");
			int num1, num2;
			// 후위표현식의 길이만큼 반복
			for (int j = 0; j < len; j++) {
				// 각 연산자가 나올때마다 Stack에 저장된 두개의 피연산자를 꺼내서 연산후 다시 Stack에 push하여 저장
				if (postfixArr[j].equals("+")) {
					num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push(String.valueOf(num1 + num2));
				} else if (postfixArr[j].equals("*")) {
					num1 = Integer.parseInt(stack.pop());
					num2 = Integer.parseInt(stack.pop());
					stack.push(String.valueOf(num1 * num2));
				} else {
					// 피연산자는 바로 push하여 저장
					stack.push(postfixArr[j]);
				}
			}

			// 각 테스트케이스마다 결과값 출력
		}
	}

}
