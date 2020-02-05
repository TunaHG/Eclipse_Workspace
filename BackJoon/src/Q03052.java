
import java.util.Scanner;

public class Q03052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int[42];
		for(int i = 0; i < 10; i++) {
			int num = scan.nextInt();
			arr[num % 42]++;
		}
		scan.close();
		
		int cnt = 0;
		for(int i = 0; i < 42; i++) {
			if(arr[i] > 0) cnt++;
		}
		System.out.println(cnt);
	}

}
