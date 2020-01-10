package Workshop3.Prob06;

public class Student {
	String name;
	int kor;
	int eng;
	int math;
	int sci;
	
	public Student() {
		super();
	}
	public Student(String name, int kor, int eng, int math, int sci) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sci = sci;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	
	public double getAvg() {
		return (kor + eng + math + sci) / 4.;
	}
	public String getGrade() {
		double score = getAvg();
		String grade = "F";
		if(score <= 100 && score >= 90) grade = "A";
		else if(score >= 70) grade = "B";
		else if(score >= 50) grade = "C";
		else if(score >= 30) grade = "D";
		
		return grade;
	}
}
