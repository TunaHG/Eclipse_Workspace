package Step11;
import java.io.*;

public class Q10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 수의 개수 입력받기
		int N = Integer.valueOf(br.readLine());
		// 카운팅할 배열 선언
		int arr[] = new int[10001];
		
		// 수를 입력받으면 해당 수를 위치로 가지는 배열의 값을 1씩 증가
		while(N-- > 0) {
			arr[Integer.valueOf(br.readLine())]++;
		}
		
		// 배열 전체를 탐색할 첫번째 반복문
		for(int i = 0; i <= 10000; i++) {
			// 해당 배열의 값만큼 위치를 출력할 두번째 반복문
			for(int j = 0; j < arr[i]; j++) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
