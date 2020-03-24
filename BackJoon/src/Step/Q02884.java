package Step;

import java.util.Scanner;

public class Q02884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int hour = scan.nextInt();
		int minute = scan.nextInt();
		int time = 45;
		
		if(minute < time) {
			if(hour == 0) {
				hour = 23;
			} else {
				hour--;
			}
			minute = 60 - time + minute;
		} else {
			minute = minute - time;
		}
		System.out.print(hour + " " + minute);
	}

}
