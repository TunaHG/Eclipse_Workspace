
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Q08958 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			int score = 0;
			int cnt = 0;
			if(str.charAt(0) == 'O') {
				score += ++cnt;
			}
			for(int j = 1; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					score += ++cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(score);
		}
	}

}
