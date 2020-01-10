import java.util.Scanner;

public class Q16395 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int array[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			array[i][0] = 1;
			array[i][i] = 1;
		}
		
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < n-1; j++) {
				array[i][j] = array[i-1][j-1] + array[i-1][j];
			}
		}
		System.out.println(array[n-1][k-1]);
	}

}
