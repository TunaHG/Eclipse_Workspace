package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q05086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 0 0이 입력될 때까지 무한loop
		while(true) {
			// 결과값 출력할 변수
			String result = "";
			// 주어지는 데이터 입력
			String[] input = br.readLine().split(" ");
			// 주어지는 두 값을 int값으로 변환
			int num1 = Integer.parseInt(input[0]);
			int num2 = Integer.parseInt(input[1]);
			
			// 두 값이 모두 0이라면 반복문 종료
			if(num1 == 0 && num2 == 0)
				break;
			
			// num1이 num2로 나누어떨어지면, num1이 num2의 배수이다.
			if(num1 % num2 == 0)
				result = "multiple";
			// num2가 num1으로 나누어떨어지면, num1이 num2의 약수이다.
			else if(num2 % num1 == 0)
				result = "factor";
			// 두 경우가 모두 아니라면 neither
			else
				result = "neither";
			
			// 결과값 출력
			System.out.println(result);
		}
	}

}
