package App;

import DAO.DeptDAO;
import DTO.DeptDTO;

public class Application {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
//		dao.insertDept("EDU2", "Chejudo");
		
//		dao.deleteDept(51);
		
		
		for(DeptDTO data : dao.deptList()) {
			System.out.printf("Deptno: %d, Dname: %-12s, Loc: %s\n", data.getDeptno(), data.getDname(), data.getLoc());
		}
		
		System.out.println("END");
	}

}
