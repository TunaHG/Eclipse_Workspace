package Day04;

public class Test02_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("i = %d, j = %d | ", i, j);
			}
			System.out.println();
		}
		System.out.println("=======================");

		int i = 0;
		do  {
			System.out.println("~~~~~");
			i++;
		} while(i > 10);
		
		boolean flag = true;
		while(flag) {
			System.out.println("~~~~~~");
			int num = (int)(Math.random() * 10);
			System.out.println(num);
			if(num % 3 == 0) flag = !flag;
		}
	}

}
