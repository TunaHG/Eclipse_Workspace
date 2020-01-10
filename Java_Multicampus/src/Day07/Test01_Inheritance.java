package Day07;

public class Test01_Inheritance {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.print();
		System.out.println(d.kind);
		System.out.println(d.getSuperKind());
	}
}
