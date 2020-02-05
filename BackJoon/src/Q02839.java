
import java.util.Scanner;

public class Q02839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int min = 10000;
		for(int x = 0; x <= N/5; x++) {
			for(int y = 0; y <= N/3; y++) {
				if(5 * x + 3 * y == N) {
					if(x + y < min) min = x + y;
				}
			}
		}
		if(min == 10000) {
			System.out.print(-1);
		}
		else {
			System.out.print(min); 
		}
		scan.close();
	}

}
