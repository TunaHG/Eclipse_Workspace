package Step12;
import java.util.Scanner;

public class Q1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int arr[][] = new int[T][3];
		
		for(int i = 0; i < 3; i++) {
			arr[0][i] = scan.nextInt();
		}
		
		int red, green, blue;
		for(int i = 1; i < T; i++) {
			red = scan.nextInt();
			green = scan.nextInt();
			blue = scan.nextInt();
			
			arr[i][0] = red + Math.min(arr[i - 1][1], arr[i - 1][2]);
			arr[i][1] = green + Math.min(arr[i - 1][0], arr[i - 1][2]);
			arr[i][2] = blue + Math.min(arr[i - 1][0], arr[i - 1][1]);
		}
		
		System.out.print(Math.min(arr[T - 1][0], Math.min(arr[T - 1][1], arr[T - 1][2])));
//		// 틀렸습니다.
//		for(int i = 0; i < T; i++) {
//			for(int j = 0; j < 3; j++) {
//				arr[i][j] = scan.nextInt();
//			}
//		}
//		
//		int sum = 0;
//		int preMinLoc = 0;
//		int result = Integer.MAX_VALUE;
//		int min, minLoc = 0;
//		for(int i = 0; i < 3; i++) {
//			// 총합 초기화
//			sum = arr[0][i];
//			// 이전의 최소값 위치 초기화
//			preMinLoc = i;
//			// 첫 행을 제외한 모든 행 탐색하는 반복문
//			for(int j = 1; j < T; j++) {
//				// 최소값 초기화
//				min = Integer.MAX_VALUE;
//				for(int k = 0; k < 3; k++) {
//					// 이전의 최소값 위치는 최소값탐색에서 넘어가야함
//					if(k == preMinLoc) continue;
//					// 최소값보다 작다면
//					if(arr[j][k] < min) {
//						// 최소값 변경
//						min = arr[j][k];
//						// 최소값 위치변경
//						minLoc = k;
//					}
//				}
//				// 최소값을 총합에 추가
//				sum += min;
//				// 최소값 위치를 이전의 최소값 위치 변수에 입력
//				preMinLoc = minLoc;
//			}
//			// 결과 중 최솟값을 비교하여 최소값을 결과값으로 입력
//			if(sum < result) result = sum;
//		}
//		System.out.print(result);
		
//		// 틀렸습니다.
//		// 총합을 넣을 변수 선언
//		int sum = 0;
//		// 값을 입력받을 변수, 최소값 변수, 최소값 위치 변수 선언
//		int num, min, minLoc = 0;
//		// 이전의 칠한 색의 위치 변수 선언
//		// 0이 빨강, 1이 초록, 2가 파랑
//		int preMinLoc = 4;
//		
//		// 집의 수만큼 반복문 진행
//		while(T-- > 0) {
//			// 최소값 초기화
//			min = Integer.MAX_VALUE;
//			
//			// 세개의 값을 비교하여 최소값 탐색
//			for(int i = 0; i < 3; i++) {
//				num = scan.nextInt();
//				// 이전에 칠한 색이라면 최소값으로 비교안하고 넘어감
//				if(i == preMinLoc) continue;
//				// 최소값 탐색
//				if(num < min) {
//					min = num;
//					minLoc = i;
//				}
//			}
//			// 총합에 최소값 더함
//			sum += min;
//			// 이번에 칠한 색을 이전에 칠한색에 저장
//			preMinLoc = minLoc;
//		}
//		
//		System.out.print(sum);
	}

}
