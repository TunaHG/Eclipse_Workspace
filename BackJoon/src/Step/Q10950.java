package Step;

import java.util.Scanner;

public class Q10950 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int arr[][] = new int[T][2];
		
		for(int i = 0; i < T; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		
		for(int i = 0; i < T; i++) {
			System.out.println(arr[i][0] + arr[i][1]);
		}
	}

}
