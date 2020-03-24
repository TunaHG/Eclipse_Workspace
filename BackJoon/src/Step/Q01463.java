package Step;

import java.util.Scanner;

public class Q01463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		// Ƚ���� ������ ���� �迭 ����
		int dp[] = new int[N + 1];
		
		// 1�� ������ �ʿ䰡 ������ Ƚ���� 0
		dp[1] = 0;
		// N�� 2�̻��̶�� 2�� 2�� ������ 1�̹Ƿ� 1
		if(N >= 2) dp[2] = 1;
		// N�� 3�̻��̶�� 3�� 3���� ������ 1�̹Ƿ� 1
		if(N >= 3) dp[3] = 1;
		
		// ���� ���ϴ� ���� N���� �ݺ���
		for(int i = 4; i <= N; i++) {
			// �⺻������ ������ ���ڿ��� 1�� �ø��� �ּҼ�
			dp[i] = dp[i - 1] + 1;
			// 2�� �������� ��� ���� �⺻ �ּҼ��� 2�� �������� ���� Ƚ�� +1 �� �ּҰ� ��
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			// 3���� �������� ��� ���� �⺻ �ּҼ��� 3���� �������� ���� Ƚ�� +1 �� �ּҰ� �� 
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		// ���ϴ� ������ �ּ�Ƚ�� ���
		System.out.print(dp[N]);
	}

}
// ��ó : https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787315353&proxyReferer=https%3A%2F%2Fwww.google.com%2F