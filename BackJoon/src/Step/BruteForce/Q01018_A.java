package Step.BruteForce;

import java.util.Scanner;

public class Q01018_A {
	static int N, M;
	static char[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		arr = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = scan.next();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				result = Math.min(result, solve(i, j));
			}
		}
		System.out.print(result);
	}
	static int solve(int x, int y) {
		int result1 = 0;
		char temp = 'B';
		for(int i = x; i < x + 8; i++) {
			if(arr[i][y] != temp) result1++;
			for(int j = y+1; j < y + 8; j++) {
				if(arr[i][j] == temp) {
					result1++;
					if(temp == 'B') temp = 'W';
					else temp = 'B';
				} else temp = arr[i][j];
			}
		}
		int result2 = 0;
		temp = 'W';
		for(int i = x; i < x + 8; i++) {
			if(arr[i][y] != temp) result2++;
			for(int j = y+1; j < y + 8; j++) {
				if(arr[i][j] == temp) {
					result2++;
					if(temp == 'B') temp = 'W';
					else temp = 'B';
				} else temp = arr[i][j];
			}
		}
		return result1>result2?result2:result1;
	}
}
