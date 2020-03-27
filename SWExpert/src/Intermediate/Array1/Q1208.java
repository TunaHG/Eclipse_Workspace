package Intermediate.Array1;

import java.util.Scanner;

public class Q1208 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 가로길이를 이용한 1차원 배열 선언
		int arr[] = new int[100];

		// 테스트케이스 10번만큼 반복
		for (int T = 1; T <= 10; T++) {
			// 주어지는 dump횟수 입력
			int dump = scan.nextInt();

			// 가로길이 100 중 최대값 위치와 최소값위치 초기화
			int maxLoc = 0, minLoc = 0;
			// 배열의 크기 100만큼 반복
			for (int i = 0; i < 100; i++) {
				// 가로길이 100에 해당하는 배열의 값에 해당 위치의 상자의 높이 값 입력
				arr[i] = scan.nextInt();
				// 상자의 높이 최대값 위치 탐색
				if (arr[maxLoc] < arr[i])
					maxLoc = i;
				// 상자의 높이 최소값 위치 탐색
				if (arr[minLoc] > arr[i])
					minLoc = i;
			}

			// 주어진 dump횟수만큼 반복문
			for (int i = 0; i < dump; i++) {
				// 최대값과 최소값의 차이가 1이하라면 더이상 옮길 상자가 없음
				if (arr[maxLoc] - arr[minLoc] <= 1)
					break;
				// 최대값위치에서 1을빼서 최소값위치에 추가
				arr[maxLoc]--;
				arr[minLoc]++;
				// 전체 배열중 최대값위치와 최소값위치 다시 탐색
				for (int j = 0; j < 100; j++) {
					if (arr[maxLoc] < arr[j])
						maxLoc = j;
					if (arr[minLoc] > arr[j])
						minLoc = j;
				}
			}
			// 각 테스트케이스마다 결과값 출력
			System.out.println("#" + T + " " + (arr[maxLoc] - arr[minLoc]));
		}
	}

}
