package Step07;
import java.util.Scanner;

public class Q2941_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String input = scan.nextLine();
		scan.close();
		
		for(int i = 0; i < word.length; i++) {
			if(input.contains(word[i])) {
				input = input.replaceAll(word[i], "*");
			}
		}
		int result = input.length();
		System.out.print(result);
	}

}
