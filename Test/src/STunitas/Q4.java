package STunitas;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		// nextInt()이후 엔터제거
		sc.nextLine();
		
		// 입력받을 객체
		String str;
		// ()가 완전한지 파악할 변수
		int cnt;
		
		// 테스트 케이스 개수만큼 반복
		while(T-- > 0) {
			cnt = 0;
			str = sc.nextLine();
			
			// String길이만큼 반복
			for (int i = 0; i < str.length(); i++) {
				// (가 나왔다면 cnt + 1
				if(str.charAt(i) == '(') cnt++;
				// )가 나왔다면 cnt - 1
				if(str.charAt(i) == ')') cnt--;
			}
			// cnt == 0 이면 ()가 온전한 형태로 끝났음을 의미
			if(cnt == 0) System.out.println("Yes");
			else System.out.println("No");
		}
		sc.close();
	}

}
/*
3
(())
()((
()(()())

Yes
No
Yes
*/