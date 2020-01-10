package Workshop3.Prob06;

public class Prob06 {

	public static void main(String[] args) {
		Student stu1 = new Student("Kim", 100, 90, 95, 89);
		Student stu2 = new Student("Lee", 60, 70, 99, 98);
		Student stu3 = new Student("Park", 68, 86, 60, 40);
		
		System.out.printf("%s 평균: %.2f, 학점: %s\n", stu1.getName(), stu1.getAvg(), stu1.getGrade());
		System.out.printf("%s 평균: %.2f, 학점: %s\n", stu2.getName(), stu2.getAvg(), stu2.getGrade());
		System.out.printf("%s 평균: %.2f, 학점: %s", stu3.getName(), stu3.getAvg(), stu3.getGrade());
	}

}
