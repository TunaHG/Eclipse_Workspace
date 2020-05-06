package Intermediate.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<String> list;
		
		for(int testNum = 1; testNum <= 10; testNum++) {
			list = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			String[] original = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				list.add(original[i]);
			}
			
			br.readLine();
			
			int index = 0;
			String[] allcmd = br.readLine().split(" ");
			while(true) {
				if(index >= allcmd.length)
					break;
				String cmd = allcmd[index++];
				// 명령어가 I라면
				if(cmd.equals("I")) {
					int loc = Integer.parseInt(allcmd[index++]);
					int cnt = Integer.parseInt(allcmd[index++]);
					for(int i = 0; i < cnt; i++) {
						list.add(loc++, allcmd[index++]);
					}
				}
				// 명령어가 D라면
				else if(cmd.equals("D")) {
					int loc = Integer.parseInt(allcmd[index++]);
					int cnt = Integer.parseInt(allcmd[index++]);
					for(int i = 0; i < cnt; i++) {
						list.remove(loc);
					}
				} 
				// 명령어가 A라면
				else {
					int cnt = Integer.parseInt(allcmd[index++]);
					for(int i = 0; i < cnt; i++) {
						list.add(allcmd[index++]);
					}
				}
			}
			
			System.out.print("#" + testNum);
			for(int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();
		}
	}

}
