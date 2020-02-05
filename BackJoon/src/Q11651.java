
import java.util.Scanner;

public class Q11651 {
	// ���Ŀ� ����� �迭 ����
	static int sorted[][];
	// �պ� ���Ŀ� ����� ��� �Լ�
	static void mergeSort(int arr[][], int start, int end) {
		// �迭�� ũ�Ⱑ 1���ϸ� ����Լ����� ���
		if(end <= start) return ;
		
		// ������ ���� ��� ��ġ ����
		int mid = (start + end) / 2;
		// ���� ������ ����Լ� ȣ��
		mergeSort(arr, start, mid);
		// ������ ������ ����Լ� ȣ��
		mergeSort(arr, mid + 1, end);
		// �պ�
		merging(arr, start, mid, end);
	}
	// �պ� ���Ŀ� ����� �պ� �Լ�
	static void merging(int arr[][], int start, int mid, int end) {
		// i�� ���� ������ ������, j�� ������ ������ ������, k�� ���ĵ� �迭�� ������
		int i = start, j = mid + 1, k = start;
		
		// ���� ���Ұ� ������ ���� �� �ϳ��� ���������� �պ� ����
		while(i <= mid && j <= end) {
			// y��ǥ�� ��, �� ���� y��ǥ�� ���� �迭
			if(arr[i][1] < arr[j][1]) sorted[k++] = arr[i++];
			else if(arr[i][1] > arr[j][1]) sorted[k++] = arr[j++];
			// y��ǥ�� ���� ��� x��ǥ�� ��, �� ���� x��ǥ�� ���� �迭
			else {
				if(arr[i][0] <= arr[j][0]) sorted[k++] = arr[i++];
				else sorted[k++] = arr[j++];
			}
		}
		// ���� ������ ���� �������� �� ������ ������ ���� ������ ���� �߰�
		if(i > mid) {
			while(j <= end) sorted[k++] = arr[j++];
		}
		// ������ ������ ���� �������� �� ���� ������ ���� ������ ���� �߰�
		if(j > end) {
			while(i <= mid) sorted[k++] = arr[i++];
		}
		
		// ���ĵ� �迭�� ���� �迭�� �����Ͽ� ����
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// �Է¹޴� ��ġ ��
		int N = scan.nextInt();
		
		// ��ġ�� �Է��� �迭 ����
		int arr[][] = new int[N][2];
		// ���Ŀ� ����� �迭 ũ�� ����
		sorted = new int[N][2];
		
		// �迭�� ��ġ �Է�
		for(int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		
		// �պ� ������ �̿��� �迭 ����
		mergeSort(arr, 0, N - 1);
		
		// ���ĵ� �迭 ���
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
