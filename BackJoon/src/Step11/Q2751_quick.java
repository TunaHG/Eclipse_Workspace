package Step11;
import java.util.Scanner;

public class Q2751_quick {
	// 값의 위치를 바꾸는 메소드
	static void swap(int arr[], int a, int b) {
		// 값을 잠시 저장할 임시 변수
		int tmp = arr[a];
		// 값의 위치를 변경
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	static void quickSort(int arr[], int left, int right) {
		// 크기가 0또는 1일 경우 재귀 종료
		if(left >= right) return ;
		
		// 피벗을 설정하기 위한 가운데 위치 탐색
		int mid = (left + right) / 2;
		// 피벗을 왼쪽 끝으로 몰아놓기 위한 위치 변경
		swap(arr, left, mid);
		// 피벗 선택
		int pivot = arr[left];

		// 양쪽 끝 위치를 인덱스 변수로 입력
		int i = left, j = right;
		// 두 인덱스가 인접할 때까지 반복문 진행
		while(i < j) {
			// 위치를 교체할 값들의 위치 탐색
			// 오른쪽 값이 피봇보다 클 경우 인덱스 -1
			while(arr[j] > pivot) j--;
			// 왼쪽 값이 피봇보다 작거나 같을경우 인덱스 +1
			while(arr[i] <= pivot && i < j) i++;
			
			// 피봇보다 작은값과 큰값의 위치를 변경
			swap(arr, i, j);
		}
		// 맨 온쪽에 위치한 피벗 값이 가운데에 오도록 정렬된 리스트에서 가운데값과 맨 왼쪽값을 변경
		arr[left] = arr[i];
		arr[i] = pivot;
		
		// 피벗보다 작은 값들이 모인 부분의 리스트를 재귀적으로 퀵 정렬
		quickSort(arr, left, i - 1);
		// 피벗보다 큰 값들이 모인 부분의 리스트를 재귀적으로 퀵 정렬
		quickSort(arr, i + 1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// 배열 크기 입력
		int N = scan.nextInt();
		// 배열 선언
		int arr[] = new int[N];
		
		// 정렬할 배열 입력받기
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		quickSort(arr, 0, N - 1);
		
		// 정렬된 배열 출력
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
