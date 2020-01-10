package Day05;

public class Test04_Inhacedfor {
	public static void main(String[] args) {
		int[] num = {1,2,3,9,8,7,4};
		for(int data :num) {
			if(data % 2 != 0) System.out.print(data);
		}
		System.out.println();
		
		char[] c = "ABCD".toCharArray();
		for(char data :c) {
			System.out.print(data+"  ");
		}
		System.out.println();
		
		String[] s = {"hello","java","test"}; 
		for(String data :s) {
			if(data.charAt(0) == 'j') System.out.println(data);
		}

	}
}
