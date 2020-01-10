package Day08;

public class Test07_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle_a a = new Circle_a();
		System.out.println(a.cArea(5));
		a.print();
		a.color = "yellow";
		System.out.println(a.color);
		
		Circle_i i = new Circle_i();
		System.out.println(i.cArea(5));
//		i.color = "blue";
		System.out.println(i.color);
	}

}

class Circle_a extends Shape_a {
	int r;
	
	public double area(int r) {
		return Math.PI * r * r;
	}

	@Override
	public double cArea(double r) {
		return Math.PI * r * r;
	}
}

abstract class Shape_a {
	String color;
	public abstract double cArea(double r);
	public void print() {
		
	}
}

interface Shape_i {
	final static String color = "red";
	double cArea(double r);
}

class Circle_i implements Shape_i {

	@Override
	public double cArea(double r) {
		return Math.PI * r * r;
	}
}