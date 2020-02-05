
import java.util.Scanner;

public class Q01330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		if(num1 > num2) {
			System.out.print(">");
		} else if(num1 < num2) {
			System.out.print("<");
		} else {
			System.out.print("==");
		}
	}

}
