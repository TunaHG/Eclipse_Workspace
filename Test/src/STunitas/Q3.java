package STunitas;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int N, coin[], change, cnt;

		while(T-- > 0) {
			cnt = 0;
			N = sc.nextInt();
			
			coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = sc.nextInt();
			}
			change = sc.nextInt();
			
			for(int i = N - 1; i >= 0; i--) {
				cnt += change / coin[i];
				change = change % coin[i];
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
/*
2
5
1 3 6 12 24
70
1
1
10

6
10
*/