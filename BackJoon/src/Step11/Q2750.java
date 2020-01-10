package Step11;
import java.util.Scanner;

public class Q2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// 배열 크기 입력
		int N = scan.nextInt();
		// 입력받은 배열 크기로 배열 생성
		int arr[] = new int[N];
		
		// 정렬할 배열 입력
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
//		// 선택 정렬인 줄 알았는데 이건 무슨 정렬이지?
//		// 마지막 숫자 이전까지 첫번째 반복문
//		for(int i = 0; i < N - 1; i++) {
//			// i번째 위치부터 정렬되므로, i 다음 숫자부터 마지막 숫자까지 두번째 반복문
//			for(int j = i + 1; j < N; j++) {
//				// i번째 숫자가 j번째 숫자보다 크다면 두 숫자를 교체
//				if(arr[i] > arr[j]) {
//					int tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
//				}
//			}
//		}
		
//		// 선택 정렬
//		// 마지막 숫자 이전까지 첫번째 반복문
//		for(int i = 0; i < N - 1; i++) {
//			// 최소값 설정
//			int min = Integer.MAX_VALUE;
//			// 최소값 위치
//			int minLoc = 0;
//			// i번째 숫자부터 마지막 숫자까지 중 최소값 탐색
//			for(int j = i; j < N; j++) {
//				if(arr[j] < min) {
//					min = arr[j];
//					minLoc = j;
//				}
//			}
//			// 탐색완료한 최소값과 i번째 숫자를 교체
//			int tmp = arr[i];
//			arr[i] = arr[minLoc];
//			arr[minLoc] = tmp;
//		}
		
//		// 거품 정렬
//		// 마지막 숫자 이전까지 첫번째 반복문
//		for(int i = 0; i < N - 1; i++) {
//			// 마지막 위치부터 정렬되므로 N - i - 1까지 두번째 반복문
//			for(int j = 0; j < N - i - 1; j++) {
//				// j번째 숫자가 j + 1번째 숫자보다 크다면 두 숫자를 교체
//				if(arr[j] > arr[j + 1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = tmp;
//				}
//			}
//		}
		
		// 삽입 정렬
		// 첫번째 숫자를 제외하고 마지막 숫자까지 첫번째 반복문
		for(int i = 1; i < N; i++) {
			// 위치를 찾아서 넣을 i번째 숫자
			int tmp = arr[i];
			// i번째 숫자를 i-1부터 0까지 비교하여 위치를 찾아넣는다.
			for(int j = i - 1; j >= 0; j--) {
				// 정렬할 숫자 tmp의 위치탐색 tmp보다 큰 수들은 전부 하나씩 뒤로 밀어준다.
				if(arr[j] > tmp) {
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		// 정렬한 배열 출력
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
