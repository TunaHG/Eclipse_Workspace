package Step08;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q6064_2 {
	static int GCD(int num1, int num2) {
		while(true) {
			if(num2 == 0) break;
			int tmp = num1 % num2;
			num1 = num2;
			num2 = tmp;
		}
		return num1;
	}
	static int LCM(int num1, int num2) {
		return num1 * num2 / GCD(num1, num2);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.valueOf(st.nextToken());
			int N = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			
			int tmpY = x;
			int cnt = x;
			
			for(int j = 0; j < N; j++) {
				int tmp;
				if(tmpY % N == 0) {
					tmp = N;
				} else {
					tmp = tmpY % N;
				}
				if(tmp == y) break;
				tmpY += M;
				cnt += M;
			}
			if(cnt > LCM(M, N)) {
				cnt = -1;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

} 	
