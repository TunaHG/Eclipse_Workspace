package mybatis;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws Exception {
		// 1.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 2. SqlSessionFactory = JDBC Connection 과 유사, 연결 설정 파일을 읽는 것. (SqlSession을 만드는 공장 역할)
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		// 3. SqlSession = 연결 생성
		// 3-1. 자동으로 Commit 처리 X
//		SqlSession session = factory.openSession();
		
		// 3-2. 자동으로 Commit 처리 O
		SqlSession session = factory.openSession(true);

		System.out.println(session.getConnection().getAutoCommit());
		///////////////////////////////////////////////
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);
		
		// Test1 : 여러 개 레코드 조회
		// <select id="allemp" resultType="mybatis.EmpVO">
//		List<EmpVO> list = dao.getAllEmp();
//		for (EmpVO vo : list) {
//			System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name());
//		}

		// Test2 : 1개 레코드 조회 (사번이 100인 사람)
//		EmpVO vo = dao.getOneEmp(100);
//		System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name());
		
		// Test3 : 1개 혹은 그이상의 레코드 조회 (이름이 Steven인 사람)
//		List<EmpVO> list = dao.getNameEmp("Steven");
//		for (EmpVO vo : list) {
//			System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name());
//		}
		
		// Test4 : CDATA Section 실행
//		List<EmpVO> list = dao.getIdEmp();
//		for (EmpVO vo : list) {
//			System.out.println(vo.getEmployee_id() + ":" + vo.getFirst_name() + ":" + vo.getHire_date());
//		}
		
		// Test5 : 새로운 사원 등록 (insert)
		// 1000, 홍길동, gil@multi.com, sysdate, IT_PROG,
		EmpVO vo = new EmpVO();
		vo.setEmployee_id(1000);
		vo.setFirst_name("길동"); // null 허용
		vo.setLast_name("홍");
		vo.setEmail("gil@multi.com");
		vo.setJob_id("IT_PROG"); // SQL 대소문자 구분 X (but, 문자열값에서는 대소문자 구분함)
		// ? <- select
		// insert / delete / update => DML
//		dao.insertEmp(vo); // insert sql
//		session.commit(); // commit
		System.out.println("신규 사원을 등록했습니다.");
	}
	
}
