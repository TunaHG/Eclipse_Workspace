package Step.Sort;

import java.io.*;

public class Q01181 {
	// �� ���Ҹ� �ٲ��ִ� �Լ�
	static void swap(String arr[], int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// �Է¹��� ���ڿ� ���� �Է�
		int N = Integer.valueOf(br.readLine());
		
		// �Է¹��� ���ڿ��� �Է��� �迭 ����
		String arr[] = new String[N];
		
		// ���ڿ� �Է�
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		// ����
		// ù��°���� ������ ù��° �ݺ���
		for(int i = 0; i < N; i++) {
			// i������ ����� i�� ���� �ι�° �ݺ���
			for(int j = i + 1; j < N; j++) {
				// ���̸� ���Ͽ� ª�� ���̰� ������ ������ ��ü
				if(arr[i].length() > arr[j].length()) swap(arr, i, j);
				// ���̰� ���� ���
				else if(arr[i].length() == arr[j].length()) {
					// ���ڿ��� ���ٸ� �״�� ���ΰ� ���� �ݺ��� ����
					if(arr[i].equals(arr[j])) continue;
					// ���ڿ����� ù��° ���ں��� ������ ���ϱ� ���� ����° �ݺ���
					for(int k = 0; k < arr[i].length(); k++) {
						// i�� ���ڰ� ���������� �� �����ٸ� ��ü
						if(arr[i].charAt(k) > arr[j].charAt(k)) {
							swap(arr, i, j);
							break;
						}
						// i�� ���ڰ� ���������� �� ������ �״�� ���ΰ� �ݺ����� ���
						else if(arr[i].charAt(k) < arr[j].charAt(k)) {
							break;
						}
					}
				}
			}
		}
		
		// ������ ���ڿ��� ���ؾ� �ϹǷ� ù��°�� �׳� ���
		bw.write(arr[0] + "\n");
		// ������ ���ڿ��� ���ϸ� ����� �ݺ���
		for(int i = 1; i < N; i++) {
			// ������ ���ڿ��� ���ٸ� ������� �ʰ� ���� �ݺ��� ����
			if(arr[i].equals(arr[i - 1])) continue;
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
