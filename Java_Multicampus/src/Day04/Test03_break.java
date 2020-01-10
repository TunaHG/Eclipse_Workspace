package Day04;

public class Test03_break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A: for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				if (j == 5)
					break A;
//				if (j == 5)
//					continue;
				System.out.printf(" %2d * %2d = %2d |", j, i, j * i);
			}
			System.out.println();
		}
	}

}