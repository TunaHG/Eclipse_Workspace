package Step04;
import java.util.Scanner;

public class Q1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[3];
		
		int num = scan.nextInt();
		int result = num;
		
		int cnt = 0;
		while(true) {
			int tmp;
			if(num < 10) {
				tmp = num;
			} else {
				tmp = (num / 10) + (num % 10);
			}
			num = (num % 10) * 10 + (tmp % 10);
			cnt++;
			if(num == result) break;
		}
		System.out.print(cnt);
	}

}
