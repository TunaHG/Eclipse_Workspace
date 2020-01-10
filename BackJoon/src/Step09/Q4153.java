package Step09;
import java.io.*;
import java.util.StringTokenizer;

public class Q4153 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			int z = Integer.valueOf(st.nextToken());
			if(x == 0 && y == 0 && z == 0) break;
			
			long powX = x * x;
			long powY = y * y;
			long powZ = z * z;
			if(powX + powY == powZ) bw.write("right\n");
			else if(powX + powZ == powY) bw.write("right\n");
			else if(powY + powZ == powX) bw.write("right\n");
			else bw.write("wrong\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
