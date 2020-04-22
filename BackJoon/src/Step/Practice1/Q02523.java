package Step.Practice1;

import java.util.Scanner;

public class Q02523 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 주어지는 값
		int N = scan.nextInt();
		
		// 전체 2 * N - 1번 만큼 반복할 반복문
		for(int i = 0; i < 2 * N - 1; i++) {
			// N값까지의 반복문 설정
			if(i < N) {
				// 0값과 i값의 차이만큼 별 출력 반복문
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			}
			// N값 이후의 반복문 설정
			else {
				// 2 * N - 1와 i값의 차이만큼 별 출력 반복문
				for(int j = 2 * N - 1; j > i; j--) {
					System.out.print("*");
				}
			}
			// 각 행이 끝날때마다 줄바꿈
			System.out.println();
		}
	}

}
