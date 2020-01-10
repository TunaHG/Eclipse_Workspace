package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test01 {

	public static void main(String[] args) {
		System.out.println("JDBC TEST START");

		String user = "SCOTT";
		String pwd = "TIGER";
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

		String sql = "select * from dept";

		Connection con = null;
		PreparedStatement ps = null; // Statement보다 성능이 좋다.
		ResultSet rs = null; 
		
		try {
			// 1. Driver Loading
			// 객체생성해서 메모리에 띄운다. new를 사용하면 Compile타이밍에 결정되고 여러개의 객체가 올라갈 수 있기 때문에 Class.forName()을 사용.
			Class.forName(driver);
			
			// 2. Connection 요청
			con = DriverManager.getConnection(url, user, pwd);
			
			// 3. Statement 생성
			ps = con.prepareStatement(sql);
			
			// 4. SQL 수행
			rs = ps.executeQuery();
			
			// 5. 결과 처리
			// select 구문의 결과값은 Result set, DML의 결과값은 int값으로 나온다.
			while(rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\t");
				System.out.println();
			}
			
			System.out.println(con);
			
		} catch (Exception e) {
			// 6. SQLException
			System.out.println(e);
		} finally {
			// 7. 자원 정리
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

		System.out.println("JDBC TEST END");
	}

}
