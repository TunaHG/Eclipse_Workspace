package Step07;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String arr[] = br.readLine().split(" ");
		int num[] = new int[2];
		for(int i = 0; i < arr.length; i++) {
			String tmp = "";
			for(int j = 0; j < arr[i].length(); j++) {
				tmp += arr[i].charAt(arr[i].length() - 1 - j);
			}
			num[i] = Integer.valueOf(tmp);
		}
		if(num[0] > num[1]) System.out.print(num[0]);
		else System.out.print(num[1]);
	}

}
