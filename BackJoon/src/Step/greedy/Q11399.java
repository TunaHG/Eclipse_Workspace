package Step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 앞 사람의 소요시간이 작으면 작을 수록 뒤의 사람들의 대기시간이 줄어든다.
// 총 대기시간의 최소값을 구하는 문제이므로 각 사람의 소요시간이 오름차순이 되도록 정렬한 후 대기시간을 구함
public class Q11399 {
	// 정렬에 이용할 배열 (정렬된 값들을 임시 저장)
	static int[] sorted;
	// 합병정렬중 합병을 진행할 method
	public static void merging(int[] arr, int start, int mid, int end) {
		// 두 개의 배열의 시작위치를 지정한 변수
		int i = start, j = mid + 1;
		// 임시로 정렬된 배열의 index를 의미하는 변수
		int k = i;
		
		// 두 개의 배열 중 하나를 전부 정렬할 때까지 진행하는 반복문
		while(true) {
			// 두 개의 배열 index중 하나라도 해당 배열의 마지막index를 넘으면 종료
			if(i > mid || j > end)
				break;
			// 두 배열중 작은 값을 먼저 임시배열에 저장 (오름차순으로 정렬하기 위해)
			if(arr[i] < arr[j])
				sorted[k++] = arr[i++];
			else
				sorted[k++] = arr[j++];
		}
		// 하나의 배열이라도 전부 정렬되었다면 나머지 배열을 전부 정렬
		if(i > mid) {
			// 나머지 배열이 전부 정렬될 때까지 반복문
			while(true) {
				// 해당 배열의 끝까지 진행
				if(j > end)
					break;
				// 해당 배열은 이미 정렬된 배열이므로 그대로 저장
				sorted[k++] = arr[j++];
			}
		} else {
			while(true) {
				if(i > mid)
					break;
				sorted[k++] = arr[i++];
			}
		}
		// 처음부터 끝까지 정렬된 임시배열을 기존배열에 저장
		for(int index = start; index <= end; index++) {
			arr[index] = sorted[index];
		}
	}
	// 합병정렬을 진행할 재귀 method
	public static void mergeSort(int[] arr, int start, int end) {
		// 마지막index에서 시작index를 뺀값이 0이하라면 최소단위임을 의미
		if(end - start <= 0)
			return ;
		
		// 중간index 산출
		int mid = (start + end) / 2;
		
		// 왼쪽 배열을 이용한 재귀호출
		mergeSort(arr, start, mid);
		// 오른쪽 배열을 이용한 재귀호출
		mergeSort(arr, mid + 1, end);
		// 나뉘어진 두 배열을 합치는 method진행
		merging(arr, start, mid, end);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람의 수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 각 사람마다 인출에 소요하는 시간 입력
		int[] spendTime = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			spendTime[i] = Integer.parseInt(input[i]);
		}
		// 정렬에 사용할 임시배열 크기 선언
		sorted = new int[N];
		
		// 합병정렬을 이용한 오름차순 정렬
		mergeSort(spendTime, 0, N - 1);
		
		// 각 사람마다의 대기시간을 입력할 배열 선언
		int[] waitTime = new int[N];
		// 첫 사람은 자신의 소요시간이 곧 대기시간
		waitTime[0] = spendTime[0];
		// 총 대기시간을 입력받을 변수 선언 및 초기화
		int sum = waitTime[0];
		// 첫 사람은 이미 정해졌으니, 두 번째 사람부터 진행할 반복문
		for(int i = 1; i < N; i++) {
			// 이후 인원의 대기시간은 이전 인원의 대기시간 + 자신의 소요시간
			waitTime[i] = waitTime[i - 1] + spendTime[i];
			// 총 대기시간은 각 사람의 대기시간의 합
			sum += waitTime[i];
		}
		// 총 대기시간 결과 출력
		System.out.println(sum);
	}

}
