package Intermediate.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q1216 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수
		int T = 10;

		// 8 x 8로 char가 담길 배열
		char arr[][] = new char[100][100];

		// 결과값 변수
		int len = 100, result = 0;
		// 테스트 케이스 개수만큼 반복
		while (T-- > 0) {
			len = 100;
			int tNum = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			A: while (len > 0) {
				// 행 또는 열을 의미할 i
				for (int i = 0; i < 100; i++) {
					// 회문의 시작점을 의미하는 j
					for (int j = 0; j <= 100 - len; j++) {
						// 회문의 중간점까지를 의미하는 k
						for (int k = j; k < j + (len / 2); k++) {
							// 행을 먼저 비교
							if (arr[i][k] == arr[i][j + j + len - 1 - k]) {
//								System.out.println(i + " " + j + " " + k + " " + (j + j + len - 1 - k) + " " + len + " " + arr[i][k] + " " + arr[i][j + len - 1 - k]);
								if (k == j + len / 2 - 1) {
//									System.out.println(k);
									result = len;
									break A;
								}
							} else {
								break;
							}
						}
						for (int k = j; k < j + len / 2; k++) {
							if (arr[k][i] == arr[j + j + len - 1 - k][i]) {
								if (k == j + len / 2 - 1) {
//									System.out.println(i + " " + k + " " + arr[i][k] + " " + arr[i][j + len - 1 - k]);
									result = len;
									break A;
								}
							} else
								break;
						}
					}
				}
				len--;
			}
			System.out.println("#" + tNum + " " + result);
		}
		br.close();
	}

}
