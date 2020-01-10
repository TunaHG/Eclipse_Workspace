package Step10;
import java.io.*;
import java.util.StringTokenizer;

public class Q1018 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		char arr[][] = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int minCnt = 64, cnt;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				cnt = 0;
				if(arr[i][j] == 'W') {
					if((i + j) % 2 == 0) {
						for(int x = i; x < i + 8; x++) {
							for(int y = j; y < j + 8; y++) {
								if((x + y) % 2 == 0 && arr[x][y] == 'B') cnt++;
								if((x + y) % 2 != 0 && arr[x][y] == 'W') cnt++;
							}
						}
					} else {
						for(int x = i; x < i + 8; x++) {
							for(int y = j; y < j + 8; y++) {
								if((x + y) % 2 == 0 && arr[x][y] == 'W') cnt++;
								if((x + y) % 2 != 0 && arr[x][y] == 'B') cnt++;
							}
						}
					}
				} else if(arr[i][j] == 'B') {
					if((i + j) % 2 == 0) {
						for(int x = i; x < i + 8; x++) {
							for(int y = j; y < j + 8; y++) {
								if((x + y) % 2 == 0 && arr[x][y] == 'W') cnt++;
								if((x + y) % 2 != 0 && arr[x][y] == 'B') cnt++;
							}
						}
					} else {
						for(int x = i; x < i + 8; x++) {
							for(int y = j; y < j + 8; y++) {
								if((x + y) % 2 == 0 && arr[x][y] == 'B') cnt++;
								if((x + y) % 2 != 0 && arr[x][y] == 'W') cnt++;
							}
						}
					}
				}
				if(minCnt > cnt) minCnt = cnt;
			}
		}
		System.out.println(minCnt);
	}

}
