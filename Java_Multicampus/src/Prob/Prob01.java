package Prob;

public class Prob01 {
	public static void main(String[] args) {

		int num = 0;
		System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : 0));

		char ch = 'A';
		char lowerCase = (ch >= 'A' && ch <= 'Z') ? (char) (ch + 32) : ch;
		System.out.print("ch:" + ch);
		System.out.println(" to lowerCase :" + lowerCase);
	}
}