package Prob.Prob06;

public class Prob06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] persons = { 
				new Student("홍길동", 20, 200201),
				new Teacher("이순신", 30, "JAVA"),
				new Employee("유관순", 40, "교무과") 
				};

//		for (int i = 0; i < p1.length; i++) {
//			if(p1[i] instanceof Student)
//				((Student)p1[i]).print();
//			if(p1[i] instanceof Teacher)
//				((Teacher)p1[i]).print();
//			if(p1[i] instanceof Employee)
//				((Employee)p1[i]).print();
//		}

		for (Person data : persons) {
			data.print();
		}
	}

}
