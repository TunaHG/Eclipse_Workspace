package Step;

import java.util.Arrays;
import java.util.Scanner;

public class Q02447 {
	static int num;
	static char arr[][];
	static void star(int x, int y, int n) {
		if(n == 1) {
			arr[x][y] = '*';
			return ;
		}
		int m = n / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 & j == 1) continue;
				star(x + m * i, y + m * j, m);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		num = scan.nextInt();
		scan.close();
		arr = new char[num][num];
		for(int i = 0; i < num; i++) {
			Arrays.fill(arr[i], ' ');
		}
		star(0, 0, num);
		
		for(int i = 0; i < num; i++) {
			System.out.println(arr[i]);
		}
	}

}
