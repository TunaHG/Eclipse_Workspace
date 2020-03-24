package Step;

import java.io.*;

public class Q09461 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// �׽�ũ ���̽� ���� �Է�
		int T = Integer.valueOf(br.readLine());
		
		// ���� �Է��� �迭 ����
		// int���� ����� ���� ������
		long arr[] = new long[100];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		
		// arr �� ä���ֱ�
		for(int i = 3; i < 100; i++) {
			arr[i] = arr[i - 2] + arr[i - 3];
		}
		
		// �׽�ũ ���̽� ���� T��ŭ �ݺ�
		while(T-- > 0) {
			// �׽�Ʈ ���̽� �Է�
			int N = Integer.valueOf(br.readLine());
			
			// ���
			bw.write(arr[N - 1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
