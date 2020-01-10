package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import DTO.DeptDTO;
import util.jdbcUtil;

public class Test03 {

	public static void main(String[] args) {
//		Iterator<DeptDTO> it = deptList().iterator();
//		
//		while(it.hasNext()) {
//			DeptDTO data = it.next();
//			System.out.printf("Deptno: %d, Dname: %-12s, Loc: %s\n", data.getDeptno(), data.getDname(), data.getLoc());
//		}
		
		for(DeptDTO data : deptList()) {
			System.out.printf("Deptno: %d, Dname: %-12s, Loc: %s\n", data.getDeptno(), data.getDname(), data.getLoc());
		}
	}

	// JDBC Template
	public static List<DeptDTO> deptList() {
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
