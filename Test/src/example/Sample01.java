package example;

import java.util.Arrays;

public class Sample01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 9, 7, 1, 2, 3 };
		int[] num2 = num;
		int[] num3 = num.clone();

		num2[2] = 99;
		Arrays.sort(num3);

		System.out.println(Arrays.toString(num));
		System.out.println(Arrays.toString(num2));
		System.out.println(Arrays.toString(num3));

		String url = "http://byweb/admin/login.do";
		System.out.println(url.lastIndexOf('/'));
		String r = url.substring(0, 3);
		System.out.println(url);
		System.out.println(r);

		// Test04
		int[] num_ = { 1, 2, 3, 9, 8, 4, 7 };
		for (int data : num_) {
			if (data % 2 == 0)
				System.out.println(data);
		}

		char[] c = "ABCD".toCharArray();
		for (char data : c) {
			System.out.print(data + " ");
		}
		System.out.println();

		String[] s = { "hello", "java", "test" };
		for (String data : s) {

		}

		// Test05
		Employee emp1 = new Employee();
		emp1.name = "홍길동";
		emp1.dept = "기술부";
		emp1.age = 32;
		
		Employee emp2 = new Employee();
		emp2.name = "고길동";
		emp2.dept = "교육부";
		emp2.age = 29;
		
		Employee emp3 = emp1;		
		
		emp1.print();
		emp2.print();
		emp3.print();
		
		Employee[] employees = new Employee[3];
	}
}

class Employee {
	// member variable
	String name;
	String dept;
	int age;
		
	public void print() {
		System.out.printf("Name : %s, Dept : %s, Age : %d\n", this.name, this.dept, this.age);
		return;
	}
}