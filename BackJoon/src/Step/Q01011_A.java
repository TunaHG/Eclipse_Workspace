package Step;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q01011_A {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int dist, t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String line[];
		
		while(t-->0) {
			line = br.readLine().split(" ");
			dist = Integer.parseInt(line[1]) - Integer.parseInt(line[0]);
			sb.append(warp(dist) + "\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static long warp(int dist) {
		long n, minN, powN, maxN, warpCount = 0;
		for(n=1; ; n++) {
			powN = n * n;
			minN = powN - n + 1;
			maxN = powN + 1 + n - 1;
			if(minN <= dist && dist <= maxN) {
				if(minN <= dist && dist <= powN) {
					warpCount = (n<<1) - 1;
				} else {
					warpCount = n<<1;
				} 
				break;
			}
		}
		return warpCount;
	}

}
