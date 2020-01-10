package Day09;

public class Test02_inner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A("고길동");
		a.print();
		
		A.B b1 = a.new B();
		b1.print();
		
		A.B b2 = new A().new B();
		b2.print();
	}

}

class A {
	String name = "홍길동";
	
	public A() { }
	public A(String name) {
		this.name = name;
	}
	void print() {
		System.out.println(name.charAt(0) + "**");
	}
	
	class B {
		void print() {
			System.out.println(name);
		}
	}
}