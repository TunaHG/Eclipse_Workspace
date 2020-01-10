import java.util.Scanner;

public class MS {
	static int sorted[];
	static void mergeSort(int arr[], int start, int end) {
		if(end <= start) return ;
		
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merging(arr, start, mid, end);
	}
	static void merging(int arr[], int start, int mid, int end) {
		int i = start, j = mid + 1;
		int k = start;
		
		while(i <= mid && j <= end) {
			if(arr[i] > arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		if(i > mid) {
			while(j <= end) sorted[k++] = arr[j++];
		}
		if(j > end) {
			while(i <= mid) sorted[k++] = arr[i++];
		}
		
		for(int x = start; x <= end; x++) {
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
		
		mergeSort(arr, 0, N - 1);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
