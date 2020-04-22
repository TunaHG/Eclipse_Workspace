package Step.Function;

import java.util.Scanner;

public class Q01065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int arr[] = new int[1001];
		for(int i = 1; i < 100; i++) {
			arr[i] = 1;
		}
		
		for(int i = 100; i < 1000; i++) {
			String str = String.valueOf(i);
			int dif1 = (str.charAt(0) - '0') - (str.charAt(1) - '0');
			int dif2 = (str.charAt(1) - '0') - (str.charAt(2) - '0');
			if(dif1 == dif2) arr[i] = 1;
		}
		
		int num = scan.nextInt();
		int cnt = 0;
		for(int i = 1; i <= num; i++) {
			if(arr[i] == 1) cnt++;
		}
		System.out.println(cnt);
	}

}
