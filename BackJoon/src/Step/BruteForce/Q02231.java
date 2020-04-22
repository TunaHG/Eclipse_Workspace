package Step.BruteForce;

import java.util.Scanner;

public class Q02231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int[1000001];
		
		int sum, num;
		for(int i = 1; i <= 1000000; i++) {
			num = i;
			sum = num;
			while(true) {
				if(num == 0) break;
				sum += num % 10;
				num /= 10;
			}
			arr[i] = sum;
		}
		
		int N = scan.nextInt();
		for(int i = 1; i <= 1000000; i++) {
			if(arr[i] == N) {
				System.out.print(i);
				break;
			}
			if(i == 1000000 && arr[i] != N) {
				System.out.print(0);
			}
		}
		scan.close();
	}

}
