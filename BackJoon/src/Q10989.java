
import java.io.*;

public class Q10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// ���� ���� �Է¹ޱ�
		int N = Integer.valueOf(br.readLine());
		// ī������ �迭 ����
		int arr[] = new int[10001];
		
		// ���� �Է¹����� �ش� ���� ��ġ�� ������ �迭�� ���� 1�� ����
		while(N-- > 0) {
			arr[Integer.valueOf(br.readLine())]++;
		}
		
		// �迭 ��ü�� Ž���� ù��° �ݺ���
		for(int i = 0; i <= 10000; i++) {
			// �ش� �迭�� ����ŭ ��ġ�� ����� �ι�° �ݺ���
			for(int j = 0; j < arr[i]; j++) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
