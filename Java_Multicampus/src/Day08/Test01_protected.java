package Day08;

import Day07.Animal;

public class Test01_protected {
	public static void main(String[] args) {
		Animal a = new Animal();
//		System.out.println(a.kind);
	}
}

class Dog2 extends Animal {
	public void print() {
		System.out.println(super.kind);
	}
}