package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02609 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 주어지는 두 수 입력
		String[] input = br.readLine().split(" ");
		// 두 수를 int값으로 변환
		int num1 = Integer.parseInt(input[0]);
		int num2 = Integer.parseInt(input[1]);
		
		// 최소공배수를 구하기 위한 임시값(최소공배수 = (두 수의 곱) / 최대공약수)
		int LCM = num1 * num2;
		
		// 최대공약수를 구하기 위한 무한 loop
		while(true) {
			// 나머지가 0이라면 num2가 최대 공약수
			if(num1 % num2 == 0)
				break;
			
			// 값을 임시저장
			int tmp = num1;
			// num1에 num2저장
			num1 = num2;
			// num2에 임시저장된 tmp값을 num2로 나눈 나머지값 저장
			num2 = tmp % num2;
		}
		// 최대 공약수 출력
		System.out.println(num2);
		// 최소 공배수 출력
		System.out.println(LCM / num2);
	}

}
