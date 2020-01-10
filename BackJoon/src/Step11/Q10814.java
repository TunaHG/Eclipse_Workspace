package Step11;
import java.util.Scanner;

public class Q10814 {
	// 정렬을 진행할 임시 배열
	static String sorted[][];
	// 분할을 진행할 재귀 함수
	static void mergeSort(String arr[][], int start, int end) {
		// 크기가 1이면 재귀 함수를 벗어남
		if(end <= start) return ;
		
		// 분할의 기준이 될 가운데 값 계산
		int mid = (start + end) / 2;
		// 왼쪽 분할 재귀함수 호출
		mergeSort(arr, start, mid);
		// 오른쪽 분할 재귀함수 호출
		mergeSort(arr, mid + 1, end);
		// 합병 진행
		merging(arr, start, mid, end);
	}
	// 합병을 진행할 합병 함수
	static void merging(String arr[][], int start, int mid, int end) {
		// 왼쪽 분할의 시작점, 오른쪽 분할의 시작점, 임시 배열의 시작점 선언
		int i = start, j = mid + 1, k = start;
		
		// 왼쪽과 오른쪽 분할중 하나를 전부 정렬할 때까지의 반복문
		while(i <= mid && j <= end) {
			// i의 나이가 적다면 i를 임시 배열에 추가하여 정렬, 둘의 나이가 같다면 i가 먼저 나왔을 것이므로 i 먼저 정렬
			if(Integer.valueOf(arr[i][0]) <= Integer.valueOf(arr[j][0])) {
				sorted[k][0] = arr[i][0];
				sorted[k++][1] = arr[i++][1];
			}
			// j의 나이가 적다면 j를 임시 배열에 추가하여 정렬
			else if(Integer.valueOf(arr[i][0]) > Integer.valueOf(arr[j][0])) {
				sorted[k][0] = arr[j][0];
				sorted[k++][1] = arr[j++][1];
			}
		}
		// 왼쪽 분할이 끝났다면
		if(i > mid) {
			// 오른쪽 분할이 끝날때까지 반복문
			while(j <= end) {
				// 오른쪽 분할을 그대로 임시 배열에 추가하여 정렬
				sorted[k][0] = arr[j][0];
				sorted[k++][1] = arr[j++][1];
			}
		}
		// 오른쪽 분할이 끝났다면
		if(j > end) {
			// 왼쪽 분할이 끝날때까지 반복문
			while(i <= mid) {
				// 왼쪽 분할을 그대로 임시 배열에 추가하여 정렬
				sorted[k][0] = arr[i][0];
				sorted[k++][1] = arr[i++][1];
			}
		}
		// 임시 배열을 기존 배열에 대입함으로서 정렬 완성
		for(int x = start; x <= end; x++) {
			arr[x][0] = sorted[x][0];
			arr[x][1] = sorted[x][1];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 배열 개수 입력
		int N = scan.nextInt();
		
		// 입력받은 배열 개수를 이용한 배열 선언
		String arr[][] = new String[N][2];
		// 입력받은 배열 개수를 이용한 임시 배열 크기 선언
		sorted = new String[N][2];
		
		// 배열 입력
		for(int i = 0; i < N; i++) {
			arr[i][0] = scan.next();
			arr[i][1] = scan.next();
		}
		scan.close();
		
//		// 삽입 정렬방법 시간초과
//		// 첫번째는 이미 정렬되었다고 가정, 두번째부터 마지막까지 정렬할 첫번째 반복문
//		for(int i = 1; i < N; i++) {
//			// 정렬을 원하는 값 tmp값으로 추출
//			String tmpAge = arr[i][0];
//			String tmpName = arr[i][1];
//			// i번째 이전부터 첫번째까지 i의 위치를 찾을 두번째 반복문
//			for(int j = i - 1; j >= 0; j--) {
//				// i와 비교해서 i보다 크면 한칸 뒤로 밈
//				if(Integer.valueOf(arr[j][0]) > Integer.valueOf(tmpAge)) {
//					arr[j + 1][0] = arr[j][0];
//					arr[j + 1][1] = arr[j][1];
//					arr[j][0] = tmpAge;
//					arr[j][1] = tmpName;
//				}
//			}
//		}
		// 합병 정렬 진행
		mergeSort(arr, 0, N - 1);
		
		// 정렬된 배열 출력
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
