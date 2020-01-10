import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q16396 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int array[] = new int[10000];
		
		for (int i = 0; i < n; i++) {
			String[] a = br.readLine().split(" ");
			for (int j = Integer.parseInt(a[0]); j < Integer.parseInt(a[1]); j++) {
				array[j] = 1;
			}
		}
		int cnt = 0;
		for (int i = 0; i < 10000; i++) {
			if(array[i] == 1) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}

}
