package Prob;

public class Prob02 {

	public static void main(String[] args) {
		String sourceString = "everyday we have is one more than we deserve";
		String encodedString = "";

		StringBuilder sb = new StringBuilder();
		// 프로그램을 구현부 시작.
		// 참고 : 문자 'a'의 정수값은 97이며, 'z'는 122입니다.
		char tmp;
		for (int i = 0; i < sourceString.length(); i++) {
			if (sourceString.charAt(i) == ' ') {
				sb.append(" ");
				continue;
			}
			tmp = (char) (sourceString.charAt(i) + 3);
			if (tmp > 'z') {
				sb.append((char) (tmp - 26));
			} else
				sb.append(tmp);
		}
		encodedString = sb.toString();

		// 프로그램 구현부 끝.

		System.out.println("암호화할 문자열 : " + sourceString);
		System.out.println("암호화된 문자열 : " + encodedString);

//		Q1.
//		int year = 2000;
//		if(year % 400 == 0) {
//			if(year % 4 == 0) {
//				if (year % 100 != 0) System.out.println("윤년");
//			}
//		}

//		Q2.
//		int sum = 0;
//		for(int i = 1; i <= 20; i++) {
//			if(i % 2 != 0 || i % 3 != 0) {
//				sum += i;
//			}
//		}
//		System.out.println(sum);

//		Q3.
//		int sum = 0;
//		for(int i = 1; i <= 10; i++) {
//			for(int j = 1; j <= i; j++) {
//				sum += j;
//			}
//		}
//		System.out.println(sum);
	}
}