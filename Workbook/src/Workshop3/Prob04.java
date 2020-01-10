package Workshop3;

public class Prob04 {

	public static void main(String[] args) {
		int[] arr3 = new int[5];
		
		int sum = 0;
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (int)(Math.random() * 10) + 1;
			sum += arr3[i];
			for(int j = 0; j < i; j++) {
				if(arr3[j] == arr3[i]) {
					sum-=arr3[i--];
					break;
				}
			}
		}
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();
		System.out.println(sum);
		System.out.println(sum / (double) 5);
	}

}
