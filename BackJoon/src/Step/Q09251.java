package Step;

import java.util.Scanner;

public class Q09251 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else {
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
//		for(int i = 0; i < str1.length() + 1; i++) {
//			for(int j = 0; j < str2.length() + 1; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

}
