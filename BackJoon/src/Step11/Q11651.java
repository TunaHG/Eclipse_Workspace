package Step11;
import java.util.Scanner;

public class Q11651 {
	// 정렬에 사용할 배열 선언
	static int sorted[][];
	// 합병 정렬에 사용할 재귀 함수
	static void mergeSort(int arr[][], int start, int end) {
		// 배열의 크기가 1이하면 재귀함수에서 벗어남
		if(end <= start) return ;
		
		// 분할을 위한 가운데 위치 선언
		int mid = (start + end) / 2;
		// 왼쪽 분할을 재귀함수 호출
		mergeSort(arr, start, mid);
		// 오른쪽 분할을 재귀함수 호출
		mergeSort(arr, mid + 1, end);
		// 합병
		merging(arr, start, mid, end);
	}
	// 합병 정렬에 사용할 합병 함수
	static void merging(int arr[][], int start, int mid, int end) {
		// i는 왼쪽 분할의 시작점, j는 오른쪽 분할의 시작점, k는 정렬될 배열의 시작점
		int i = start, j = mid + 1, k = start;
		
		// 왼쪽 분할과 오른쪽 분할 중 하나가 끝날때까지 합병 정렬
		while(i <= mid && j <= end) {
			// y좌표를 비교, 더 작은 y좌표를 먼저 배열
			if(arr[i][1] < arr[j][1]) sorted[k++] = arr[i++];
			else if(arr[i][1] > arr[j][1]) sorted[k++] = arr[j++];
			// y좌표가 같을 경우 x좌표를 비교, 더 작은 x좌표를 먼저 배열
			else {
				if(arr[i][0] <= arr[j][0]) sorted[k++] = arr[i++];
				else sorted[k++] = arr[j++];
			}
		}
		// 왼쪽 분할을 전부 정렬했을 때 오른쪽 분할의 남은 값들을 전부 추가
		if(i > mid) {
			while(j <= end) sorted[k++] = arr[j++];
		}
		// 오른쪽 분할을 전부 정렬했을 때 왼쪽 분할의 남은 값들을 전부 추가
		if(j > end) {
			while(i <= mid) sorted[k++] = arr[i++];
		}
		
		// 정렬된 배열을 기존 배열에 대입하여 정렬
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 입력받는 위치 수
		int N = scan.nextInt();
		
		// 위치를 입력할 배열 선언
		int arr[][] = new int[N][2];
		// 정렬에 사용할 배열 크기 선언
		sorted = new int[N][2];
		
		// 배열에 위치 입력
		for(int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		
		// 합병 정렬을 이용한 배열 정렬
		mergeSort(arr, 0, N - 1);
		
		// 정렬된 배열 출력
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
