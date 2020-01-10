package Workshop5.Prob05;

public class Prob05 {

	public static void main(String[] args) {
		Mobile m1 = new Ltab("Ltab", 500, "AP-01");
		Mobile m2 = new Otab("Otab", 1000, "AND-20");
		
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("--------------------------------");
		System.out.printf("%s\t%d\t%s\n", m1.getMobileName(), m1.getBatterySize(), m1.getOsType());
		System.out.printf("%s\t%d\t%s\n", m2.getMobileName(), m2.getBatterySize(), m2.getOsType());
		System.out.println();
		
		System.out.println("10분 충전");
		m1.charge(10);
		m2.charge(10);
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("--------------------------------");
		System.out.printf("%s\t%d\t%s\n", m1.getMobileName(), m1.getBatterySize(), m1.getOsType());
		System.out.printf("%s\t%d\t%s\n", m2.getMobileName(), m2.getBatterySize(), m2.getOsType());
		System.out.println();
		
		System.out.println("5분 통화");
		m1.operate(5);
		m2.operate(5);
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("--------------------------------");
		System.out.printf("%s\t%d\t%s\n", m1.getMobileName(), m1.getBatterySize(), m1.getOsType());
		System.out.printf("%s\t%d\t%s\n", m2.getMobileName(), m2.getBatterySize(), m2.getOsType());
	}

}
