package Workshop4;

public class Prob03 {
	public static void main(String[] args) {
//		int num = Integer.parseInt(args[0]);
		int num = 5;
		
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = num; i <= 10; i++) {
			if(i % 3 != 0 && i % 5 != 0) {
				sum += i;
				sb.append(i);
				sb.append("+");
			}
		}
		String str = sb.toString();
		System.out.println(str.substring(0, str.length() - 1));
		System.out.println("결과: " + sum);
	}
}
