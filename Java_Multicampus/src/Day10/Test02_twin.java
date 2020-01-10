package Day10;

public class Test02_twin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Employee2<String, String> emp1 = new Employee2("홍길동", "2019001");
//		Employee2<String, String> emp1 = new Employee2<String, String>("홍길동", "2019001");
//		System.out.println(emp1);
		
		Employee2<String, Integer> emp2 = new Employee2<String, Integer>("홍길동", 2019001);
		System.out.println(emp2.number/1000);
		
		Employee2<String, Double> emp3 = new Employee2<String, Double>("홍길동", 2019001.0);
		System.out.println(emp3);
		
		Employee2 emp4 = new Employee2("고길동", 201701);
		System.out.println(emp4);
		System.out.println(emp4.number.getClass());
	}

}

class Employee2<T, P extends Number> {
	T name;
	P number;
	
	public Employee2(T name, P number) {
		super();
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", number=" + number + "]";
	}
}