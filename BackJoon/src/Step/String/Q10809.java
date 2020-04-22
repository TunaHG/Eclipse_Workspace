package Step.String;

import java.util.Scanner;
import java.util.Arrays;

public class Q10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		
		String str = scan.nextLine();
		scan.close();
		
		for(int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 'a';
			if(arr[num] == -1) arr[num] = i;
		}
		
		for(int i = 0; i < 26; i++) {
			System.out.print(arr[i] + " ");
		}
//		int arr[] = new int[123];
//		Arrays.fill(arr, -1);
//		
//		String str = scan.nextLine();
//		scan.close();
//		
//		for(int i = 0; i < str.length(); i++) {
//			int num = str.charAt(i);
//			if(arr[num] == -1) {
//				arr[num] = i;
//			}
//		}
//		for(int i = 97; i < 123; i++) {
//			System.out.print(arr[i] + " ");
//		}
	}

}
