package Workshop5.Prob02;

public class Company {
	private double salary;
	private double annualIncome;
	private double afterTaxAnnualIncome;
	private double bonus;
	private double afterTaxBonus;
	
	public Company() {
		super();
	}
	public Company(double salary) {
		super();
		this.salary = salary;
	}

	public double getIncome() {
		annualIncome = salary * 12;
		return annualIncome;
	}
	public double getAfterTaxIncome() {
		afterTaxAnnualIncome = annualIncome * 0.9;
		return afterTaxAnnualIncome;
	}
	public double getBonus() {
		bonus = salary * 0.2 * 4;
		return bonus;
	}
	public double getAfterTaxBonus() {
		afterTaxBonus = bonus * (1- 0.055);
		return afterTaxBonus;
	}
}
