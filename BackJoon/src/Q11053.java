
import java.util.Scanner;

public class Q11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int A[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		
		int dp[] = new int[N];
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			if(A[i] > A[i - 1]) dp[i] = dp[i - 1] + 1;
			else if(A[i] < A[i - 1]) {
				for(int j = i; j >= 0; j--) {
					if(A[i] == A[j]) {
						dp[i] = dp[j];
						break;
					}
				}
			}
			else dp[i] = dp[i - 1];
		}
		for(int i = 0; i < N; i++) {
			System.out.print(dp[i] + " ");
		}
	}

}
