package Step09;
import java.util.Arrays;
import java.util.Scanner;

public class Q1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		int arr[] = new int[N + 1];
		
		Arrays.fill(arr, 0);
		arr[1] = 1;
		
		// 시간 초과 코드
//		for(int i = 2; i <= N; i++) {
//			if(arr[i] == 1) continue;
//			for(int j = i + 1; j <= N; j++) {
//				if(j % i == 0) arr[j] = 1;
//			}
//		}
		
		// 에라토스테네스 체 코드
		for(int i = 2; i <= N; i++) {
			for(int j = 2; i * j <= N; j++) {
				arr[i * j] = 1;
			}
		}
		
		// 제곱근을 활용한 코드
//		int SW = 0;
//		for(int i = M; i <= N; i++) {
//			if(i == 1) SW = 1;
//			int root = (int)Math.sqrt(i) + 1;
//			for(int j = 2; j < root; j++) {
//				if(i % j == 0){
//					SW = 1;
//					break;
//				}
//			}
//			if(SW == 0) {
//				System.out.println(i);
//			}
//			SW = 0;
//		}
		
		for(int i = M; i <= N; i++) {
			if(arr[i] == 0) System.out.println(i);
		}
	}

}
