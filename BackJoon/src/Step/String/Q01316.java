package Step.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Q01316 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[26];
		int num = Integer.valueOf(br.readLine());
		int result = num;
		
		for(int i = 0; i < num; i++) {
			Arrays.fill(arr, 0);
			String str = br.readLine();
			arr[str.charAt(0) - 'a'] = 1;
			for(int j = 1; j < str.length(); j++) {
				if(arr[str.charAt(j) - 'a'] == 0) arr[str.charAt(j) - 'a'] = 1;
				else if(str.charAt(j) == str.charAt(j-1)) continue;
				else {
					result--;
					break;
				}
			}
		}
		System.out.print(result);
	}

}
