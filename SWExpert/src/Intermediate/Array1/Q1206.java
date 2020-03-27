package Intermediate.Array1;

import java.util.Scanner;

public class Q1206 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 가로길이를 입력받을 변수, 조건에 맞는 세대 수를 카운트할 변수, 각 아파트의 층수를 입력받을 변수 선언
		int width, cnt, num;
		// 전체 테스트케이스 10번만큼 반복
		for(int i = 1; i <= 10; i++) {
			// 가로길이 입력
			width = scan.nextInt();
			// 조건에 맞는 세대수를 각 테스트케이스마다 0으로 초기화
			cnt = 0;
			
			// 아파트를 의미하는 2차원 배열 선언, 가로길이를 행으로 최고 높이인 255를 열로 (행과 열을 변경할 수 있음)
			int apart[][] = new int[width][255];
			// 가로길이만큼 반복
			for(int j = 0; j < width; j++) {
				// 각 아파트의 층수 입력
				num = scan.nextInt();
				// 각 아파트의 층수만큼 반복
				for(int k = 0; k < num; k++) {
					// 아파트의 층수에 해당하는 부분을 전부 1로 변경
					apart[j][k] = 1;
				}
			}
			
			// 전체 아파트를 탐색하는 반복문
			for(int j = 0; j < width; j++) {
				for(int k = 0; k < 255; k++) {
					// 아파트의 층을 탐색중 0인 부분이 발견되면 그부분은 아파트가 끝났다는 것이므로 break
					if(apart[j][k] == 0)
						break;
					// 아파트의 층을 탐색할때 1이면 세대가 있다는 것
					else {
						// 조건에 맞는 옆의 두 아파트만큼이 1이라면 세대가 있다는 것이므로 조망권이 확보받지못함
						// 두아파트만큼이 0이면 조망권이 확보이므로 조건에 맞는 세대수에 1을 추가
						if(apart[j - 1][k] == 0 && apart[j - 2][k] == 0 && apart[j + 1][k] == 0 && apart[j + 2][k] == 0)
							cnt++;
					}
				}
			}
			// 각 테스트케이스마다 결과값 출력
			System.out.println("#" + i + " " + cnt);
		}
	}

}
