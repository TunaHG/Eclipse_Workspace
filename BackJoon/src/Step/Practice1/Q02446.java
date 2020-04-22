package Step.Practice1;

import java.util.Scanner;

public class Q02446 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 주어진 값 입력받기
		int N = scan.nextInt();
		
		// 2 * N - 1번 만큼 반복하는 반복문
		for(int i = 1; i <= 2 * N - 1; i++) {
			// i값이 N번째 (1부터 시작했으니까)까지의 반복문
			if(i <= N) {
				// 0개부터 N-1개까지 공백을 출력할 반복문
				for(int j = 1; j < i; j++) {
					System.out.print(" ");
				}
				// 2 * N - 1개부터 2개씩 감소하면서 *을 출력할 반복문
				for(int j = 1; j <= 2 * N + 1 - i * 2; j++) {
					System.out.print("*");
				}
			}
			// i값이 N번째 이후부터의 반복문
			else {
				// N-1개부터 0개까지 공백을 출력할 반복문
				for(int j = 1; j < 2 * N - i; j++) {
					System.out.print(" ");
				}
				// 1개부터 2개씩 증가하면서 *을 출력할 반복문
				for(int j = 1; j <= 2 * i - 2 * N + 1; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
