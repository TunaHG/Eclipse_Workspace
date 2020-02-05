
import java.util.Scanner;

public class Q10872 {
	static int factorial(int num) {
		if(num == 0) return 1;
		return num * factorial(num - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		System.out.println(factorial(num));
	}

}
