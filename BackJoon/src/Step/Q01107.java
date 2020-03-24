package Step;

import java.util.Scanner;

public class Q01107 {
	static boolean broken[] = new boolean[10];
	static int canMove(int channel) {
		int length = 0;
		
		if(channel == 0) return broken[0]?0:1;
		
		while(channel > 0) {
			if(broken[channel % 10]) return 0;
			
			length += 1;
			channel /= 10;
		}
		return length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int goal = scan.nextInt();
		int M = scan.nextInt();
		
		for(int i = 0; i < M; i++) {
			broken[scan.nextInt()] = true;
		}
		scan.close();
		
		int answer = Math.abs(100 - goal);
		
		for(int i = 0; i < 1000000; i++) {
			int channel = i;
			int length = canMove(channel);
			if(length > 0) {
				int press = Math.abs(channel - goal);
				if(answer > length + press) answer = length + press; 
			}
		}
		System.out.print(answer);
	}

}
