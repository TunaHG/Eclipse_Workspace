package Step04;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
//import java.util.Scanner;

public class Q10951 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String arr[] = new String[2];
		
		while(true) {
			arr = br.readLine().split(" ");
			if(arr[0] == "") break;
			
			int num1 = Integer.valueOf(arr[0]);
			int num2 = Integer.valueOf(arr[1]);
			int sum = num1 + num2;
			
			bw.write(sum + "\n");
		}
//		Scanner scan = new Scanner(System.in);
//		
//		while(scan.hasNextInt()) {
//			int num1 = scan.nextInt();
//			int num2 = scan.nextInt();
//			
//			System.out.println(num1 + num2);
//		}
	}

}
