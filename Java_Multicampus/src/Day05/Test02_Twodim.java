package Day05;

import java.util.Arrays;

public class Test02_Twodim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t1 = new int[4][3];

		for (int i = 0; i < t1.length; i++) {
			for (int j = 0; j < t1[i].length; j++) {
				System.out.print(t1[i][j]);
			}
			System.out.println();
		}
		System.out.println("=========================");
		for (int i = 0; i < t1.length; i++) {
			System.out.println(Arrays.toString(t1[0]));
		}
		
		System.out.println("=========================");
		int[][] t2 = {{1, 2, 3}, {4, 5, 6, 7, 8, 9, 10}, {1}, {9, 8, 7}};
		for (int i = 0; i < t2.length; i++) {
			for (int j = 0; j < t2[i].length; j++) {
				System.out.print(t2[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("=========================");
		char[] c = {'A', 'B', 'C', 'D'};
		System.out.println(Arrays.toString(c));
		
		String a = "abcdefghijklmnopqrstuvwxyz";
		char[] aa = a.toCharArray();
		
		System.out.println(a);
		System.out.println(Arrays.toString(aa));
	}

}
