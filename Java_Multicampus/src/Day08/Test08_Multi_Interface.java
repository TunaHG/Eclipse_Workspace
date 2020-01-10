package Day08;

public class Test08_Multi_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Drawable[] s = {
				new Circle(),
				new Rectangle()
		};
		for(Drawable data : s) {
			data.draw();
			((Moveable)data).move();
		}
		System.out.println("=======================");
		
		T[] t = { new Circle(), new Rectangle() };
		for(T data : t) {
			data.draw();
			data.move();
		}
	}

}

interface Drawable {
	void draw();
}
interface Moveable {
	void move();
}

interface T extends Drawable, Moveable {}

class Circle implements T {
	String name = "Circle";

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(name + " 이동(move)");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(name + " 그리기(draw)");
	}
	
}

class Rectangle implements T {
	String name = "Rectangle";

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(name + " 이동(move)");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(name + " 그리기(draw)");
	}

}