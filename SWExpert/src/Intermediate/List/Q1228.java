package Intermediate.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 암호문을 저장할 List변수
		List<Integer> list;
		
		// 테스트케이스 10번까지 반복
		for(int i = 1; i <= 10; i++) {
			// 암호문이 저장된 List변수 초기화
			list = new ArrayList<>();
			// 원본 암호문 길이 입력
			int N = Integer.parseInt(br.readLine());
			
			// 원본 암호문 입력
			String[] original = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				list.add(Integer.parseInt(original[j]));
			}
			
			// 명령어의 개수 입력
			int cmd = Integer.parseInt(br.readLine());
			// 명령어가 I로 시작하므로, I를 기준으로 split()하면 각 명령어로 분할됨
			String[] allCommand = br.readLine().split("I");
			// I로 split()하여 첫번째명령어는 ""이 되므로 첫번째를 제외하고 두번째부터 명령어 개수만큼 반복
			for(int j = 1; j <= cmd; j++) {
				// 각 명령어 입력 (I로 split()했기 때문에 양 끝에 공백이 존재함, trim()으로 공백제거)
				String[] oneCommand = allCommand[j].trim().split(" ");
				// 명령어의 첫번째 인자는 암호문 추가할 위치
				int loc = Integer.parseInt(oneCommand[0]);
				// 명령어의 두번째 인자는 추가할 암호문 개수
				int cnt = Integer.parseInt(oneCommand[1]);
				// 명령어의 세번째 인자부터 추가할 암호문 개수만큼 반복하며 암호문 추가
				for(int k = 2; k < 2 + cnt; k++) {
					list.add(loc + k - 2, Integer.parseInt(oneCommand[k]));
				}
			}
			
			// 각 테스트케이스마다 결과 출력 (10개씩)
			System.out.print("#" + i);
			for(int j = 0; j < 10; j++) {
				System.out.print(" " + list.get(j));
			}
			System.out.println();
		}
	}

}
