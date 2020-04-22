package Step.DP1;

import java.util.Scanner;

public class Q01932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		// ù��° ��� ������ 0�� ���� �ֱ� ���ؼ� ����� 1�� ũ�� �迭 ����
		int arr[][] = new int[n + 1][n + 1];
		
		// �ι�° ����� �ﰢ���� ����� ���� 1���� n���� ù��° �ݺ���
		for(int i = 1; i <= n; i++) {
			// �ﰢ���� ũ�Ⱑ ���� 1�� �þ���� ���� 1�� �þ�Ƿ� 1���� i���� �ι�° �ݺ���
			for(int j = 1; j <= i; j++) {
				// �ﰢ�� �ش� ��ġ�� ũ�⸦ ��� ������ �ӽ� ���� �Է�
				int tmp = scan.nextInt();
				// �ӽ� ������ �� ���� �ﰢ�� ������ �յ��� ����ؼ� �� ū���� �Է�
				arr[i][j] = tmp + Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
			}
		}
		// �ִ밪�� ���ϱ� ���� ��� �ʱⰪ ����
		int result = arr[n][1];
		// ������ ���� ��� ���� ���ϸ� ���� ū ���� ����� ����
		for(int i = 2; i <= n; i++) {
			result = Math.max(result, arr[n][i]);
		}
		
		System.out.print(result);
	}

}
