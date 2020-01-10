package Workshop5.Prob02;

public class Prob02 {

	public static void main(String[] args) {
//		double sal = Integer.parseInt(args[0]);
		double sal = 100.;
		
		Company cp = new Company(sal);
		
		System.out.println("연 기본급 합: " + cp.getIncome() + " 세후: " + cp.getAfterTaxIncome());
		System.out.println("연 보너스 합: " + cp.getBonus() + " 세후: " + cp.getAfterTaxBonus());
		System.out.println("연 지급액 합: " + (cp.getAfterTaxBonus() + cp.getAfterTaxIncome()));
	}

}
