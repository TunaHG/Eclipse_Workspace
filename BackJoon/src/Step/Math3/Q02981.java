package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02981 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			min = Math.min(min, numbers[i]);
		}
		
		int index = 2;
		while(true) {
			if(index > min)
				break;
			
			int rest = numbers[0] % index;
			boolean flag = true;
			for(int i = 1; i < N; i++) {
				if(numbers[i] % index != rest) {
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println(index);
			
			index++;
		}
	}

}
