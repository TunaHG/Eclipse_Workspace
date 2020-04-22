package Step.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q01152 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().trim();
		if(str.isEmpty()) {
			System.out.print(0);
		} else {
			System.out.print(str.split(" ").length);
		}
	}

}
