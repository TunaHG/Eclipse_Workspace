package STunitas;

import java.util.Scanner;

public class Q5 {
	static int N;
	static int array[][];
	static int cost[];
	static boolean visited[];
	static int result;
	
	public static void Desert(int loc, int price) {
		if(loc == N) {
			result = Math.min(result, price);
			return;
		}
		if(visited[loc]) {
			return;
		}
		
		visited[loc] = true;
		
		for(int i = 2; i <= N; i++) {
			if(array[loc][i] != 0 && visited[i] == false) {
				if(i != N && price + cost[i] > result) continue;
				if(i != N) Desert(i, price + cost[i]);
				else Desert(i, price);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수 
		int T = sc.nextInt();
		while(T-- > 0) {
			N = sc.nextInt();
			
			array = new int[N + 1][N + 1];
			cost = new int[N + 1];
			visited = new boolean[N + 1];
			for(int i = 1; i <= N; i++) {
				cost[i] = sc.nextInt();
			}
			int road = sc.nextInt();
			for(int i = 0; i < road; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				array[a][b] = array[b][a] = 1;
			}
			result = N * 100;
			
			Desert(1, cost[1]);
			if(result == N * 100) result = -1;
			System.out.println(result);
		}
		sc.close();
	}

}
/*
2
4
1 10 2 15
4
1 2
1 3
4 2
4 3
5
5 5 5 5 5
4
1 2
2 3
3 4
4 1 

3
-1
*/