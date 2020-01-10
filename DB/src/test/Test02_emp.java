package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.jdbcUtil;

public class Test02_emp {

	public static void main(String[] args) {
		System.out.println("JDBC TEST START");

		String sql = "select * from emp where deptno = ?";

		Connection conn = null;
		PreparedStatement ps = null; // Statement보다 성능이 좋다, sql문 내의 ?를 처리할 수 있다.
		ResultSet rs = null; 
		
		try {			
			conn = jdbcUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			int num = Integer.parseInt(JOptionPane.showInputDialog("deptno을 입력하세요"));
			ps.setInt(1,  num);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getString("mgr") + "\t");
				System.out.print(rs.getString("hiredate") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getString("comm") + "\t");
				System.out.print(rs.getString("deptno") + "\t");
				System.out.println();
			}
			
			System.out.println(conn);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}

		System.out.println("JDBC TEST END");
	}

}
