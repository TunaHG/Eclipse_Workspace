package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int array[] = new int[N];
		
		String str[] = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}
		
		quicksort(0, N-1, array);
		
		System.out.print("정렬된 값: ");
		for(int i=0; i<N; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void quicksort(int start, int end, int array[]) {
		if(start >= end) {
			return;
		}
		
		int pivot = partition(start, end, array);
		quicksort(start, pivot-1, array);
		quicksort(pivot+1, end, array);
	}
	
	public static int partition(int start, int end, int array[]) {
		int pivot = array[end];
		int index = start-1;
		
		for(int i=start; i<end; i++) {
			if(array[i] <= pivot) {
				int temp = array[++index];
				array[index] = array[i];
				array[i] = temp;
			}
		}
		
		int temp = array[++index];
		array[index] = array[end];
		array[end] = temp;
		
		return index;
	}
}

/*
6
3 5 4 2 1 8
*/