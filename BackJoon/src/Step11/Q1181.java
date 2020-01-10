package Step11;
import java.io.*;

public class Q1181 {
	// 두 원소를 바꿔주는 함수
	static void swap(String arr[], int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력받을 문자열 개수 입력
		int N = Integer.valueOf(br.readLine());
		
		// 입력받을 문자열을 입력할 배열 선언
		String arr[] = new String[N];
		
		// 문자열 입력
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		// 정렬
		// 첫번째부터 정렬할 첫번째 반복문
		for(int i = 0; i < N; i++) {
			// i이후의 값들과 i를 비교할 두번째 반복문
			for(int j = i + 1; j < N; j++) {
				// 길이를 비교하여 짧은 길이가 앞으로 오도록 교체
				if(arr[i].length() > arr[j].length()) swap(arr, i, j);
				// 길이가 같을 경우
				else if(arr[i].length() == arr[j].length()) {
					// 문자열이 같다면 그대로 냅두고 다음 반복문 실행
					if(arr[i].equals(arr[j])) continue;
					// 문자열에서 첫번째 문자부터 끝까지 비교하기 위한 세번째 반복문
					for(int k = 0; k < arr[i].length(); k++) {
						// i의 문자가 사전순으로 더 느리다면 교체
						if(arr[i].charAt(k) > arr[j].charAt(k)) {
							swap(arr, i, j);
							break;
						}
						// i의 문자가 사전순으로 더 빠르면 그대로 냅두고 반복문을 벗어남
						else if(arr[i].charAt(k) < arr[j].charAt(k)) {
							break;
						}
					}
				}
			}
		}
		
		// 이전의 문자열과 비교해야 하므로 첫번째는 그냥 출력
		bw.write(arr[0] + "\n");
		// 이전의 문자열과 비교하며 출력할 반복문
		for(int i = 1; i < N; i++) {
			// 이전의 문자열과 같다면 출력하지 않고 다음 반복문 실행
			if(arr[i].equals(arr[i - 1])) continue;
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
