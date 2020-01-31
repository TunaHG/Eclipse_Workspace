package annotation.empspring;

import org.springframework.stereotype.Component;

// <bean id="vo" class="xxx.EmpVO"
@Component("vo")
public class EmpVO {
	private String name;
	private double salary;
	private String deptname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}
