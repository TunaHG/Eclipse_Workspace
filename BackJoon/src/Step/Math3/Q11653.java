package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11653 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 소인수 분해 하고자하는 숫자 입력
		int N = Integer.parseInt(br.readLine());
		// 소인수 분해를 진행할 소인수 index
		int index = 2;
		
		// 소인수 분해가 종료될 때까지 무한 loop
		while(true) {
			// 첫 값이 1이된다면 소인수분해가 종료되었음을 의미
			if(N == 1)
				break;
			
			// index로 나눠서 0이 나온다면 index가 N의 소인수임을 의미
			if(N % index == 0) {
				// 해당 소인수 index 출력
				System.out.println(index);
				// N을 소인수로 나눈값을 다시 N에 입력
				N = N / index;
			}
			// index로 나눠지지 않는다면 index값을 1 올려서 다시 탐색
			else
				index++;
		}
		br.close();
	}

}
