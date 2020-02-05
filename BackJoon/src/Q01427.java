
import java.util.Scanner;

public class Q01427 {
	// ������ ���� �ӽ� �迭 ����
	static int sorted[];
	// ������ ������ ��� �Լ�
	static void mergeSort(int arr[], int start, int end) {
		// ũ�Ⱑ 1�̶�� ����Լ� ��
		if(end <= start) return ;
		
		// ������ ������ �� ��� �� ����
		int mid = (start + end) / 2;
		// ���� ���� ����Լ� ȣ��
		mergeSort(arr, start, mid);
		// ������ ���� ����Լ� ȣ��
		mergeSort(arr, mid + 1, end);
		// �պ��� ������ �պ� �Լ� ȣ��
		merging(arr, start, mid, end);
	}
	// �պ��� ������ �պ� �Լ�
	static void merging(int arr[], int start, int mid, int end) {
		// ���� ������ ������, ������ ������ ������, �ӽ� �迭�� ������ ����
		int i = start, j = mid + 1, k = start;
		
		// �����̳� ������ ���� �� �ϳ��� ���� �迭�� ������ ������ �ݺ���
		while(i <= mid && j <= end) {
			// ���ʰ� ������ ������ �� �������� �ϳ��� �ӽ� �迭�� �߰�
			if(arr[i] > arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		// ���� ������ �����ٸ�
		if(i > mid) {
			// ������ ������ ���������� �ӽù迭�� �״�� �߰�
			while(j <= end) sorted[k++] = arr[j++];
		}
		// ������ ������ �����ٸ�
		if(j > end) {
			// ���� ������ ���������� �ӽ� �迭�� �״�� �߰�
			while(i <= mid) sorted[k++] = arr[i++];
		}
		// �ӽù迭�� ���� ���� �迭�� ����
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// �־��� �� �Է�
		String str = scan.nextLine();
		
		// ���� ���� �ľ�
		int N = str.length();
		// ���� ���̸� �̿��� �迭 ����
		int arr[] = new int[N];
		sorted = new int[N];
		
		// �迭�� ���� �� �ڸ����� �Է�
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		// �պ� ���� ����
		mergeSort(arr, 0, N - 1);
		
		// ���ĵ� �迭 ���
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i]);
		}
	}

}
