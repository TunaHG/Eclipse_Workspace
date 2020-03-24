package Step;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.io.IOException;

public class Q09020 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arr[] = new int[10000];
		Arrays.fill(arr, 0);
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i < 10000; i++) {
			for(int j = 2; i * j < 10000; j++) {
				arr[i * j] = 1;
			}
		}
		int T = Integer.valueOf(br.readLine());
		
		while(T-- > 0) {
			int num = Integer.valueOf(br.readLine());
			
			int first = 0, second = 0, diff = 0, diff_min = 10000;
			int min_first = 0, min_second = 0;
			for(int  i = 2; i < num; i++) {
				if(arr[i] == 0) {
					first = i;
					second = num - first;
					if(arr[second] == 0) {
						diff = second - first;
						if(diff >= 0 && diff < diff_min) {
							diff_min = diff;
							min_first = first;
							min_second = second;
						}
						if(diff == 0) break;
					}
				}
			}
			bw.write(min_first + " " + min_second + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
