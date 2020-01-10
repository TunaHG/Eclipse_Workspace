package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.DeptDTO;
import util.jdbcUtil;

public class DeptDAO {
	// JDBC Template
	public void deleteDept(int deptno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "delete from dept where deptno = ?";

		try {
			conn = jdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, deptno);
			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.close(conn, ps, rs);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void insertDept(String dname, String loc) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "insert into dept (deptno, dname, loc) "
				+ "values ((select nvl(max(deptno), 0) + 1 from dept), ?, ?)";

		try {
			conn = jdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, dname);
			ps.setString(2, loc);

			row = ps.executeUpdate(); // DML 구문이기 때문에 row사용

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				jdbcUtil.close(conn, ps, rs);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public List<DeptDTO> deptList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		
		String sql = "select * from dept";

		try {
			conn = jdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while(rs.next()) {
				DeptDTO dto = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
		
		return list;
	}
}
