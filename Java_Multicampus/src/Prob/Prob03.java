package Prob;

import java.util.Arrays;

public class Prob03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strData  = { "Java Programming" , "JDBC", "Oracle10g", "JSP/Servlet" };

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < strData[i].length(); j++) {
				System.out.print(strData[i].charAt(strData[i].length() - j - 1));
			}
			System.out.println();
		}
		
//		Q1.
//		String msg = "yes";
//		System.out.println(msg.equals("yes"));
		
//		Q2.
//		int sum = 0;
//		boolean flag = true;
//		int num = 1;
//		int cnt = 0;
//		while(true) {
//			if(sum > 100) break;
//			if(flag == true) {
//				sum += num++;
//				flag = false;
//			}
//			else {
//				sum -= num++;
//				flag = true;
//			}
//			cnt++;
//		}
//		System.out.println(cnt);
		
//		Q3.
//		int[] arr = {10, 20, 30, 40, 50};
//		int sum = 0;
//		for(int i = 0; i < 5; i++) {
//			sum += arr[i];
//		}
//		System.out.println(sum);
		int num[] = new int[10];
		
		int i = 0;
		A : while(true) {
			if(num[9] != 0) break;
			num[i] = (int) (Math.random() * 100) + 1;
			for(int j = 0; j < i; j++) {
				if(num[j] == num[i]) {
					System.out.println(num[i]);
					continue A;
				}
			}
			i++;
		}
		System.out.println(Arrays.toString(num));
	}

}
