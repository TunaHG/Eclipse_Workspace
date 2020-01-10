package Prob.Prob08;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape [] shape = new Shape[2];
		
		shape[0] = new Circle("원",10);
		shape[1] = new Rectangle("직사각형",10,20);
		
		for (int i = 0; i < shape.length; i++) {
			shape[i].calculationArea();
			shape[i].print();
		}
		
//		Q1.
//		100
//		Child Method
//		200
//		Child Method

//		Q2.
//		Child()
//		Parent()
//		Object()
//		Parent(200)
//		Object()
//		Parent.int = 200
//		Chile(1000)
//		Parent()
//		Object()
//		Parent(200)
//		Object()
//		Parent.int = 200
//		Child.int = 1000
//		실행결과 : 200
	}

}
