
import java.util.Scanner;

public class Q01904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		// �迭 ����
		int arr[] = new int[N + 1];
		
		// �ʱⰪ �Է�
		arr[0] = 1;
		arr[1] = 1;
		
		// �ʱⰪ�� Ȱ���� ������ �� �Է�
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			// int���� ����� ���� ����� �� ���� + ����
			// ����� �� ����ϸ� �̹� int���� ��� ���Ķ� �̻��� ���� ����
			// �׶��׶� �����־����
			arr[i] %= 15746;
		}
		
		System.out.println(arr[N]);
	}

}
