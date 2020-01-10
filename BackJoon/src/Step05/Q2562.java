package Step05;
import java.util.Scanner;

public class Q2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int max = 0;
		int max_loc = 0;
		for(int i = 1; i <= 9; i++) {
			int num = scan.nextInt();
			if(num > max) {
				max = num;
				max_loc = i;
			}
		}
		System.out.println(max);
		System.out.println(max_loc);
	}

}
