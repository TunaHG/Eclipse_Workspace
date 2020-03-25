package Step;

import java.util.Scanner;

public class Q05543 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 햄버거 값중 최소값, 음료수 값중 최소값을 저장할 변수
		int burgerMin = Integer.MAX_VALUE, drinkMin = Integer.MAX_VALUE;
		// 햄버거 값중 최소값 저장
		for(int i = 0; i < 3; i++) {
			burgerMin = Math.min(burgerMin, scan.nextInt());
		}
		// 음료수 값중 최소값 저장
		for(int i = 0 ; i < 2; i++) {
			drinkMin = Math.min(drinkMin, scan.nextInt());
		}
		// 두 개의 최소값 더한후 50을 빼서 세트값 계산
		System.out.println(burgerMin + drinkMin - 50);
	}
}
