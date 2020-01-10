package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floyd_Warshall {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		final int MV = Integer.MAX_VALUE;
		
		int array[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				array[i][j] = MV;
			}
		}
		
		for(int m=0; m<M; m++) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int val = Integer.valueOf(str[2]);
			
			array[a][b] = array[b][a] = val;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				if(i == k)
					continue;
				for(int j=0; j<N; j++) {
					if(j == i || j == k)
						continue;
					if(array[i][k] != MV && array[k][j] != MV) {
						array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(i + "에서 최단 경로들은: ");
			for(int j=0; j<N; j++) {
				System.out.print(i + "->" + j + "(" + (array[i][j] == Integer.MAX_VALUE ? 0 : array[i][j]) + ") ");
			}
			System.out.println();
		}
	}
}

/*
6 9
1 2 5
2 3 4
1 5 10
4 0 3
3 4 2
3 1 15
5 3 4
5 4 20
0 3 4
*/