package Step.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class Q07568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[][] = new int[3][N];
		
		for(int i = 0; i < N; i++) {
			arr[0][i] = scan.nextInt();
			arr[1][i] = scan.nextInt();
		}
		Arrays.fill(arr[2], 1);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(arr[0][i] > arr[0][j] && arr[1][i] > arr[1][j]) arr[2][j]++;
			}
		}
		for(int i = 0 ; i < N; i++) {
			System.out.print(arr[2][i] + " ");
		}
	}

}
