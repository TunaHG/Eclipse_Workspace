package STunitas;

import java.util.Scanner;

public class Q2 {
	static int result;
	static String str1, str2;
	public static void Common(String str, int stdLoc, int str1Loc, int str2Loc, int len) {
		// 탐색위치가 String 마지막인자를 넘어서면 재귀함수 끝
		if(stdLoc >= str.length()) {
			result = Math.max(result, len);
			return ;
		}

		// str1에서 기준이 되는 str의 값과 같은 값이 str1Loc이후에 존재하면 위치 추출, 아니면 -1 추출 
		int loc1 = str1.indexOf(str.charAt(stdLoc), str1Loc + 1);
		// -1이 추출됬다면 없다는 것이므로 다음 탐색을 위해 str1Loc로 초기화시켜줌
		if(loc1 == -1) {
			result = Math.max(result, len);
			return;
		}
		
		// str2에서 기준이 되는 str의 값과 같은 값이 str2Loc이후에 존재하면 위치 추출, 아니면 -1 추출
		int loc2 = str2.indexOf(str.charAt(stdLoc), str2Loc + 1);
		// -1이 출력됬다면 없다는 것이므로 다음 탐색을 진행함
		if(loc2 == -1) {
			result = Math.max(result, len);
			return;
		}
		
		// stdLoc이후의 str 인자에 대하여 재귀함수 호출
		for(int i = stdLoc; i < str.length(); i++) {
			Common(str, i + 1, loc1, loc2, len + 1);
		}
	}
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		sc.nextLine();
		
		String firstStr, secondStr, thirdStr;
		while(T-- > 0) {
			result = 0;
			firstStr = sc.nextLine();
			secondStr = sc.nextLine();
			thirdStr = sc.nextLine();
			
			if(firstStr.length() < secondStr.length()) {
				if(firstStr.length() < thirdStr.length()) {
					str1 = secondStr;
					str2 = thirdStr;
					for(int i = 0; i < firstStr.length(); i++) {
						Common(firstStr, i, 0, 0, 1);
					}
				} else {
					str1 = firstStr;
					str2 = secondStr;
					for(int i = 0; i < thirdStr.length(); i++) {
						Common(thirdStr, i, 0, 0, 1);
					}
				}
			} else {
				if(secondStr.length() < thirdStr.length()) {
					str1 = firstStr;
					str2 = thirdStr;
					for(int i = 0; i < secondStr.length(); i++) {
						Common(secondStr, i, 0, 0, 1);
					}
				} else {
					str1 = firstStr;
					str2 = secondStr;
					for(int i = 0; i < thirdStr.length(); i++) {
						Common(thirdStr, i, 0, 0, 1);
					}
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}


/*
2
abcdefg
acfbdeg
aabbccddeeffgg
qwerasdfzxcv
qwerasdfzxcv
qwerasdfzxcv

각각의 테스트 케이스에 대해 가장 긴 공통 부분의 길이를 출력한다.
5
acdeg가 abcdefg, acfbdeg, aabbccddeeffgg의 가장 긴 공통 부분 문자열이고 5글자로 이루어져 있다.
12
세 문자열이 모두 동일하므로 입력 문자열의 길이 그대로가 정답이 된다.
*/