package Workshop5;

public class Prob01 {
	public static void main(String[] args) {
//		String str = args[0];
		String str = "Morning";
		
		System.out.println("입력: " + str);
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(str.length() - 1 - i));
		}
		System.out.println();
		char[] cha = str.toCharArray();
		for (int i = 0; i < cha.length; i++) {
			System.out.print(cha[cha.length - i - 1]);
		}
	}
}
