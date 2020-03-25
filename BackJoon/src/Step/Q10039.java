package Step;

import java.util.Scanner;

public class Q10039 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 각 학생의 점수를 입력받을 num 변수
		int num = 0;
		// 합게를 저장할 sum 변수
		int sum = 0;
		// 5개의 점수를 입력받을 반복문
		for(int i = 0; i < 5; i++) {
			num = scan.nextInt();
			// 40점 이하는 40점으로 고정
			if(num < 40) num = 40;
			// 합계
			sum += num;
		}
		// 5명의 평균 출력
		System.out.println(sum / 5);
	}

}
