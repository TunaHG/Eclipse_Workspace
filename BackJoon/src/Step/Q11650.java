package Step;

import java.util.Scanner;

public class Q11650 {
	// ���Ŀ� ������ �� �ӽ� �迭 ����
	static int sorted[][];
	// ������ ������ ��� �Լ�
	static void mergeSort(int arr[][], int start, int end) {
		// ũ�Ⱑ 1�̶�� ����Լ� ��
		if(end <= start) return ;
		
		// ������ ������ �� ��� �� ����
		int mid = (start + end) / 2;
		// ���� ���� ����Լ� ȣ��
		mergeSort(arr, start, mid);
		// ������ ���� ����Լ� ȣ��
		mergeSort(arr, mid + 1, end);
		// �պ��� ������ �Լ� ȣ��
		merging(arr, start, mid, end);
	}
	// �պ��� ������ �Լ�
	static void merging(int arr[][], int start, int mid, int end) {
		// ���� ������ ������, ������ ������ ������, �ӽ� �迭�� ������ ����
		int i = start, j = mid + 1, k = start;
		
		// ���ʰ� ������ ���� �� �ϳ��� ���� ������ ������ ������ �ݺ���
		while(i <= mid && j <= end) {
			// x��ǥ�� ���� ���� �ӽ� �迭�� �߰�
			if(arr[i][0] < arr[j][0]) sorted[k++] = arr[i++];
			else if(arr[i][0] > arr[j][0]) sorted[k++] = arr[j++];
			// x��ǥ�� ���ٸ�
			else {
				// y��ǥ�� ���� ���� �ӽ� �迭�� �߰�
				if(arr[i][1] <= arr[j][1]) sorted[k++] = arr[i++];
				else sorted[k++] = arr[j++];
			}
		}
		// ���� ������ �����ٸ�
		if(i > mid) {
			// ������ ������ ���������� �ӽù迭�� �߰�
			while(j <= end) sorted[k++] = arr[j++];
		}
		// ������ ������ �����ٸ�
		if(j > end) {
			// ���� ������ ���������� �ӽù迭�� �߰�
			while(i <= mid) sorted[k++] = arr[i++];
		}
		// ���ĵ� �ӽù迭�� ��ġ�״�� ���� �迭�� ����
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[][] = new int[N][2];
		sorted = new int[N][2];
		
		// ��ǥ �Է�
		for(int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}
		scan.close();
		
		// �պ����� ����
		mergeSort(arr, 0, N - 1);
		
		// ���ĵ� ��ǥ ���
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
