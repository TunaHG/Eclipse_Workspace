package Step07;
import java.util.Scanner;
import java.util.Arrays;

public class Q1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int[26];
		Arrays.fill(arr, 0);
		
		String str = scan.nextLine();
		for(int i = 0; i < str.length(); i++) {
			int result = str.charAt(i);
			if(result < 'a') {
				arr[result - 'A']++;
			} else {
				arr[result - 'a']++;
			}
		}
		
		int max = 0;
		int max_loc = 0;
		int SW = 0;
		for(int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				max_loc = i;
			}
		}
		for(int i = 0; i < 26; i++) {
			if(max == arr[i]) SW++;
		}
		if(SW > 1) System.out.print("?");
		else System.out.print((char)('A' + max_loc));
	}

}
