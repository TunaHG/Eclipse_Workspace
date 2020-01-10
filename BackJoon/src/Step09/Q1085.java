package Step09;
import java.util.Scanner;

public class Q1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		int w = scan.nextInt();
		int h = scan.nextInt();
		scan.close();
		
		int arr[] = {x, y, w - x, h - y};
		int min = 1000;
		for(int i = 0; i < 4; i++) {
			if(arr[i] < min) min = arr[i];
		}
		System.out.print(min);
	}

}
