package Intermediate.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q1215 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수
		int T = 10;
		
		// 8 x 8로 char가 담길 배열
		char arr[][] = new char[8][8];
		
		// 결과값 변수
		int cnt = 0;
		// 테스트 케이스 개수만큼 반복
		while(T-- > 0) {
			// 결과값 초기화
			cnt = 0;
			// 회문의 길이 입력
			int len = Integer.parseInt(br.readLine());
			
			// 8 x 8 배열 입력받음
			for(int i = 0; i < 8; i++) {
				String str = br.readLine();
				for(int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			// 회문으로 판단할 문자열과 그 문자열을 뒤집은 문자열 변수 선언
			String pal, reverse;
			// 행 또는 열의 값으로 0 ~ 7 까지 탐색할 반복문
			for(int i = 0; i < 8; i++) {
				// 회문의 길이가 배열내에서 허용되는 범위를 표시한 반복문
				for(int j = 0; j <= 8 - len; j++) {
					// 두 변수 초기화
					pal = "";
					reverse = "";
					// i를 행으로 판단, 회문의 길이만큼 열을 반복하여 판단할 문자열 추출
					for(int k = j; k < j + len; k++) {
						pal += arr[i][k]; 
					}
					// 판단할 문자열을 거꾸로 입력받는 문자열 추출
					for(int k = j + len - 1; k >= j; k--) {
						reverse += arr[i][k];
					}
					// 두 문자열이 같다면 회문이다.
					if(pal.equals(reverse)) {
						cnt++;
					}
					
					// 두 변수 초기화
					pal = "";
					reverse = "";
					// i를 열로 판단, 회문의 길이만큼 행을 반복하여 판단할 문자열 추출
					for(int k = j; k < j + len; k++) {
						pal += arr[k][i]; 
					}
					// 판단할 문자열을 거꾸로 입력받는 문자열 추출
					for(int k = j + len - 1; k >= j; k--) {
						reverse += arr[k][i];
					}
					// 두 문자열이 같다면 회문
					if(pal.equals(reverse))
						cnt++;
				}
			}
			System.out.println("#" + (10 - T) + " " + cnt);
		}
		br.close();
	}

}
