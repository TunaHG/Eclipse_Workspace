package Step.Sort;

import java.util.Scanner;

public class Q02751_quick {
	// ���� ��ġ�� �ٲٴ� �޼ҵ�
	static void swap(int arr[], int a, int b) {
		// ���� ��� ������ �ӽ� ����
		int tmp = arr[a];
		// ���� ��ġ�� ����
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	static void quickSort(int arr[], int left, int right) {
		// ũ�Ⱑ 0�Ǵ� 1�� ��� ��� ����
		if(left >= right) return ;
		
		// �ǹ��� �����ϱ� ���� ��� ��ġ Ž��
		int mid = (left + right) / 2;
		// �ǹ��� ���� ������ ���Ƴ��� ���� ��ġ ����
		swap(arr, left, mid);
		// �ǹ� ����
		int pivot = arr[left];

		// ���� �� ��ġ�� �ε��� ������ �Է�
		int i = left, j = right;
		// �� �ε����� ������ ������ �ݺ��� ����
		while(i < j) {
			// ��ġ�� ��ü�� ������ ��ġ Ž��
			// ������ ���� �Ǻ����� Ŭ ��� �ε��� -1
			while(arr[j] > pivot) j--;
			// ���� ���� �Ǻ����� �۰ų� ������� �ε��� +1
			while(arr[i] <= pivot && i < j) i++;
			
			// �Ǻ����� �������� ū���� ��ġ�� ����
			swap(arr, i, j);
		}
		// �� ���ʿ� ��ġ�� �ǹ� ���� ����� ������ ���ĵ� ����Ʈ���� ������� �� ���ʰ��� ����
		arr[left] = arr[i];
		arr[i] = pivot;
		
		// �ǹ����� ���� ������ ���� �κ��� ����Ʈ�� ��������� �� ����
		quickSort(arr, left, i - 1);
		// �ǹ����� ū ������ ���� �κ��� ����Ʈ�� ��������� �� ����
		quickSort(arr, i + 1, right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		// �迭 ũ�� �Է�
		int N = scan.nextInt();
		// �迭 ����
		int arr[] = new int[N];
		
		// ������ �迭 �Է¹ޱ�
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		quickSort(arr, 0, N - 1);
		
		// ���ĵ� �迭 ���
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
