package Intermediate.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1229 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 암호문 입력받을 List변수
		List<String> list;
		
		// 테스트케이스 10번만큼 반복
		for(int testNum = 1; testNum <= 10; testNum++) {
			// List 초기화
			list = new ArrayList<>();
			// 원본 암호문 길이 입력
			int N = Integer.parseInt(br.readLine());
			
			// 원본 암호문 입력
			String[] original = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				list.add(original[i]);
			}
			
			// 명령어 개수 입력 (사용을 안해서 버림)
			br.readLine();
			
			// 명령어를 탐색할 index
			int index = 0;
			// 전체 명령어 입력
			String[] allcmd = br.readLine().split(" ");
			// I, D 명령어에서 위치와 개수를 탐색할 변수
			int loc, cnt;
			// 무한 Loop
			while(true) {
				// 탐색 index가 전체 명령어의 길이를 전부 탐색하면 반복문 종료
				if(index >= allcmd.length)
					break;
				// I 혹은 D를 가져올 변수
				String cmd = allcmd[index++];
				// 각 명령어의 위치 입력
				loc = Integer.parseInt(allcmd[index++]);
				// 각 명령어의 개수 입력
				cnt = Integer.parseInt(allcmd[index++]);
				
				// 명령어 I라면
				if(cmd.equals("I")) {
					// 명령어 개수만큼 반복하여 위치에 삽입
					// loc도 다음 명령어에서 새로 입력받으므로 그냥 1씩더해가면서 삽입
					for(int i = 0; i < cnt; i++) {
						list.add(loc++, allcmd[index++]);
					}
				} 
				// 명령어 D라면
				else {
					// 명령어 개수만큼 반복하여 위치 삭제
					// 해당 위치를 삭제하면 값들이 땡겨져오므로 동일위치를 삭제하면 된다.
					for(int i = 0; i < cnt; i++) {
						list.remove(loc);
					}
				}
			}
			
			// 각 테스트케이스마다 결과 출력
			System.out.print("#" + testNum);
			for(int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}

}
