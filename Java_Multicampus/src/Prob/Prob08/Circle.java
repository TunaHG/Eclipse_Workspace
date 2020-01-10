package Prob.Prob08;

public class Circle extends Shape {
	private double radius;
	
	public Circle() {
		super();
	}

	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void calculationArea() {
		// TODO Auto-generated method stub
		setArea(Math.PI * radius * radius);
	}
}
