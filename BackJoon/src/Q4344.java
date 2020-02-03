import java.util.Scanner;

public class Q4344 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[][] arr = new int[N][];
		
		for (int i = 0; i < arr.length; i++) {
			int T = scan.nextInt();
			
			arr[i] = new int[T];
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
