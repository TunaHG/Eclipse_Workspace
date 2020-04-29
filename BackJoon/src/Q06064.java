

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q06064 {

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
			int year_x = 1;
			int year_y = 1;
			
			int cnt = 1;
			int SW = 0;
			while(true) {
				if(year_x == x && year_y == y) {
					SW = 1;
					break;
				} else if(year_x == M && year_y == N) {
					break;
				}
				year_x++;
				year_y++;
				cnt++;
				if(year_x > M) year_x = 1;
				if(year_y > N) year_y = 1;
			}
			if(SW == 0) {
				bw.write(-1 + "\n");
			} else {
				bw.write(cnt + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
