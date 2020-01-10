package Step11;
import java.util.Scanner;

public class Q2108 {
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
		
		// 산술평균을 위한 총합계산
		int sum = 0;
		// 수 입력받는 반복문
		for(int i = 0; i < N; i++) {
			// 수 입력받음
			arr[i] = scan.nextInt();
			// 입력받은 수를 총합에 추가
			sum += arr[i];
			// 최빈값을 위한 배열
			// 입력받는 수가 절대값 4000을 넘지않으므로 4000을 더함
			count[arr[i] + 4000]++;
		}
		
		// 합병 정렬을 이용한 배열 정렬
		mergeSort(arr, 0, N - 1);
		
//		// 배열이 정렬되었는지 체크
//		for(int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}
		
		// 1. 산술평균
		// 소수점 첫째자리에서 반올림해야 하므로 sum을 float로 형변환 해준 다음 Math.round함수 사용
		int mean = Math.round((float)sum / N);
		System.out.println(mean);
		
		// 2. 중앙값
		// 배열의 가운데 위치
		int mid = N / 2;
		// 오름차순으로 정렬된 배열이므로 가운데 위치값이 중앙값
		int median = arr[mid];
		System.out.println(median);
		
		// 3. 최빈값
		// 최대값의 위치를 알기 위한 변수
		int max = 0, maxLoc = 0;
		// 최대값이 여러개인지를 알기위한 변수
		boolean SW = false;
		// 최대값 탐색 반복문
		for(int i = 0; i <= 8000; i++) {
		    // 최대값과 같은 값이 나온다면 최빈값이 여러개라는 뜻이므로 SW를 true로 변경
			if(count[i] == max) SW = true;
		    // 최대값보다 큰 값이 나온다면 
			if(count[i] > max) {
		        // 최대값 갱신
				max = count[i];
		        // 최대값 위치 갱신(위치가 최빈값)
				maxLoc = i;
				// 최대값이 갱신되었다는 것은 해당 위치 이전까지 중 중복되는 최대값이 없다는 의미
		        // 그러므로 SW를 false로 변경
				SW = false;
			}
		}
		// 최빈값이 여러개라면
		if(SW) {
			// 가장 작은 최빈값의 Count배열 값을 0으로 초기화
			// 이렇게 하면 가장 작은 최빈값이 최빈값이 아니게 됨
			count[maxLoc] = 0;
			// 이후 다시 최빈값 찾는 프로세스 진행
			// 해당 프로세스에서 결과로 나온 가장 작은 최빈값이 결국 두번째로 작은 최빈값임
			max = 0;
			maxLoc = 0;
			for(int i = 0; i <= 8000; i++) {
				if(count[i] > max) {
					max = count[i];
					maxLoc = i;
				}
			}			
		}
		// 처음에 배열에 넣기위해 +4000을 해주었으므로 위치에 -4000을 연산하고 출력
		System.out.println(maxLoc - 4000);
		
		// 4. 범위
		// 오름차순으로 정렬된 배열이므로 마지막 숫자가 최대값, 첫번째 숫자가 최소값임
		int range = arr[N-1] - arr[0];
		System.out.println(range);
	}

}
