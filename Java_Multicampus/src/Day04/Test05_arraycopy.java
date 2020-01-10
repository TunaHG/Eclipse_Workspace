package Day04;

import java.util.Arrays;

public class Test05_arraycopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[10];
		
		for (int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(num));
		
		int[] tmp = new int[num.length * 2];
		System.arraycopy(num, 0, tmp, 10, num.length);
		System.out.println(Arrays.toString(tmp));
		
		// tmp가 가리키는 주소값을 num의 값으로 넣어버림.
		num = tmp;
		System.out.println(Arrays.toString(num));
	}

}
