
import java.util.Scanner;

public class Q02292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int x = 1;
		int y = 1;
		while(true) {
			if(N <= y) {
				break;
			}
			y += 6*x;
			x++;
		}
		System.out.print(x);
	}

}
