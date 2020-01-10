package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int array[] = new int[N];
		
		String str[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}
		
		mergesort(0, N-1, array);
		
		System.out.print("정렬된 값: ");
		for(int i=0; i<N; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void mergesort(int start, int end, int array[]) {
		if(start >= end) {
			return;
		}
		
		int mid = (start+end)/2;
		mergesort(start, mid, array);
		mergesort(mid+1, end, array);
		merging(start, mid, end, array);
	}
	
	public static void merging(int start, int mid, int end, int array[]) {
		int temp[] = new int[end-start+1];
		int index = 0;
		int p = start;
		int q = mid+1;
		
		while(p<=mid && q<=end) {
			if(array[p] > array[q]) {
				temp[index++] = array[q++];
			} else {
				temp[index++] = array[p++];
			}
		}
		
		while(p<=mid) {
			temp[index++] = array[p++];
		}
		
		while(q<=end) {
			temp[index++] = array[q++];
		}
		
		for(int i=start; i<=end; i++) {
			array[i] = temp[i-start];
		}
	}
}

/*
6
3 5 4 2 1 8
*/
