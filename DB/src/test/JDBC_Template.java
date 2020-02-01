package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.jdbcUtil;

public class JDBC_Template {
	// JDBC Template
	public void temp() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;

		String sql = "";

		try {
			conn = jdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
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
}
