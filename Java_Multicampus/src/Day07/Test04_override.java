package Day07;

public class Test04_override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal f = new Fish("쿠피");
		((Fish)f).print();
		
		System.out.println(f.kind);
		System.out.println(((Fish)f).kind);
		
		f.breath();
		
		
	}

}
