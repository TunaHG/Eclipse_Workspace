import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Q16398 {
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int array[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				array[i][j] = Integer.valueOf(str[j]);
			}
		}
		int plane[] = new int[n];
		
		Queue<Planet> q = new LinkedList<Planet>();
		
		for(int i = 0; i < n; i++) {
			int cnt = 0;
			Arrays.fill(plane, 0);
			plane[i] = 1;
			q.add(new Planet(0, plane));
			while(!q.isEmpty()) {
				Planet plt = q.poll();
				
				for(int j = 0; j < n; j++) {
					if(plt.arr[j] == 0) {
						plane[j] = 1;
						q.add(new Planet(plt.cur + array[i][j], plane));
					}
				} cnt += 1;
				if(cnt == n) {
					min = Math.min(min, plt.cur);	
				}
			}
		}
		System.out.println(min);
	}
}

class Planet{
	int cur;
	int arr[];
	public Planet(int cur, int arr[]) {
		this.cur = cur;
		this.arr = arr;
	}
}