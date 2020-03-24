package Intermediate;

import java.util.Arrays;
import java.util.Scanner;

public class Q1204 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int score[] = new int[101];
		while(T-- > 0) {
			Arrays.fill(score, 0);
			int num = scan.nextInt();
			for(int i = 0; i < 1000; i++) {
				score[scan.nextInt()]++;
			}
			int max = 0;
			for(int i = 1; i < 101; i++) {
				if(score[i] >= score[max]) {
					max = i;
				}
			}
			System.out.println("#" + num + " " + max);
		}
	}

}
