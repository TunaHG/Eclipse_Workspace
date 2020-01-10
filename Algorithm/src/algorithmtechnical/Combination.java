package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Combination {
	static int array[];
	static int tarray[];
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int R = Integer.valueOf(str[1]);
		
		array = new int[N];
		tarray = new int[R];
		
		str = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}
		
		makeC(array.length, R);
		
		System.out.println("총 갯수: " + count);
	}
	
	public static void makeC(int n, int r) {
		if(r <= 0) {
			System.out.println(Arrays.toString(tarray));
			count++;
			return;
		} else if(n < r) {
			return;
		} else {
			tarray[r-1] = array[n-1];
			makeC(n-1, r-1);
			makeC(n-1, r);
		}
	}
}

/*
6 4
3 5 4 2 1 8
*/