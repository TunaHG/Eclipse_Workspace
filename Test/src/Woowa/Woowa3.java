package Woowa;

public class Woowa3 {
	static int sorted[];
	static void mergeSort(int arr[], int start, int end) {
		if(end <= start) return ;
		
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merging(arr, start, mid, end);
	}
	static void merging(int arr[], int start, int mid, int end) {
		int i = start, j = mid + 1;
		int k = start;
		
		while(i <= mid && j <= end) {
			if(arr[i] > arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		if(i > mid) {
			while(j <= end) sorted[k++] = arr[j++];
		}
		if(j > end) {
			while(i <= mid) sorted[k++] = arr[i++];
		}
		
		for(int x = start; x <= end; x++) {
			arr[x] = sorted[x];
		}
	}
	public static int solution(int[] prices, int[] discounts) {
		int answer = 0;
		
		sorted = new int[prices.length];
		mergeSort(prices, 0, prices.length - 1);
		
		sorted = new int[discounts.length];
		mergeSort(discounts, 0, discounts.length - 1);
		
		if(prices.length > discounts.length) {
			for(int i = 0; i < discounts.length; i++) {
				answer += prices[i] * (100 - discounts[i]) / 100;
			}
			for(int i = discounts.length; i < prices.length; i++) {
				answer += prices[i];
			}
		} else {
			for(int i = 0; i < prices.length; i++) {
				answer += prices[i] * (100 - discounts[i]) / 100;
			}
		}
		
		return answer;
	}
	public static void main(String args[]) {
		int prices[] = {13000, 88000, 10000};
		int discounts[] = {30, 20};
		
		System.out.print(solution(prices, discounts));
	}
}
