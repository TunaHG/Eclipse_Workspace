package Day06;

/**
 * 
 * @author TunaHG
 * @since 2019.12
 */
public class Account {
	private String name;
	private String number;
	private int money;
	
	public Account() {
		this("","",0);
//		System.out.println("~~~~");
//		setNumber("");
//		setName("");
//		setMoney(0);
	}
	public Account(String number,String name,int money) {
		setNumber(number);
		setName(name);
		setMoney(money);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * 
	 * @param money 입금금액
	 */
	public void input(int money){
		this.money += money;
		return;
	}
	
	/**
	 * 
	 * @param money 출금금액
	 * @return 출금액
	 */
	public int output(int money){
		if(this.money >= money) {
			this.money -= money;
			return money;
		}else {
			return 0;
		}
	}

	/**
	 * 계좌 정보 출력 
	 */
	public void print(){
		System.out.printf("[%s(%s) 잔고:%7d원]%n",number,name,money);
		return;
	}
	
	/**
	 * 계좌이체
	 * @param from  출금계좌
	 * @param to    입금계좌
	 * @param money 계좌이체금액
	 */
	public static void transfer(Account from , Account to,int money) {
		System.out.println("계좌이체");
		System.out.println(from.number+" -> "+to.number);
		to.input(from.output(money));
	}
}





