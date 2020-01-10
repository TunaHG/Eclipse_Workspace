package Prob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAO {
	// JDBC Template
	public userVO loginUser(String id, String pw) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		userVO uv = new userVO();

		String sql = "select * from users where id = ? and pw = ?";

		try {
			conn = jdbcUtil.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, pw);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				uv.setId(rs.getString("id"));
				uv.setPw(rs.getString("pw"));
				uv.setName(rs.getString("name"));
				uv.setRole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(conn, ps, rs);
		}
		
		return uv;
	}
}
