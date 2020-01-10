package Workshop2;

public class Prob07 {

	public static void main(String[] args) {
		int sum = 0;
		int num = Integer.parseInt(args[0]);
		for(int i = 1; i <= 100; i++) {
			if(i % num == 0) sum += i;
		}
		System.out.println(sum);
	}

}
