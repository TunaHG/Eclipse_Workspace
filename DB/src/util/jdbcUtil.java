package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbcUtil {
	public static Connection getConnection() throws Exception {
		String user = "SCOTT";
		String pwd = "TIGER";
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
		Connection conn = null;
		
//		try {
//			Class.forName(driver);
//			
//			conn = DriverManager.getConnection(url, user, pwd);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pwd);
		
		return conn;
	}
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		try{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
