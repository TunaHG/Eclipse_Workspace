package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
	static int N;
	static int array[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		array = new int[N];
		
		String str[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}
		
		Arrays.sort(array); // binarysearch는 소트가 된 상태로 사용할 수 있음, Arrays.sort는 이클립스에서 제공해주는 api로 double pivot을 사용하는 소트방식
		System.out.println(Arrays.toString(array));
		binarysearch(0, array.length-1, 4);
		binarysearch(0, array.length-1, 6);
	}
	
	public static void binarysearch(int start, int end, int target) {
		if(start > end) {
			System.out.println(target + "의 값은 존재하지 않습니다.");
			return;
		}
		
		int mid = (start+end) / 2;
		
		if(array[mid] == target) {
			System.out.println(target + "의 값은 " + (mid+1) +"번째에 있습니다.");
			return;
		} else if(array[mid] > target) {
			binarysearch(start, mid-1, target);
		} else {
			binarysearch(mid+1, end, target);
		}
	}
}

/*
6
3 5 4 2 1 8
*/