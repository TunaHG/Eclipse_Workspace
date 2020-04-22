package Step.Math1;

import java.util.Scanner;

public class Q01193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int value = 1;
		int row = 1;
		int col = 1;
		while(true) {
			if(value == N) {
				break;
			}
			if((row + col) % 2 == 0) {
				if(row != 1) {
					row--;
					col++;
					value++;
				} else {
					col++;
					value++;
				}
			} else {
				if(col != 1) {
					col--;
					row++;
					value++;
				} else {
					row++;
					value++;
				}
			}
		}
		System.out.print(row + "/" + col);
	}

}
