package Prob.Prob08;

class Parent {
	int x=100;
	Parent() {
		this(200); 
		System.out.println("basic parent");
	}
	Parent(int x) {
		System.out.println("parent");
		this.x = x;
	}
	int getX() {
		return x;
	}
}
class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000); 
		System.out.println("basic child");
	}
	Child(int x) {
		System.out.println("child");
		this.x = x;
	}
}
public class Exercise7_7 {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println("x="+c.getX());
	}
}
