package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		
		int array[] = new int[N];
		
		String str[] = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}

		for(int i=0; i<N-1; i++) {
			int min = i;
			for(int j=i+1; j<N; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		
		System.out.print("정렬된 값: ");
		for(int i=0; i<N; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

/*
6
3 5 4 2 1 8
*/