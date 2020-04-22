package Step.DP1;

import java.util.Scanner;

public class Q02579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int score[] = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			score[i] = scan.nextInt();
		}
		
		int result[] = new int[N + 1];
		result[1] = score[1];
		if(N >= 2) result[2] = score[1] + score[2];
		
		for(int i = 3; i <= N; i++) {
			result[i] = Math.max(result[i - 2] + score[i], result[i - 3] + score[i - 1] + score[i]);
		}
		
		System.out.println(result[N]);
	}

}
// ��ó : https://limkydev.tistory.com/121