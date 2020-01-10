package Day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import Util.myUtil;

public class Test05_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
//		Set<String> set = new TreeSet<String>();
		set.add("lee");
		set.add("kim");
		set.add("park");
		set.add("ko");
		set.add("lee");
		
//		Iterator<String> it = set.iterator();
//		while (it.hasNext()) {
//			String data = it.next();
//			System.out.println(data);
//		}
//		System.out.println();
		
		myUtil.iteratorPrint(set);
	}

}
