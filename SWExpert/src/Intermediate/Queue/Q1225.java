package Intermediate.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// Test case 번호만큼 반복
		for(int i = 1; i <= 10; i++) {
			// 입력되는 Test Case 번호 버리기 (반복문에서 이미 가지고있으므로)
			br.readLine();
			// 8개의 숫자를 배열로 저장
			String[] input = br.readLine().split(" ");
			// String으로 저장된 8개의 숫자를 Integer로 변환하며 Queue에 Add
			for (int j = 0; j < input.length; j++) {
				queue.add(Integer.parseInt(input[j]));
			}
			
			// 사이클 내에서 1부터 5까지 반복하며 값을 뺄 수치
			int num = 1;
			// 암호가 완성될 때까지 반복할 반복문
			while(true) {
				// Queue의 Front값 추출
				int pw = queue.poll();
				// Front값에서 num을 뺀값이 0보다 작거나 같으면 암호가 성립
				if(pw - num <= 0) {
					// 0으로 변경
					pw = 0;
					// Queue의 마지막원소로 Add
					queue.add(pw);
					// 반복문에서 벗어남
					break;
				}
				// 암호가 성립되지 않았다면, num을 빼고 맨 뒤로 삽입
				queue.add(pw - num);
				// num의 수치를 1 증가
				num++;
				// num이 5보다 커진다면 1로 변경
				if(num > 5)
					num = 1;
			}
			
			// 암호가 완성됬으니 출력
			System.out.print("#" + i);
			while(!queue.isEmpty()) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}

}
