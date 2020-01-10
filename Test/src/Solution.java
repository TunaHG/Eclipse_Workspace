import java.util.Scanner;

public class Solution {
	static int sorted[];

	static void mergeSort(int arr[], int start, int end) {
		if (end <= start)
			return;

		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merging(arr, start, mid, end);
	}

	static void merging(int arr[], int start, int mid, int end) {
		int i = start, j = mid + 1;
		int k = start;

		while (i <= mid && j <= end) {
			if (arr[i] > arr[j])
				sorted[k++] = arr[j++];
			else
				sorted[k++] = arr[i++];
		}
		if (i > mid) {
			while (j <= end)
				sorted[k++] = arr[j++];
		}
		if (j > end) {
			while (i <= mid)
				sorted[k++] = arr[i++];
		}

		for (int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}

	public static int factorial(int num) {
		if (num == 0 | num == 1)
			return 1;
		return num * factorial(num - 1);
	}

	static boolean visited[];
	static int arr[];
	static int length;
	static int perArr[];
	static int idx = 0;
	public static void permutation(String str, int len) {
		if(len == length) {
			perArr[idx++] = Integer.valueOf(str);
			return ;
		}
		
		for(int i = 0; i < length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				permutation(str + String.valueOf(arr[i]), len + 1);
				visited[i] = false;
			}			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String strArr[] = str.split(" ");
		length = strArr.length;
		visited = new boolean[length];
		arr = new int[length];
		for(int i = 0; i < length; i++) {
			arr[i] = Integer.valueOf(strArr[i]);
		}

		int perLength = factorial(length);
		perArr = new int[perLength];
		sorted = new int[perLength];
		
		permutation("", 0);
		
		mergeSort(perArr, 0, perLength - 1);
		
		int result = sc.nextInt();
		System.out.print(perArr[result - 1]);
	}
}