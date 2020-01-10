package Day06;

import java.util.Arrays;

import Day05.Calc;
import Util.myUtil;

public class Test01_util {
	public static void main(String[] args) {
		int i = Calc.add(1,2,3,4,5,6,7,8,9,10);
		System.out.println(i);
		
		i = Calc.add();
		System.out.println(i);
		
		System.out.println(Calc.add(1, 1,5,6,7));
		System.out.println();
		System.out.println("================================");
    	int[] d  = {1,21,3,43,15,6,7,18,9,10}; 	
    	int[] r =  myUtil.sort(d);
    	
    	System.out.println(Arrays.toString(d));
    	System.out.println(Arrays.toString(r));
    	
    	System.out.println("=======================");
    	System.out.println(myUtil.max(55, 11));
	}
}



