
import java.util.Scanner;

public class Q02108 {
	static int sorted[];
	static void mergeSort(int arr[], int left, int right) {
		if(right <= left) return ;
		
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merging(arr, left, mid, right);
	}
	static void merging(int arr[], int left, int mid, int right) {
		int i = left, j = mid + 1, k = left;
		
		while(i <= mid && j <= right) {
			if(arr[i] < arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		if(i > mid) {
			while(j <= right) sorted[k++] = arr[j++];
		}
		if(j > right) {
			while(i <= mid) sorted[k++] = arr[i++];
		}
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
		int count[] = new int[8001];
		
		// �������� ���� ���հ��
		int sum = 0;
		// �� �Է¹޴� �ݺ���
		for(int i = 0; i < N; i++) {
			// �� �Է¹���
			arr[i] = scan.nextInt();
			// �Է¹��� ���� ���տ� �߰�
			sum += arr[i];
			// �ֺ��� ���� �迭
			// �Է¹޴� ���� ���밪 4000�� ���������Ƿ� 4000�� ����
			count[arr[i] + 4000]++;
		}
		
		// �պ� ������ �̿��� �迭 ����
		mergeSort(arr, 0, N - 1);
		
//		// �迭�� ���ĵǾ����� üũ
//		for(int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}
		
		// 1. ������
		// �Ҽ��� ù°�ڸ����� �ݿø��ؾ� �ϹǷ� sum�� float�� ����ȯ ���� ���� Math.round�Լ� ���
		int mean = Math.round((float)sum / N);
		System.out.println(mean);
		
		// 2. �߾Ӱ�
		// �迭�� ��� ��ġ
		int mid = N / 2;
		// ������������ ���ĵ� �迭�̹Ƿ� ��� ��ġ���� �߾Ӱ�
		int median = arr[mid];
		System.out.println(median);
		
		// 3. �ֺ�
		// �ִ밪�� ��ġ�� �˱� ���� ����
		int max = 0, maxLoc = 0;
		// �ִ밪�� ������������ �˱����� ����
		boolean SW = false;
		// �ִ밪 Ž�� �ݺ���
		for(int i = 0; i <= 8000; i++) {
		    // �ִ밪�� ���� ���� ���´ٸ� �ֺ��� ��������� ���̹Ƿ� SW�� true�� ����
			if(count[i] == max) SW = true;
		    // �ִ밪���� ū ���� ���´ٸ� 
			if(count[i] > max) {
		        // �ִ밪 ����
				max = count[i];
		        // �ִ밪 ��ġ ����(��ġ�� �ֺ�)
				maxLoc = i;
				// �ִ밪�� ���ŵǾ��ٴ� ���� �ش� ��ġ �������� �� �ߺ��Ǵ� �ִ밪�� ���ٴ� �ǹ�
		        // �׷��Ƿ� SW�� false�� ����
				SW = false;
			}
		}
		// �ֺ��� ���������
		if(SW) {
			// ���� ���� �ֺ��� Count�迭 ���� 0���� �ʱ�ȭ
			// �̷��� �ϸ� ���� ���� �ֺ��� �ֺ��� �ƴϰ� ��
			count[maxLoc] = 0;
			// ���� �ٽ� �ֺ� ã�� ���μ��� ����
			// �ش� ���μ������� ����� ���� ���� ���� �ֺ��� �ᱹ �ι�°�� ���� �ֺ���
			max = 0;
			maxLoc = 0;
			for(int i = 0; i <= 8000; i++) {
				if(count[i] > max) {
					max = count[i];
					maxLoc = i;
				}
			}			
		}
		// ó���� �迭�� �ֱ����� +4000�� ���־����Ƿ� ��ġ�� -4000�� �����ϰ� ���
		System.out.println(maxLoc - 4000);
		
		// 4. ����
		// ������������ ���ĵ� �迭�̹Ƿ� ������ ���ڰ� �ִ밪, ù��° ���ڰ� �ּҰ���
		int range = arr[N-1] - arr[0];
		System.out.println(range);
	}

}
