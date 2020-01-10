package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepthFirstSearch {
	static int N;
	static int array[][];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		
		array = new int[N][N];
		visited = new boolean[N];
		
		for(int m=0; m<M; m++) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int val = Integer.valueOf(str[2]);
			
			array[a][b] = array[b][a] = val;
		}
		
		int target = 0;
		System.out.print(target + "에서 DFS 경로는: ");
		System.out.print(target);
		DFS(target);
	}
	
	public static void DFS(int target) {
		if(visited[target])
			return;
		
		visited[target] = true;
		
		for(int a=0; a<N; a++) {
			if(array[target][a] != 0 && visited[a] == false) {
				System.out.print(" -> " + a);
				DFS(a);
			}
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