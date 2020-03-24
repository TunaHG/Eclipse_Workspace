package Step;

import java.util.Scanner;

public class Q15596 {
	public static long sum(int[] a) {
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int[5];
		for(int i = 0; i < 5; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.print(sum(arr));
	}
}
