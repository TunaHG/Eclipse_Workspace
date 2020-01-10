package Workshop2;

public class Prob06 {
	public static void main(String[] args) {
		for(int k = 0; k < 3; k++) {
			for(int i = 1; i <= 3; i++) {
				for(int j = 2 + k * 3; j <= 4 + k * 3; j++) {
					if(j > 9) continue;
					System.out.print(j + "*" + i + "=" + j*i + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 3; j++) {
				int x = j + 1 + (i - 1) / 3 * 3;
				int y = i % 3 == 0 ? 3 : i % 3;
				if(x > 9) break;
				System.out.print(x + "*" + y + "=" + x*y + "\t");
			}
			System.out.println();
			if(i % 3 == 0) System.out.println();
		}
	}
}
