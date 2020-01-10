package Prob;

public class Prob04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Prob04.leftPad("SDS", 6, '#'));
		System.out.println(Prob04.leftPad("SDS", 5, '$'));
		System.out.println(Prob04.leftPad("SDS", 2, '&'));

		Prob04 p5 = new Prob04();
		System.out.println(p5.rightPad("SDS", 6, '#'));
	}

	public static String leftPad(String str, int size, char padChar) {
		StringBuilder sb = new StringBuilder();
//		if (str.length() < size) {
//			for(int i = str.length(); i < size; i++) {
//				// str = padChar + str;
//				sb.append(padChar);
//			}
//		}
		for (int i = str.length(); i < size; i++) {
			// str = padChar + str;
			sb.append(padChar);
		}

		sb.append(str);

		return sb.toString();
	}

	public String rightPad(String str, int size, char padChar) {
		StringBuilder sb = new StringBuilder();

		sb.append(str);
		for (int i = str.length(); i < size; i++) {
			// str = padChar + str;
			sb.append(padChar);
		}

		return sb.toString();
	}
}
