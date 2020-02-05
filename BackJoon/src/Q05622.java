
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q05622 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) <= 'C') sum += 3;
			else if(str.charAt(i) <= 'F') sum += 4;
			else if(str.charAt(i) <= 'I') sum += 5;
			else if(str.charAt(i) <= 'L') sum += 6;
			else if(str.charAt(i) <= 'O') sum += 7;
			else if(str.charAt(i) <= 'S') sum += 8;
			else if(str.charAt(i) <= 'V') sum += 9;
			else if(str.charAt(i) <= 'Z') sum += 10;
		}
		System.out.print(sum);
	}

}
