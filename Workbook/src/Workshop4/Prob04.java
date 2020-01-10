package Workshop4;

public class Prob04 {

	public static void main(String[] args) {
//		if(args.length != 2) {
//			System.out.println("다시 입력하세요");
//			return ;
//		}
//		
//		int row = Integer.parseInt(args[0]);
//		int col = Integer.parseInt(args[1]);
//		
//		if(!(row >= 1 && row <= 5 && col >= 1 && col <= 5)) {
//			System.out.println("숫자를 확인 하세요");
//			return ;
//		}
		int row = 2;
		int col = 2;
		
		int[][] arr = new int[row][col];
		
		int sum = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				arr[i][j] = (int) (Math.random() * 5) + 1;
				sum += arr[i][j];
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("sum=" + sum);
		System.out.println("avg=" + sum / (double) (row * col));
	}

}
