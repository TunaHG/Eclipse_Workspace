
//import java.io.BufferedWriter;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.IOException;
//import java.util.StringTokenizer;
import java.util.Scanner;

public class Q01011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int T = Integer.parseInt(st.nextToken());
//		
//		for(int i = 0; i < T; i++) {
//			String[] line = br.readLine().split(" ");
//			int diff = Integer.valueOf(line[1]) - Integer.valueOf(line[0]);
//			
//			long tmp = 1;
//			long pow_tmp;
//			while(true) {
//				pow_tmp = tmp * tmp;
//				long std = pow_tmp + tmp;
//				if(diff <= std) break;
//				
//				tmp++;
//			}
//			if(diff <= pow_tmp) {
//				bw.write(tmp * 2 - 1 + "\n");
//			} else {
//				bw.write(tmp * 2 + "\n");
//			}
//		}
//		bw.flush();
//		bw.close();
//		�ð� �ʰ� �ڵ�
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int i = 0; i < T; i++) {
			long x = scan.nextLong();
			long y = scan.nextLong();
			long diff = y - x;
			
			long value = 1;
			long interval = 1;
			long SW = 1;
			long cnt = 1;
			while(true) {
				if(diff <= value) break;
				if(SW == 0) {
					value += interval;
					SW = 1;
					cnt++;
				} else {
					value += interval;
					interval++;
					SW = 0;
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
