package Step.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14888 {
	// 최대값 결과를 저장할 변수
	static int max = Integer.MIN_VALUE;
	// 최소값 결과를 저장할 변수
	static int min = Integer.MAX_VALUE;
	// 수열의 Size를 저장할 변수
	static int N;
	// 수열을 저장할 배열 변수
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열의 Size 입력
		N = Integer.parseInt(br.readLine());
		// 수열의 Size를 통해 배열 선언
		arr = new int[N];
		// 수열 입력
		String[] numStr = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(numStr[i]);
		}
		
		// 연산자 개수 입력
		// 연산자 개수 또한 static으로 선언하여 관리해도 된다.
		int[] operator = new int[4];
		String[] operStr = br.readLine().split(" ");
		for(int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(operStr[i]);
		}
		
		// 각 연산의 결과를 저장할 변수, 초기값은 수열의 첫값
		int result = arr[0];
		// 연산의 결과와 연산자의 개수 배열, 현재 연산의 위치를 이용한 DFS 호출
		DFS(result, operator, 1);
		
		// 최대값과 최소값 결과 출력
		System.out.println(max);
		System.out.println(min);
	}
	public static void DFS(int result, int[] operator, int seq) {
		// 현재 연산의 위치가 배열의 Size와 크거나 같다면
		if(seq >= N) {
			// 최대값과 최소값을 비교
			max = Math.max(result, max);
			min = Math.min(result, min);
			// 재귀함수 종료
			return ;
		}
		
		// +연산자의 개수가 남아있다면 +연산 진행
		if(operator[0] > 0) {
			// +연산을 진행할 것이므로 개수에서 -1을 진행한 후 인자로 넘겨줌
			operator[0]--;
			DFS(result + arr[seq], operator, seq + 1);
			// +연산을 진행하고 나온 결과물은 +이외의 다른 연산을 진행해야하므로 +는 연산하지 않은것, 다시 +1
			operator[0]++;
		}
		// -연산자의 개수가 남아있다면 -연산 진행
		if(operator[1] > 0) {
			// -연산을 진행할 것이므로 개수에서 -1을 진행한 후 인자로 넘겨줌
			operator[1]--;
			DFS(result - arr[seq], operator, seq + 1);
			// -연산을 진행하고 나온 결과물은 -이외의 다른 연산을 진행해야하므로 -는 연산하지 않은것, 다시 +1
			operator[1]++;
		}
		// *연산자의 개수가 남아있다면 -연산 진행
		if(operator[2] > 0) {
			// *연산을 진행할 것이므로 개수에서 -1을 진행한 후 인자로 넘겨줌
			operator[2]--;
			DFS(result * arr[seq], operator, seq + 1);
			// *연산을 진행하고 나온 결과물은 *이외의 다른 연산을 진행해야하므로 *는 연산하지 않은것, 다시 +1
			operator[2]++;
		}
		// /연산자의 개수가 남아있다면 -연산 진행
		if(operator[3] > 0) {
			// /연산을 진행할 것이므로 개수에서 -1을 진행한 후 인자로 넘겨줌
			operator[3]--;
			// 문제에서 주어진 조건으로, 음수를 나눠야 하는 상황이면 C++14의 기준을 따름
			// 양수로 바꾼뒤 몫을 취하고 그 몫을 음수로 변경한 것과 같음
			if(result < 0) {
				result = 0 - (Math.abs(result) / arr[seq]);
			} else {
				result = result / arr[seq];
			}
			DFS(result, operator, seq + 1);
			// /연산을 진행하고 나온 결과물은 /이외의 다른 연산을 진행해야하므로 /는 연산하지 않은것, 다시 +1
			operator[3]++;
		}
	}
}
