package Workshop4;

public class Account {
	private String account;
	private int balance;
	private double interestRate;
	
	public Account() {
		super();
	}
	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		return balance * interestRate / 100;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) {
		if(balance < money) System.out.println("잔액이 부족합니다.");
		else balance -= money;
	}
	public void accountInfo() {
		System.out.print("계좌번호: " + account + " 잔액: " + balance + " 이자율: " + interestRate + "%");
	}
}
