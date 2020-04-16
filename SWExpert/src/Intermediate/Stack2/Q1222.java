package Intermediate.Stack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1222 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 연산자를 저장할 Stack 선언
		Stack<String> stack;
		
		// 테스트 케이스 10번만큼 반복 (결과값에 테스트 케이스 번호를 출력하기 위해 1부터 10까지)
		for(int i = 1; i <= 10; i++){
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
					// Stack이 비어있는지 확인
					if(stack.isEmpty()) {
						// 비어있다면 push하여 저장
						stack.push(str[j]);
					} else {
						// 비어있지 않다면 top을 확인, top이 '+'라면
						if(stack.peek().equals("+")) {
							// pop으로 top을 후위표현식에 추가
							postfix += stack.pop();
							// 현재 '+'를 push하여 저장
							stack.push(str[j]);
						}
					}
				} else {
					// '+'가 아닌 다른 것은 전부 숫자이므로 바로 후위표현식에 추가
					postfix += str[j];
				}
			}
			// 중위표현식을 전부 순회한후 Stack에 남은 연산자 추출하여 후위표현식에 추가
			while(!stack.isEmpty()) {
				postfix += stack.pop();
			}
			
//			System.out.println(postfix);
			
			// 후위표현식을 split을 사용하여 배열로 변환
			String[] postfixArr = postfix.split("");
			// 후위표현식의 길이만큼 반복
			for(int j = 0; j < postfix.length(); j++) {
				// '+'가 나오면
				if(postfixArr[j].equals("+")) {
					// Stack에 저장된 피연산자 두개를 pop하여 꺼냄
					int num1 = Integer.parseInt(stack.pop());
					int num2 = Integer.parseInt(stack.pop());
					// Stack에서 꺼낸 두개의 피연산자를 더하고 다시 Stack에 push하여 저장
					stack.push(String.valueOf(num1 + num2));
				} else {
					// '+'가 아니면 전부 숫자이므로 Stack에 push하여 저장
					stack.push(postfixArr[j]);
				}
			}
			
			// 각 테스트케이스마다 결과값 출력
			System.out.println("#" + i + " " + stack.pop());
		}
	}

}
