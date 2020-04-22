package Step.Recursive;

import java.util.Scanner;

public class Q11729 {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	static void hanoi(int num, int from, int by, int to) {
		++cnt;
		if(num == 1) {
			sb.append(from + " " + to + "\n");
		} else {
			hanoi(num - 1, from, to, by);
			sb.append(from + " " + to + "\n");
			hanoi(num - 1, by, from, to);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		hanoi(num, 1, 2, 3);
		sb.insert(0, cnt + "\n");
		System.out.println(sb);
	}

}
