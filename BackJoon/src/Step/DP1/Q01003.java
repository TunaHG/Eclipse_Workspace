package Step.DP1;

import java.util.Scanner;

public class Q01003 {
//	// �ð��ʰ�
//	// 0�� 1�� ī��Ʈ �� ���� ����
//	static int cntZero, cntOne;
//	// �Ǻ���ġ�� �� ����Լ� 
//	static int fibo(int n) {
//		// 0�� ������
//		if(n == 0) {
//			// 0�� ī��Ʈ 1����
//			cntZero++;
//			// �� 0 return
//			return 0;
//		}
//		// 1�� ������
//		if(n == 1) {
//			// 1�� ī��Ʈ 1����
//			cntOne++;
//			// �� 1 return
//			return 1;
//		}
//		// 0�� 1 �̿��� ���� ��� �Ǻ���ġ�� �� ����Լ� ȣ��
//		return fibo(n - 1) + fibo(n - 2);
//	}
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		// �׽�Ʈ ���̽� ���� �Է�
//		int T = scan.nextInt();
//		
//		// �׽�Ʈ ���̽� ������ŭ �ݺ�
//		while(T-- > 0) {
//			// �׽�ũ ���̽� �Է�
//			int N = scan.nextInt();
//			// �������� 0�� ī��Ʈ�� 1�� ī��Ʈ �ʱ�ȭ
//			cntZero = 0;
//			cntOne = 0;
//			// �Ǻ���ġ�� �� �Լ� ȣ��
//			int result = fibo(N);
//			
//			// �Լ� ȣ�� ���Ŀ� ī��Ʈ �� 0�� 1�� ī��Ʈ ���
//			System.out.println(cntZero + " " + cntOne);
//		}
//	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// �׽�Ʈ ���̽� ���� �Է�
		int T = scan.nextInt();

		// 0�� ī��Ʈ�� 1�� ī��Ʈ �迭����
		// �Ǻ���ġ�� ���� 40��°���� �����ϱ� ������ ũ�⸦ 41�� ����
		int cntZero[] = new int[41];
		int cntOne[] = new int[41];
		
		// 0�� ī��Ʈ �ʱⰪ ����
		cntZero[0] = 1;
		cntZero[1] = 0;
		// 1�� ī��Ʈ �ʱⰪ ����
		cntOne[0] = 0;
		cntOne[1] = 1;
		
		// �Ǻ���ġ�� ���� 40��°������� ������ �־������Ƿ� 40��°���� �ݺ��� ����
		for(int i = 2; i <= 40; i++) {
			// 0�� ī��Ʈ �Ǻ���ġ�� ��ó�� ����
			cntZero[i] = cntZero[i - 1] + cntZero[i - 2];
			// 1�� ī��Ʈ �Ǻ���ġ�� ��ó�� ����
			cntOne[i] = cntOne[i - 1] + cntOne[i - 2];
		}
		
		// �׽�Ʈ ���̽� ������ŭ �ݺ��� ����
		while(T-- > 0) {
			// �׽�Ʈ ���̽� �Է�
			int N = scan.nextInt();
			
			// �׽�Ʈ ���̽��� �ش��ϴ� ��ġ�� 0�� 1�� ī��Ʈ ���
			System.out.println(cntZero[N] + " " + cntOne[N]);
		}
	}
}
