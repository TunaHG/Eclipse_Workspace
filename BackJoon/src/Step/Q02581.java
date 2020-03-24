package Step;

import java.util.Scanner;

public class Q02581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int M = scan.nextInt();
		int N = scan.nextInt();
		scan.close();
		
		int sum = 0;
		int min = N;
		int cnt = 0;
		for(int i = M; i <= N; i++) {
			cnt = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) cnt++;
			}
			if(cnt == 2) {
				sum += i;
				if(i < min) min = i;
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
