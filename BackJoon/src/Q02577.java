
import java.util.Scanner;

public class Q02577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		scan.close();
		
		int mul = num1 * num2 * num3;
		int count[] = new int[10];
//		while(mul > 0) {
//			count[mul % 10]++;
//			mul /= 10;
//		}
		String input = String.valueOf(mul);
		for(int i = 0; i < input.length(); i++) {
			count[input.charAt(i) - '0']++;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
	}

}
