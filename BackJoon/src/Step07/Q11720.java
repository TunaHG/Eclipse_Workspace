package Step07;
import java.util.Scanner;

public class Q11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = Integer.parseInt(scan.nextLine());
		String str = scan.nextLine();
		scan.close();
		
		int sum = 0;
		for(int i = 0; i < num; i++) {
			sum += (str.charAt(i) - '0');
		}
		System.out.print(sum);
	}

}
