package Step09;
import java.util.Scanner;

public class Q3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int x[] = new int[1001];
		int y[] = new int[1001];
		
		for(int i = 0; i < 3; i++) {
			int numX = scan.nextInt();
			int numY = scan.nextInt();
			x[numX]++;
			y[numY]++;
		}
		scan.close();
		for(int i = 1; i < 1001; i++) {
			if(x[i] % 2 != 0) System.out.print(i + " ");
		}
		for(int i = 1; i < 1001; i++) {
			if(y[i] % 2 != 0) System.out.print(i);
		}
	}

}
