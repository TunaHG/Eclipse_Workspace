package Intermediate.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q1213 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수
		int T = 10;
		
		// 테스트 케이스만큼 반복
		while(T-- > 0) {
			// 테스트 케이스 번호 입력
			int tNum = Integer.parseInt(br.readLine());
			
			// 찾을 문자열
			String keyword = br.readLine();
			
			// 검색할 문자열
			String str = br.readLine();
			
			// keyword가 몇개 존재하는지 셀 변수
			int cnt = 0;
			// 검색할 문자열의 첫 위치부터 keyword - 1을 뺀 위치까지(keyword의 길이만큼은 비교해야하므로) 탐색
			for(int i = 0; i < str.length() - keyword.length() + 1; i++) {
				// substring을 활용하여 검색할 문자열의 일부분을 추출하고 그것과 keyword가 동일하면 cnt + 1
				if(str.substring(i, i + keyword.length()).equals(keyword))
					cnt++;
			}
			// 테스트케이스마다 결과값 출력
			System.out.println("#" + tNum + " " + cnt);
		}
	}

}
