
import java.util.Scanner;

public class Q02750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// �迭 ũ�� �Է�
		int N = scan.nextInt();
		// �Է¹��� �迭 ũ��� �迭 ����
		int arr[] = new int[N];
		
		// ������ �迭 �Է�
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
//		// ���� ������ �� �˾Ҵµ� �̰� ���� ��������?
//		// ������ ���� �������� ù��° �ݺ���
//		for(int i = 0; i < N - 1; i++) {
//			// i��° ��ġ���� ���ĵǹǷ�, i ���� ���ں��� ������ ���ڱ��� �ι�° �ݺ���
//			for(int j = i + 1; j < N; j++) {
//				// i��° ���ڰ� j��° ���ں��� ũ�ٸ� �� ���ڸ� ��ü
//				if(arr[i] > arr[j]) {
//					int tmp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = tmp;
//				}
//			}
//		}
		
//		// ���� ����
//		// ������ ���� �������� ù��° �ݺ���
//		for(int i = 0; i < N - 1; i++) {
//			// �ּҰ� ����
//			int min = Integer.MAX_VALUE;
//			// �ּҰ� ��ġ
//			int minLoc = 0;
//			// i��° ���ں��� ������ ���ڱ��� �� �ּҰ� Ž��
//			for(int j = i; j < N; j++) {
//				if(arr[j] < min) {
//					min = arr[j];
//					minLoc = j;
//				}
//			}
//			// Ž���Ϸ��� �ּҰ��� i��° ���ڸ� ��ü
//			int tmp = arr[i];
//			arr[i] = arr[minLoc];
//			arr[minLoc] = tmp;
//		}
		
//		// ��ǰ ����
//		// ������ ���� �������� ù��° �ݺ���
//		for(int i = 0; i < N - 1; i++) {
//			// ������ ��ġ���� ���ĵǹǷ� N - i - 1���� �ι�° �ݺ���
//			for(int j = 0; j < N - i - 1; j++) {
//				// j��° ���ڰ� j + 1��° ���ں��� ũ�ٸ� �� ���ڸ� ��ü
//				if(arr[j] > arr[j + 1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = tmp;
//				}
//			}
//		}
		
		// ���� ����
		// ù��° ���ڸ� �����ϰ� ������ ���ڱ��� ù��° �ݺ���
		for(int i = 1; i < N; i++) {
			// ��ġ�� ã�Ƽ� ���� i��° ����
			int tmp = arr[i];
			// i��° ���ڸ� i-1���� 0���� ���Ͽ� ��ġ�� ã�Ƴִ´�.
			for(int j = i - 1; j >= 0; j--) {
				// ������ ���� tmp�� ��ġŽ�� tmp���� ū ������ ���� �ϳ��� �ڷ� �о��ش�.
				if(arr[j] > tmp) {
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		// ������ �迭 ���
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
