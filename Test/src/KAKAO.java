import java.util.Scanner;

public class KAKAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String s = scan.nextLine();
		
		String ss = s.substring(0, 1);
		
		s = s.replace("a", "");
		
		System.out.println(ss);
		System.out.println(s);
	}

}
