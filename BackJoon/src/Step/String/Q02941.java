package Step.String;

import java.util.Scanner;

public class Q02941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		scan.close();
		int cnt = 0;
		int len = str.length();
		str += "111";
		
		int idx = 0;
		while(true) {
			if(idx >= len) break;
			if(str.substring(idx, idx+3).equals("dz=")) {
				cnt++;
				idx += 3;
				continue;
			}
			switch(str.substring(idx, idx + 2)) {
			case "c=":
				cnt++;
				idx += 2;
				continue;
			case "c-":
				cnt++;
				idx += 2;
				continue;
			case "d-":
				cnt++;
				idx += 2;
				continue;
			case "lj":
				cnt++;
				idx += 2;
				continue;
			case "nj":
				cnt++;
				idx += 2;
				continue;
			case "s=":
				cnt++;
				idx += 2;
				continue;
			case "z=":
				cnt++;
				idx += 2;
				continue;
			}
			cnt++;
			idx++;
		}
		System.out.print(cnt);
	}

}
