package Workshop4;

public class Prob05 {

	public static void main(String[] args) {
		Account act = new Account("441-0290-1203", 500000, 7.3);
		
		System.out.println("계좌정보: " + act.getAccount() + " 현재 잔액: " + act.getBalance());
		act.deposit(20000);
		System.out.println("계좌정보: " + act.getAccount() + " 현재 잔액: " + act.getBalance());
		System.out.println("이자: " + act.calculateInterest());
	}

}
