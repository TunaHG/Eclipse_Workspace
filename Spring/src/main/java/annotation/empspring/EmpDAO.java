package annotation.empspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// <bean id="empDAO" class="xxx.EmpDAO"
@Repository
public class EmpDAO {
	// <property name="vo" ref="vo"
	@Autowired
	EmpVO vo;
	
	// new EmpDAO(); 
	EmpDAO(){
		System.out.println("EmpDAO 생성자 호출");
	}
	
	public void insertEmp() {
		// EmpVO 객체 생성 (김사원, 10000, 교육부)
		System.out.println(vo.getName() + " 사원은 " + vo.getSalary() + " 급여를 받으며 " + vo.getDeptname() + " 부서에 근무합니다.");
	}
}
