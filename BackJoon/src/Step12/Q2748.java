package Step12;
import java.util.Scanner;

public class Q2748 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 몇번째 피보나치의 수인지 입력
		int N = scan.nextInt();
		// 피보나치의 수를 미리 입력해둘 배열 선언
		int arr[] = new int[N + 1];
		
		// 배열 초기값 입력
		arr[0] = 0;
		arr[1] = 1;
		
		// 찾고싶은 순서의 값까지만 반복문 진행
		for(int i = 2; i <= N; i++) {
			// 피보나치의 수 입력
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		System.out.println(arr[N]);
	}
}
