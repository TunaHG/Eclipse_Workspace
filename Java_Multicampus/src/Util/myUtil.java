package Util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class myUtil {

	public static int[] sort(int[] a) {
		int[] num = a.clone();

		for (int i = 0; i < num.length; i++) {
			int min = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[min] > num[j]) {
					min = j;
				}
			}
			if (i != min) {
				myUtil.swap(num, i, min);
			}
		}
		return num;
	}

	public static void swap(int[] num, int i, int min) {
		int tmp = num[i];
		num[i] = num[min];
		num[min] = tmp;
		
		return;
	}
	
	public static int max(int a, int b) {
		return Math.max(a, b); 
	}
	
	public static void iteratorPrint(List<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String data = it.next();
			System.out.println(data);
		}
	}
	public static void iteratorPrint(Set<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String data = it.next();
			System.out.println(data);
		}
	}
}
