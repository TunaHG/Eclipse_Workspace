package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prim {
	static int array[][];
	static boolean visited[];
	static int min[], parent[];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		
		array = new int[N][N];
		visited = new boolean[N];
		min = new int[N];
		parent = new int[N];
		
		while(M-- > 0) {
			str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int val = Integer.valueOf(str[2]);
			
			array[a][b] = array[b][a] = val;
		}
		
		for(int i=0; i<N; i++) {
			min[i] = Integer.MAX_VALUE;
		}
		
		int target = 1;
		min[target] = 0;
		parent[target] = target;
		
		makePrim(target);
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum = sum + min[i];
		}
		
		System.out.println("최단 경로 길이: " + sum);
		System.out.print("경로는: ");
		
		for(int i=0; i<N; i++) {
			if(i == target)
				continue;
			System.out.print(parent[i] +"->" + i + "(" + min[i] + ") ");
		}
	}
	
	public static void makePrim(int target) {
		int minIndex = target;
		
		while(minIndex != -1) {
			visited[minIndex] = true;
			for(int i=0; i<N; i++) {
				if(array[minIndex][i] != 0 && visited[i] == false) {
					if(min[i] > array[minIndex][i]) {
						min[i] = array[minIndex][i];
						parent[i] = minIndex;
					}
				}
			}
			
			minIndex = -1;
			
			for(int i=0; i<N; i++) {
				if(visited[i] == false) {
					if(minIndex == -1) {
						minIndex = i;
					} else if(min[minIndex] > min[i]) {
						minIndex = i;
					}
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
