package Prob.Prob06;

public class Student extends Person {
	private int id;

	public Student() {
		super();
	}

	public Student(String name, int age, int id) {
		super(name, age);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void print() {
//		System.out.printf("이름 : %s,  나이 : %2d,  학     번 : %s\n", super.getName(), this.getAge(), this.id);
		super.print();
		System.out.printf("학     번 : %s\n", this.id);
	}
}
