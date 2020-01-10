package Day03;

public class Test06_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('C'-'A');
		for (int i = 0; i < 3; i++) {
			System.out.println("hello java " + i);
		}
		System.out.println("--------------------");
		
		int sum = 0;
		for (int i = 1; i < 10; i++) {
			if(i % 2 == 1) {
				System.out.print(i + "+");
				sum += i;
			}
		}
		System.out.println();
		System.out.println(sum);
		System.out.println("--------------------");
		
//		String name = "Hagyun Kim";
//		System.out.print(name.charAt(0));
//		for(int i = 1; i < name.length() - 1; i++) {
//			if(name.charAt(i) != ' ') System.out.print("*");
//			else System.out.print(" ");
//		}
//		System.out.print(name.charAt(name.length() - 1));
		String name = "홍길동";
		System.out.println(name.charAt(0) + "**");
		
		String msg = "hello java";
		System.out.println(msg);
		for(int i = msg.length() - 1; i >= 0; i--) {
			System.out.print(msg.charAt(i));
		}
		
		System.out.println();
//		System.out.println("End");
	}

}
