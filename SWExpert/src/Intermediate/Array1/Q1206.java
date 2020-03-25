package Intermediate.Array1;

import java.util.Scanner;

public class Q1206 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
			int width = scan.nextInt();
			int cnt = 0;
			
			int apart[][] = new int[256][width];
			for(int k = 0; k < width; k++) {
				int num = scan.nextInt();
				for(int j = 0; j < num; j++) {
					apart[j][i] = 1;
				}
			}
			
			for(int j = 2; j < width - 2; j++) {
				for(int k = 1; k <= 255; k++) {
					if(apart[k][j] == 1) {
						if(apart[k][j - 1] == 0 && apart[k][j - 2] == 0 && apart[k][j + 1] == 0 && apart[k][j + 2] == 0)
							cnt++;
					}
				}
			}
			System.out.println("#" + i + " " + cnt);
		}
		long endTime = System.currentTimeMillis();
		long time = (endTime - startTime);
		System.out.println(time);
	}

}
