package Day05;

import java.util.Arrays;

public class Test03_CBR {

	public static void main(String[] args) {
         //System.out.println(args.length);
         //System.out.println(Arrays.toString(args));
         
//		if(args.length == 0) {
//			System.out.println("파라미터넘겨주세요 ~~");
//			return;
//		}
//		System.out.println(args[0].charAt(0)+"**");
//         
         
		int[] num = new int[] {9,7,1,2,3}; 
		int[] num2 = num;
		int[] num3 = num.clone();

		num2[2] = 99;
		
		Arrays.sort(num3);
		
		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(num2));
		System.out.println(Arrays.toString(num3));
		
		
		String url = "http://myweb/admin/login.do";
		//System.out.println(url.lastIndexOf('/'));
		String r = url.substring(url.lastIndexOf('/'));
		System.out.println(url);
		System.out.println(r);
		
		
	}
}


