package Step11;
import java.util.Scanner;

public class Q11650 {
	// 정렬에 도움을 줄 임시 배열 선언
	static int sorted[][];
	// 분할을 진행할 재귀 함수
	static void mergeSort(int arr[][], int start, int end) {
		// 크기가 1이라면 재귀함수 끝
		if(end <= start) return ;
		
		// 분할의 기준이 될 가운데 값 산출
		int mid = (start + end) / 2;
		// 왼쪽 분할 재귀함수 호출
		mergeSort(arr, start, mid);
		// 오른쪽 분할 재귀함수 호출
		mergeSort(arr, mid + 1, end);
		// 합병을 진행할 함수 호출
		merging(arr, start, mid, end);
	}
	// 합병을 진행할 함수
	static void merging(int arr[][], int start, int mid, int end) {
		// 왼쪽 분할의 시작점, 오른쪽 분할의 시작점, 임시 배열의 시작점 선언
		int i = start, j = mid + 1, k = start;
		
		// 왼쪽과 오른쪽 분할 중 하나를 전부 정렬할 때까지 진행할 반복문
		while(i <= mid && j <= end) {
			// x좌표가 작은 값을 임시 배열에 추가
			if(arr[i][0] < arr[j][0]) sorted[k++] = arr[i++];
			else if(arr[i][0] > arr[j][0]) sorted[k++] = arr[j++];
			// x좌표가 같다면
			else {
				// y좌표가 작은 값을 임시 배열에 추가
				if(arr[i][1] <= arr[j][1]) sorted[k++] = arr[i++];
				else sorted[k++] = arr[j++];
			}
		}
		// 왼쪽 분할이 끝났다면
		if(i > mid) {
			// 오른쪽 분할이 끝날때까지 임시배열에 추가
			while(j <= end) sorted[k++] = arr[j++];
		}
		// 오른쪽 분할이 끝났다면
		if(j > end) {
			// 왼쪽 분할이 끝날때까지 임시배열에 추가
			while(i <= mid) sorted[k++] = arr[i++];
		}
		// 정렬된 임시배열을 위치그대로 기존 배열에 대입
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[][] = new int[N][2];
		sorted = new int[N][2];
		
		// 좌표 입력
		for(int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		
		// 합병정렬 진행
		mergeSort(arr, 0, N - 1);
		
		// 정렬된 좌표 출력
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
