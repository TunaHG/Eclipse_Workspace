package Step;


public class Q04673 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[100000];
		
		int num = 1;
		while(true) {
			if(num > 10000) break;
			String str = String.valueOf(num);
			int tmp = num;
			for(int i = 0; i < str.length(); i++) {
				tmp += (str.charAt(i) - '0');
			}
			arr[tmp] = 1;
			num++;
		}
		for(int i = 1; i < 10000; i++) {
			if(arr[i] != 1) {
				System.out.println(i);
			}
		}
	}

}
