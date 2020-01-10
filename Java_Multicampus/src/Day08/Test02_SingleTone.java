package Day08;

public class Test02_SingleTone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTone s1 = SingleTone.getInstance();
		SingleTone s2 = SingleTone.getInstance();
		System.out.println(s1);
		System.out.println(s2);
	}

}

class SingleTone {
	private static SingleTone s;
	private SingleTone() { }
	
	public static SingleTone getInstance() {
		if(s == null) s = new SingleTone();
		return s;
	}
}
