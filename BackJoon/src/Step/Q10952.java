package Step;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
//import java.util.Scanner;

public class Q10952 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int num1 = Integer.valueOf(str.nextToken());
			int num2 = Integer.valueOf(str.nextToken());
			if(num1 == 0 && num2 == 0) break;
			int sum = num1 + num2;
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
//		Scanner scan = new Scanner(System.in);
//		
//		while(true) {
//			int num1 = scan.nextInt();
//			int num2 = scan.nextInt();
//			if(num1 == 0 && num2 == 0) break;
//			System.out.println(num1 + num2);
//		}
	}

}
