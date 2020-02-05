
import java.util.Scanner;

public class Q02920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[8];
		
		for(int i = 0; i < 8; i++) {
			arr[i] = scan.nextInt();
		}
		
		String result = "";
		for(int i = 1; i < 8; i++) {
			if(arr[i] == arr[i - 1] + 1) {
				result = "ascending";
			} else if(arr[i] == arr[i - 1] - 1) {
				result = "descending";
			} else {
				result = "mixed";
				break;
			}
		}
		System.out.print(result);
	}

}
