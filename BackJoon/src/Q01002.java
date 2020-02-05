
import java.io.*;
import java.util.StringTokenizer;

public class Q01002 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.valueOf(st.nextToken());
			int y1 = Integer.valueOf(st.nextToken());
			int r1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken());
			int y2 = Integer.valueOf(st.nextToken());
			int r2 = Integer.valueOf(st.nextToken());
			
			if(x2 - x1 == 0 && y2 - y1 == 0) {
				if(r1 == r2) bw.write(-1 + "\n");
				else bw.write(0 + "\n");
			} else {
				double powX = (x2 - x1) * (x2 - x1);
				double powY = (y2 - y1) * (y2 - y1);
				double diff = Math.sqrt(powX + powY);
				if(diff > r1 + r2) bw.write(0 + "\n");
				else if(diff == r1 + r2) bw.write(1 + "\n");
				else bw.write(2 + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
