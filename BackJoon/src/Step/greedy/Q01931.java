package Step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01931 {
	// 합병정렬에 이용할 배열
	static int[][] sorted;
	// 합병정렬에 이용할 합병 Method
	public static void merging(int[][] arr, int start, int mid, int end) {
		// 두 개의 배열을 합병할 때, 각 배열의 시작점을 의미하는 변수 선언
		int i = start, j = mid + 1;
		// sorted배열의 index를 의미할 변수 선언
		int k = i;
		
		// 두 개의 배열중 하나의 배열을 다 정렬할 때까지 반복
		while(true) {
			// 둘 중 하나의 배열이라도 다 정렬되었다면 반복문 종료
			if(i > mid || j > end)
				break;
			// 회의가 끝나는 시간을 정렬의 기준으로 지정하여 작은값이 앞으로 오도록 정렬
			if(arr[i][1] < arr[j][1])
				sorted[k++] = arr[i++];
			// (8, 8), (5, 8)과 같은 경우 (5, 8)이 이용가능한데 무시당할 수 있음.
			// 회의실 이용종료시간이 같은경우 이용시작시간을 이용하여 정렬해야함
			// 끝나는 시간이 동일하다면
			else if(arr[i][1] == arr[j][1]) {
				// 시작 시간을 이용하여 시작시간이 더 빠른 값이 앞으로 오도록 정렬
				if(arr[i][0] < arr[j][0])
					sorted[k++] = arr[i++];
				else
					sorted[k++] = arr[j++];
			}
			else
				sorted[k++] = arr[j++];
		}
		// 하나의 배열이 전부 정렬되었다면 나머지 배열을 정렬된 배열에 추가
		if(i > mid) {
			while(true) {
				if(j > end)
					break;
				sorted[k++] = arr[j++];
			}
		} else {
			while(true) {
				if(i > mid)
					break;
				sorted[k++] = arr[i++];
			}
		}
		// 정렬된 배열을 기존 배열에 저장하여 적용
		for (int index = start; index <= end; index++) {
			arr[index] = sorted[index];
		}
	}
	// 합병정렬을 진행하는 재귀 Method
	public static void mergeSort(int[][] arr, int start, int end) {
		// 끝부분에서 시작부분을 뺐을때, 0보다 작거나 같다는것은 최소단위가 되었다는 것을 의미
		if(end - start <= 0) 
			return ;
		
		// 배열을 두개로 나누기 위한 중간값 선언
		int mid = (start + end) / 2;
		
		// 중간값을 이용하여 왼쪽 배열 재귀호출
		mergeSort(arr, start, mid);
		// 중간값을 이용하여 오른쪽 배열 재귀호출
		mergeSort(arr, mid + 1, end);
		// 시작값, 중간값, 끝값을 이용하여 합병 진행
		merging(arr, start, mid, end);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 회의실 예약 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 회의실 시작시간과 끝시간을 저장할 배열 선언
		int[][] arr = new int[N][2];
		// 합병정렬에 이용할 배열 크기 선언
		sorted = new int[N][2];

		// 회의실 이용시간 저장
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(tmp[0]);
			arr[i][1] = Integer.parseInt(tmp[1]);
		}
		
		// 회의실 이용시간 오름차순 합병정렬 진행
		mergeSort(arr, 0, N - 1);
		
		// 이전에 사용한 회의실 시간을 의미하는 index
		int index = 0;
		// 회의실을 사용한 횟수를 의미하는 cnt
		int cnt = 1;
		// 오름차순으로 정렬했으므로 첫번째값(배열의 index:0)은 무조건 회의실을 사용함.
		// 두번째값(배열의 index:1)부터 알고리즘 진행
		for(int i = 1; i < N; i++) {
			// 두번째 값이 이전에 사용한 회의실 종료시간보다 크거나 같으면 회의실 이용이 가능함.
			if(arr[i][0] >= arr[index][1]) {
				// 회의실 이용했으므로 index값 갱신
				index = i;
				// 횟수 추가
				cnt++;
			}
		}
		// 횟수 출력
		System.out.println(cnt);
	}

}

/*
Input
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
Output
4

Input
9
8 8
5 8
3 4
2 5 
2 7
8 8
1 10
3 3
10 10
Output
6
*/