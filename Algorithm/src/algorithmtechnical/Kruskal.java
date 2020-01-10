package algorithmtechnical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kruskal {
	static Node_kruskal nodes[];
	static int parent[], rank[];
	static int N;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);
		
		nodes = new Node_kruskal[M];
		
		for(int m=0; m<M; m++) {
			str = br.readLine().split(" ");
			nodes[m] = new Node_kruskal(Integer.valueOf(str[0]), Integer.valueOf(str[1]), Integer.valueOf(str[2]));
		}
		
		parent = new int[N];
		rank = new int[N];
		visited = new boolean[M];
		
		for(int i=0; i<N; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<M-1; i++) {
			int min = i;
			for(int j=i+1; j<M; j++) {
				if(nodes[min].val > nodes[j].val) {
					min = j;
				}
			}
			
			Node_kruskal temp = nodes[i];
			nodes[i] = nodes[min];
			nodes[min] = temp;
		}
		
		int count = 0;
		int sum = 0;
		for(int m=0; m<M; m++) {
			Node_kruskal node = nodes[m];
			int a = node.i;
			int b = node.j;
			
			if(union(a, b)) {
				count++;
				sum = sum + node.val;
				visited[m] = true;
			}
			
			if(count == N-1)
				break;
		}
		
		System.out.println("최단 경로 길이: " + sum);
		System.out.print("경로는: ");
		
		for(int i=0; i<M; i++) {
			if(visited[i]) {
				Node_kruskal node = nodes[i];
				System.out.print(node.i +"->" + node.j + "(" + node.val + ") ");
			}
		}
	}
	
	public static boolean union(int a, int b) {
		int pa = a;
		int pb = b;
		
		while(parent[pa] != pa) {
			pa = parent[pa];
		}
		
		while(parent[pb] != pb) {
			pb = parent[pb];
		}
		
		if(pa != pb) {
			if(rank[pa] > rank[pb]) {
				parent[pb] = pa;
			} else {
				if(rank[pa] == rank[pb]) {
					rank[pb]++;
				}
				parent[pa] = pb;
			}
			return true;
		}
		
		return false;
	}
}

class Node_kruskal {
	int i, j, val;

	public Node_kruskal(int i, int j, int val) {
		this.i = i;
		this.j = j;
		this.val = val;
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