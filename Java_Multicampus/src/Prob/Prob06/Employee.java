package Prob.Prob06;

public class Employee extends Person {
	private String dept;

	public Employee() {
		super();
	}

	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public void print() {
//		System.out.printf("이름 : %s,  나이 : %2d,  부     서 : %s\n", super.getName(), super.getAge(), this.dept);
		super.print();
		System.out.printf("부     서 : %s\n", this.dept);
	}
}
