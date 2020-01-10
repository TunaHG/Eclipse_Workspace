package Step12;
import java.util.Scanner;

public class Q1904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		// 배열 선언
		int arr[] = new int[N + 1];
		
		// 초기값 입력
		arr[0] = 1;
		arr[1] = 1;
		
		// 초기값을 활용한 이후의 값 입력
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			// int형을 벗어나는 값이 생기는 것 방지 + 조건
			// 출력할 때 사용하면 이미 int형을 벗어난 이후라 이상한 답이 나옴
			// 그때그때 나눠주어야함
			arr[i] %= 15746;
		}
		
		System.out.println(arr[N]);
	}

}
