package Step01;
import java.util.Scanner;

public class Q2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		System.out.println(num1 * (num2 % 10));
		System.out.println(num1 * (num2 % 100 / 10));
		System.out.println(num1 * (num2 / 100));
		System.out.print(num1 * num2);
	}

}
