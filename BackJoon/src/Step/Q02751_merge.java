package Step;

import java.util.Scanner;

public class Q02751_merge {
	static int sorted[];
	static void mergeSort(int arr[], int left, int right) {
		// �迭�� ũ�Ⱑ 1�̸� Stop
		if(right - left < 1) return ;
		
		// �迭�� �������� ���� ����
		int mid = (left + right) / 2;
		// ���� �迭 mergeSort ����Լ� ȣ��
		mergeSort(arr, left, mid);
		// ������ �迭 mergeSort ����Լ� ȣ��
		mergeSort(arr, mid + 1, right);
		// ���ʹ迭�� �����ʹ迭�� �����ϸ� ��ġ�� 
		merging(arr, left, mid, right);
	}
	static void merging(int arr[], int left, int mid, int right) {
		// ���� �迭 ������ġ�� ������ �迭 ������ġ ����
		int i = left, j = mid + 1;
		// sorted�迭 ������ġ ����
		int k = i;
		
		// ���� �迭�� ���� ������ ������ �迭�� �����ϸ� �ϳ��� ��ħ
		while(true) {
			// ���� �迭�� ���� �����ϸ� �ݺ����� �����.
			if(i > mid || j > right) break;
			// ���� �迭�� ������ �迭�� ���� ���ϸ� �� �������� ��ġ�� �迭�� ���� �ִ´�.
			if(arr[i] > arr[j]) sorted[k++] = arr[j++];
			else sorted[k++] = arr[i++];
		}
		// ���� �迭�� ���� ����������
		if(i > mid) {
			// ������ �迭�� ���� ������ ������ ��ġ�� �迭�� �ִ´�.
			while(true) {
				// ������ �迭�� ���� ���������� �ݺ����� �����.
				if(j > right) break;
				sorted[k++] = arr[j++];
			}
		// ������ �迭�� ���� ����������
		} else {
			// ���� �迭�� ���� ������ ������ ��ġ�� �迭�� �ִ´�.
			while(true) {
				// ���� �迭�� ���� ���������� �ݺ����� �����.
				if(i > left) break;
				sorted[k++] = arr[i++];
			}
		}
		// ���ļ� ������ �迭�� ���� �迭�� ����
		for(int x = left; x <= right; x++) {
			arr[x] = sorted[x];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int arr[] = new int[N];
		sorted = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		mergeSort(arr, 0, N - 1);
		
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
