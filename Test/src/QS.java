import java.util.Scanner;

public class QS {
	static void quickSort(int arr[], int start, int end) {
		if(end <= start) return ;
		
		int mid = (start + end) / 2;
		int pivot = arr[mid];
		
		swap(arr, start, mid);
		
		int i = start + 1, j = end;
		while(i < j) {
			while(arr[i] <= pivot && i < j) i++;
			while(arr[j] > pivot) j--;
			
			swap(arr, i, j);
		}
		swap(arr, start, i);
		
		quickSort(arr, start, i - 1);
		quickSort(arr, i + 1, end);
	}
	static void swap(int arr[], int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		quickSort(arr, 0, N - 1);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
