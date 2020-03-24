package Step;

import java.util.Arrays;
import java.util.Scanner;

public class Q02775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arr[][] = new int[15][15];
		
		for(int i = 0; i < 15; i++) {
			Arrays.fill(arr[i], 0);
		}
		
		for(int i = 0; i < 15; i++) {
			arr[0][i] = i;
		}
		
		for(int i = 1; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				for(int k = 0; k <= j; k++) {
					arr[i][j] += arr[i-1][k];
				}
			}
		}
		
		int T = scan.nextInt();
		for(int i = 0; i < T; i++) {
			int k = scan.nextInt();
			int n = scan.nextInt();
			
			System.out.println(arr[k][n]);
		}
	}

}
