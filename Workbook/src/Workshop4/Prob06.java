package Workshop4;

public class Prob06 {
	public static void main(String[] args) {
		Account[] acts = new Account[5];
		
		for (int i = 0; i < acts.length; i++) {
			acts[i] = new Account("221-0101-211" + (i + 1), 100000, 4.5);
		}
		
		for (int i = 0; i < acts.length; i++) {
			acts[i].accountInfo();
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < acts.length; i++) {
			acts[i].setInterestRate(3.7);
			acts[i].accountInfo();
			System.out.println(" 이자: " + acts[i].calculateInterest() + "원");
		}
	}
}
