package Step.Math3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11050 {
	static int factorial(int num) {
		if(num <= 1)
			return 1;
		return num * factorial(num - 1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
	}

}
