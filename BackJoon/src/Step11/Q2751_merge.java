package Step11;
import java.util.Scanner;

public class Q2751_merge {
	static int sorted[];
	static void mergeSort(int arr[], int left, int right) {
		// 배열의 크기가 1이면 Stop
		if(right - left < 1) return ;
		
		// 배열을 절반으로 나눌 기준
		int mid = (left + right) / 2;
		// 왼쪽 배열 mergeSort 재귀함수 호출
		mergeSort(arr, left, mid);
		// 오른쪽 배열 mergeSort 재귀함수 호출
		mergeSort(arr, mid + 1, right);
		// 왼쪽배열과 오른쪽배열을 정렬하며 합치기 
		merging(arr, left, mid, right);
	}
	static void merging(int arr[], int left, int mid, int right) {
		// 왼쪽 배열 시작위치와 오른쪽 배열 시작위치 선언
		int i = left, j = mid + 1;
		// sorted배열 시작위치 선언
		int k = i;
		
		// 한쪽 배열을 전부 정렬할 때까지 배열을 정렬하며 하나로 합침
		while(true) {
			// 한쪽 배열을 전부 정렬하면 반복문을 벗어난다.
			if(i > mid || j > right) break;
			// 왼쪽 배열과 오른쪽 배열의 값을 비교하며 더 작은값을 합치는 배열에 먼저 넣는다.
			if(arr[i] > arr[j]) sorted[k++] = arr[j++];
			else sorted[k++] = arr[i++];
		}
		// 왼쪽 배열을 전부 정렬했으면
		if(i > mid) {
			// 오른쪽 배열을 전부 정렬할 때까지 합치는 배열에 넣는다.
			while(true) {
				// 오른쪽 배열도 전부 정렬했으면 반복문을 벗어난다.
				if(j > right) break;
				sorted[k++] = arr[j++];
			}
		// 오른쪽 배열을 전부 정렬했으면
		} else {
			// 왼쪽 배열을 전부 정렬할 때까지 합치는 배열에 넣는다.
			while(true) {
				// 왼쪽 배열도 전부 정렬했으면 반복문을 벗어난다.
				if(i > left) break;
				sorted[k++] = arr[i++];
			}
		}
		// 합쳐서 정렬한 배열을 기존 배열에 적용
		for(int x = left; x <= right; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[] = new int[N];
		sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		mergeSort(arr, 0, N - 1);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
