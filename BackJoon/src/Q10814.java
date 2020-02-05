
import java.util.Scanner;

public class Q10814 {
	// ������ ������ �ӽ� �迭
	static String sorted[][];
	// ������ ������ ��� �Լ�
	static void mergeSort(String arr[][], int start, int end) {
		// ũ�Ⱑ 1�̸� ��� �Լ��� ���
		if(end <= start) return ;
		
		// ������ ������ �� ��� �� ���
		int mid = (start + end) / 2;
		// ���� ���� ����Լ� ȣ��
		mergeSort(arr, start, mid);
		// ������ ���� ����Լ� ȣ��
		mergeSort(arr, mid + 1, end);
		// �պ� ����
		merging(arr, start, mid, end);
	}
	// �պ��� ������ �պ� �Լ�
	static void merging(String arr[][], int start, int mid, int end) {
		// ���� ������ ������, ������ ������ ������, �ӽ� �迭�� ������ ����
		int i = start, j = mid + 1, k = start;
		
		// ���ʰ� ������ ������ �ϳ��� ���� ������ �������� �ݺ���
		while(i <= mid && j <= end) {
			// i�� ���̰� ���ٸ� i�� �ӽ� �迭�� �߰��Ͽ� ����, ���� ���̰� ���ٸ� i�� ���� ������ ���̹Ƿ� i ���� ����
			if(Integer.valueOf(arr[i][0]) <= Integer.valueOf(arr[j][0])) {
				sorted[k][0] = arr[i][0];
				sorted[k++][1] = arr[i++][1];
			}
			// j�� ���̰� ���ٸ� j�� �ӽ� �迭�� �߰��Ͽ� ����
			else if(Integer.valueOf(arr[i][0]) > Integer.valueOf(arr[j][0])) {
				sorted[k][0] = arr[j][0];
				sorted[k++][1] = arr[j++][1];
			}
		}
		// ���� ������ �����ٸ�
		if(i > mid) {
			// ������ ������ ���������� �ݺ���
			while(j <= end) {
				// ������ ������ �״�� �ӽ� �迭�� �߰��Ͽ� ����
				sorted[k][0] = arr[j][0];
				sorted[k++][1] = arr[j++][1];
			}
		}
		// ������ ������ �����ٸ�
		if(j > end) {
			// ���� ������ ���������� �ݺ���
			while(i <= mid) {
				// ���� ������ �״�� �ӽ� �迭�� �߰��Ͽ� ����
				sorted[k][0] = arr[i][0];
				sorted[k++][1] = arr[i++][1];
			}
		}
		// �ӽ� �迭�� ���� �迭�� ���������μ� ���� �ϼ�
		for(int x = start; x <= end; x++) {
			arr[x][0] = sorted[x][0];
			arr[x][1] = sorted[x][1];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// �迭 ���� �Է�
		int N = scan.nextInt();
		
		// �Է¹��� �迭 ������ �̿��� �迭 ����
		String arr[][] = new String[N][2];
		// �Է¹��� �迭 ������ �̿��� �ӽ� �迭 ũ�� ����
		sorted = new String[N][2];
		
		// �迭 �Է�
		for(int i = 0; i < N; i++) {
			arr[i][0] = scan.next();
			arr[i][1] = scan.next();
		}
		scan.close();
		
//		// ���� ���Ĺ�� �ð��ʰ�
//		// ù��°�� �̹� ���ĵǾ��ٰ� ����, �ι�°���� ���������� ������ ù��° �ݺ���
//		for(int i = 1; i < N; i++) {
//			// ������ ���ϴ� �� tmp������ ����
//			String tmpAge = arr[i][0];
//			String tmpName = arr[i][1];
//			// i��° �������� ù��°���� i�� ��ġ�� ã�� �ι�° �ݺ���
//			for(int j = i - 1; j >= 0; j--) {
//				// i�� ���ؼ� i���� ũ�� ��ĭ �ڷ� ��
//				if(Integer.valueOf(arr[j][0]) > Integer.valueOf(tmpAge)) {
//					arr[j + 1][0] = arr[j][0];
//					arr[j + 1][1] = arr[j][1];
//					arr[j][0] = tmpAge;
//					arr[j][1] = tmpName;
//				}
//			}
//		}
		// �պ� ���� ����
		mergeSort(arr, 0, N - 1);
		
		// ���ĵ� �迭 ���
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
