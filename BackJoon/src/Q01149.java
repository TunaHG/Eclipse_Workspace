
import java.util.Scanner;

public class Q01149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int arr[][] = new int[T][3];
		
		for(int i = 0; i < 3; i++) {
			arr[0][i] = scan.nextInt();
		}
		
		int red, green, blue;
		for(int i = 1; i < T; i++) {
			red = scan.nextInt();
			green = scan.nextInt();
			blue = scan.nextInt();
			
			arr[i][0] = red + Math.min(arr[i - 1][1], arr[i - 1][2]);
			arr[i][1] = green + Math.min(arr[i - 1][0], arr[i - 1][2]);
			arr[i][2] = blue + Math.min(arr[i - 1][0], arr[i - 1][1]);
		}
		
		System.out.print(Math.min(arr[T - 1][0], Math.min(arr[T - 1][1], arr[T - 1][2])));
//		// Ʋ�Ƚ��ϴ�.
//		for(int i = 0; i < T; i++) {
//			for(int j = 0; j < 3; j++) {
//				arr[i][j] = scan.nextInt();
//			}
//		}
//		
//		int sum = 0;
//		int preMinLoc = 0;
//		int result = Integer.MAX_VALUE;
//		int min, minLoc = 0;
//		for(int i = 0; i < 3; i++) {
//			// ���� �ʱ�ȭ
//			sum = arr[0][i];
//			// ������ �ּҰ� ��ġ �ʱ�ȭ
//			preMinLoc = i;
//			// ù ���� ������ ��� �� Ž���ϴ� �ݺ���
//			for(int j = 1; j < T; j++) {
//				// �ּҰ� �ʱ�ȭ
//				min = Integer.MAX_VALUE;
//				for(int k = 0; k < 3; k++) {
//					// ������ �ּҰ� ��ġ�� �ּҰ�Ž������ �Ѿ����
//					if(k == preMinLoc) continue;
//					// �ּҰ����� �۴ٸ�
//					if(arr[j][k] < min) {
//						// �ּҰ� ����
//						min = arr[j][k];
//						// �ּҰ� ��ġ����
//						minLoc = k;
//					}
//				}
//				// �ּҰ��� ���տ� �߰�
//				sum += min;
//				// �ּҰ� ��ġ�� ������ �ּҰ� ��ġ ������ �Է�
//				preMinLoc = minLoc;
//			}
//			// ��� �� �ּڰ��� ���Ͽ� �ּҰ��� ��������� �Է�
//			if(sum < result) result = sum;
//		}
//		System.out.print(result);
		
//		// Ʋ�Ƚ��ϴ�.
//		// ������ ���� ���� ����
//		int sum = 0;
//		// ���� �Է¹��� ����, �ּҰ� ����, �ּҰ� ��ġ ���� ����
//		int num, min, minLoc = 0;
//		// ������ ĥ�� ���� ��ġ ���� ����
//		// 0�� ����, 1�� �ʷ�, 2�� �Ķ�
//		int preMinLoc = 4;
//		
//		// ���� ����ŭ �ݺ��� ����
//		while(T-- > 0) {
//			// �ּҰ� �ʱ�ȭ
//			min = Integer.MAX_VALUE;
//			
//			// ������ ���� ���Ͽ� �ּҰ� Ž��
//			for(int i = 0; i < 3; i++) {
//				num = scan.nextInt();
//				// ������ ĥ�� ���̶�� �ּҰ����� �񱳾��ϰ� �Ѿ
//				if(i == preMinLoc) continue;
//				// �ּҰ� Ž��
//				if(num < min) {
//					min = num;
//					minLoc = i;
//				}
//			}
//			// ���տ� �ּҰ� ����
//			sum += min;
//			// �̹��� ĥ�� ���� ������ ĥ�ѻ��� ����
//			preMinLoc = minLoc;
//		}
//		
//		System.out.print(sum);
	}

}
