package Step09;
import java.util.Scanner;

public class Q4948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int num = scan.nextInt();
			if(num == 0) break;
			int cnt = 0;
			int SW = 0;
			for(int i = num + 1; i <= num * 2; i++) {
				int root = (int)Math.sqrt(i) + 1;
				for(int j = 2; j < root; j++) {
					if(i % j == 0) {
						SW = 1;
						break;
					}
				}
				if(SW == 0) cnt++;
				SW = 0;
			}
			System.out.println(cnt);
		}
	}

}
