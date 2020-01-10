package Step07;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q2675 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for(int j = 0; j < str.length(); j++) {
				for(int k = 0; k < cnt; k++) {
					bw.write(str.charAt(j) + "");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
