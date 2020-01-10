package Workshop3;

public class Prob02 {

	public static void main(String[] args) {
		int[][] arr2 = {{5, 5, 5, 5, 5},
				{10, 10, 10, 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30, 30}};
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				sum += arr2[i][j];
				cnt++;
			}
		}
		System.out.println(sum);
		System.out.println(sum / (double) cnt);
	}

}
