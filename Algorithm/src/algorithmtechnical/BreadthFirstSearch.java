package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		
		int array[][] = new int[N][N];
		boolean visited[] = new boolean[N];
		
		for(int m=0; m<M; m++) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int val = Integer.valueOf(str[2]);
			
			array[a][b] = array[b][a] = val;
		}
		
		int target = 0;
		System.out.print(target + "에서 BFS 경로는: ");
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(target);
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			if(visited[n])
				continue;
			
			System.out.print(n + " -> ");
			visited[n] = true;
			
			for(int a=0; a<N; a++) {
				if(visited[a] == false && array[n][a] != 0) {
					queue.add(a);
				}
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