
import java.io.*;
import java.util.StringTokenizer;

public class Q01002_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int x1, y1, r1, x2, y2, r2;
		double d, r;
		int T = Integer.valueOf(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.valueOf(st.nextToken());
			y1 = Integer.valueOf(st.nextToken());
			r1 = Integer.valueOf(st.nextToken());
			x2 = Integer.valueOf(st.nextToken());
			y2 = Integer.valueOf(st.nextToken());
			r2 = Integer.valueOf(st.nextToken());
			
			d = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
			r = Math.sqrt(d);
			
			if(x2 - x1 == 0 && y2 - y1 == 0 && r2 - r1 == 0) bw.write(-1 + "\n");
			else if((x2 - x1 == 0 && y2 - y1 == 0 && r2 - r1 != 0) || (r > r1 + r2) || (r < Math.abs(r1 - r2))) bw.write(0 + "\n");
			else if((r == r1 + r2) || Math.abs(r1 - r2) == r) bw.write(1 + "\n");
			else bw.write(2 + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
