package Step.DP1;
import java.util.Scanner;

public class Q11054 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int A[] = new int[N];
		int up[] = new int[N];
		int down[] = new int[N];
		int sum[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
			up[i] = 1;
			down[i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(A[i] > A[j] && up[i] <= up[j]) {
					up[i] = up[j] + 1;
				}
			}
		}
		for(int i = N - 2; i > 0; i--) {
			for(int j = N - 1; j > i; j--) {
				if(A[i] > A[j] && down[i] <= down[j]) {
					down[i] = down[j] + 1;
				}
			}
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			sum[i] = up[i] + down[i];
			max = Math.max(max, sum[i]);
		}
		
		System.out.println(max - 1);
	}
}
