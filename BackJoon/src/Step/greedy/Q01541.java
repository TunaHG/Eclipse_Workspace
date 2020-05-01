package Step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// -값이 나오면 다음 -값이 나올때까지의 값을 전부 괄호로 묶어주면 최소값이 나오지 않을까?
// => 예를들어, 5-7+6+4+2-1이라면 5-(7+6+4+2)-1로 -15가 최소값이 나온다.
// - 5 + 7 + 6 + 4 - 2 1 (Stack을 사용한 전위표현식)
// 가장 처음과 마지막 수는 숫자이므로 첫값이 음수일 가능성은 없다.

// 우선 주어진 String을 split("")를 이용하여 전부 나누고, 
// 연산자가 등장하기 전까지의 숫자를 임시 String에 저장한다.
// 연산자가 등장하면 연산자를 먼저 Stack에 넣고, 이후에 임시 String을 Stack에 넣는다. (전위 표현식)
// Stack과 전위표현식을 활용한 계산기문제를 해결한다.
public class Q01541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수식이 저장될 배열
		String[] expression = br.readLine().split("");
		
		// 값이 저장될 임시 String
		String numStr = "";
		// 값이 전위표현식 형태로 저장될 Stack
		Stack<String> stack = new Stack<>();
		// 수식 전체 탐색
		for (int i = 0; i < expression.length; i++) {
			// 수식이 연산자라면,
			if(expression[i].equals("+") || expression[i].equals("-")) {
				// 연산자를 먼저 push
				stack.push(expression[i]);
				// 이후에 현재 입력되어있는 숫자를 push
				stack.push(numStr);
				// 숫자를 초기화
				numStr = "";
			}
			// 수식이 숫자라면
			else
				// 연산자가 나오기전까지 String을 더하여 값 완성
				numStr += expression[i];
		}
		// 마지막 값은 임시 String에 저장되어있으므로 push하여 모든 수식을 Stack에 저장
		stack.push(numStr);
		
		// Stack 전위표현식 계산
		// -값을 모아둘 임시 int값
		int tmpSum = 0;
		// Stack을 탐색할 반복문
		while(true) {
			// Stack의 size가 1이라면 반복문 종료
			if(stack.size() == 1)
				break;
			// Stack에 저장되어 있는 값은 무조건 숫자 두 개 이후에 연산자가 나오게 저장되어 있음
			// 수식의 값 두 개 출력 (먼저 뽑는 숫자가 A + B에서 B이므로 num2로 선언)
			int num2 = Integer.parseInt(stack.pop());
			int num1 = Integer.parseInt(stack.pop());
			// 연산자 출력
			String oper = stack.pop();
			// 연산자가 +라면
			if(oper.equals("+")) {
				// 먼저 뽑은 두 값을 더한후 더한 값을 Stack에 push
				stack.push(String.valueOf(num1 + num2));
			}
			// 연산자가 -라면
			else {
				// 임시 int값에 해당 값을 뺀값을 저장
				// -가 등장하고 다시 -가 등장하거나 식이 끝날때까지 사이의 연산을 ()로 묶어준 취급
				tmpSum -= num2;
				// 첫번째 숫자인 num1만을 다시 Stack에 push하여 다음 연산에 사용
				stack.push(String.valueOf(num1));
			}
		}
		// Stack에 남은 1개의 값을 int로 변환하고 -가 등장할때마다 빼서 모아둔 -연산의 결과를 더해주면 결과값이 산출됨
		System.out.println(Integer.parseInt(stack.pop()) + tmpSum);
	}

}
