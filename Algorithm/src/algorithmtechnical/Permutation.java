package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permutation {
	static int array[];
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		array = new int[N];
		
		String str[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			array[i] = Integer.valueOf(str[i]);
		}
		
		makeP(0);
		
		System.out.println("총 갯수: " + count);
	}
	
	public static void makeP(int n) {
		if(n >= array.length) {
			System.out.println(Arrays.toString(array));
			count++;
			return;
		}
		
		for(int a=n; a<array.length; a++) {
			int temp = array[a];
			array[a] = array[n];
			array[n] = temp;
			
			makeP(n+1);
			
			temp = array[a];
			array[a] = array[n];
			array[n] = temp;
		}
	}
}

/*
6
3 5 4 2 1 8
1 2 3 4 5 8
*/