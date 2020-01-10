package Step12;
import java.io.*;

public class Q9461 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스크 케이스 개수 입력
		int T = Integer.valueOf(br.readLine());
		
		// 값을 입력할 배열 선언
		// int형을 벗어나는 값이 존재함
		long arr[] = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		
		// arr 값 채워넣기
		for(int i = 3; i < 100; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		
		// 테스크 케이스 개수 T만큼 반복
		while(T-- > 0) {
			// 테스트 케이스 입력
			int N = Integer.valueOf(br.readLine());
			
			// 출력
			bw.write(arr[N - 1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
