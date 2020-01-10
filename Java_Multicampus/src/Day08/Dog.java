package Day08;

public class Dog extends Animal {
	String kind = "강아지 종류";
	String name;
	
	public Dog() {
		super("강아지");
	}

	public Dog(String kind, String name) {
		super("강아지");
//		super.kind = "강아지";
		this.kind = kind;
		this.name = name;
	}
	
	public String getSuperKind() {
		return super.kind;
	}

	public void print() {
		System.out.printf("[%s, %s, %s]\n", super.kind, this.kind, this.name);
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("폐로 숨쉬기...");
	}
}
