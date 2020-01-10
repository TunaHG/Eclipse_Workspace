package Step11;
import java.util.Scanner;

public class Q1427 {
	// 정렬을 도울 임시 배열 선언
	static int sorted[];
	// 분할을 진행할 재귀 함수
	static void mergeSort(int arr[], int start, int end) {
		// 크기가 1이라면 재귀함수 끝
		if(end <= start) return ;
		
		// 분할의 기준이 될 가운데 값 산출
		int mid = (start + end) / 2;
		// 왼쪽 분할 재귀함수 호출
		mergeSort(arr, start, mid);
		// 오른쪽 분할 재귀함수 호출
		mergeSort(arr, mid + 1, end);
		// 합병을 진행할 합병 함수 호출
		merging(arr, start, mid, end);
	}
	// 합병을 진행할 합병 함수
	static void merging(int arr[], int start, int mid, int end) {
		// 왼쪽 분할의 시작점, 오른쪽 분할의 시작점, 임시 배열의 시작점 선언
		int i = start, j = mid + 1, k = start;
		
		// 왼쪽이나 오른쪽 분할 중 하나를 전부 배열할 때까지 진행할 반복문
		while(i <= mid && j <= end) {
			// 왼쪽과 오른쪽 분할중 더 작은값을 하나씩 임시 배열에 추가
			if(arr[i] > arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		// 왼쪽 분할이 끝났다면
		if(i > mid) {
			// 오른쪽 분할이 끝날떄까지 임시배열에 그대로 추가
			while(j <= end) sorted[k++] = arr[j++];
		}
		// 오른쪽 분할이 끝났다면
		if(j > end) {
			// 왼쪽 분할이 끝날때까지 임시 배열에 그대로 추가
			while(i <= mid) sorted[k++] = arr[i++];
		}
		// 임시배열의 값을 기존 배열에 대입
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// 주어진 수 입력
		String str = scan.nextLine();
		
		// 수의 길이 파악
		int N = str.length();
		// 수의 길이를 이용한 배열 선언
		int arr[] = new int[N];
		sorted = new int[N];
		
		// 배열에 수의 각 자리수를 입력
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		// 합병 정렬 진행
		mergeSort(arr, 0, N - 1);
		
		// 정렬된 배열 출력
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i]);
		}
	}

}
