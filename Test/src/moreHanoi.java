import java.util.Scanner;

public class moreHanoi {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	static void Hanoi(int n, int from, int by, int to) {
		cnt++;
		if(n == 1) {
			sb.append(from + " " + to + "\n");
			return ;
		}
		
		Hanoi(n - 1, from, to, by);
		sb.append(from + " " + to + "\n");
		Hanoi(n - 1, by, from, to);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		scan.close();
		Hanoi(num, 1, 2, 3);
		sb.insert(0, cnt + "\n");
		
		System.out.println(sb);
	}

}
