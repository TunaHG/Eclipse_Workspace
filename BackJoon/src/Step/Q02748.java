package Step;

import java.util.Scanner;

public class Q02748 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// ���° �Ǻ���ġ�� ������ �Է�
		int N = scan.nextInt();
		// �Ǻ���ġ�� ���� �̸� �Է��ص� �迭 ����
		int arr[] = new int[N + 1];
		
		// �迭 �ʱⰪ �Է�
		arr[0] = 0;
		arr[1] = 1;
		
		// ã����� ������ �������� �ݺ��� ����
		for(int i = 2; i <= N; i++) {
			// �Ǻ���ġ�� �� �Է�
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		System.out.println(arr[N]);
	}
}
