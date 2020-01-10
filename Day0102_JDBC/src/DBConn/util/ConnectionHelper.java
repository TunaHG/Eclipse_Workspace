package DBConn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DB Connection이 반복적으로 코딩되는 것을 해결
// 다른 Class에서 아래 코드를 코딩하지 않도록 설계
public class ConnectionHelper {
	public static Connection getConnection(String dsn) {
		Connection conn = null;
		
		try {
			if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample08", "kingsmile", "oracle");
			} else if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kingsmile", "oracle");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	} // end getConnection()
	
	public static Connection getConnection(String dsn, String user, String pwd) {
		Connection conn = null;
		
		try {
			if(dsn.equals("mysql")) {
				Class.forName("com.mysql.jdbc.Drive");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample08", user, pwd);
			} else if(dsn.equals("oracle")) {
				Class.forName("oracle.jdbc.driver.OracleDrive");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", user, pwd);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	} // end getConnection()
//	public static void main(String[] args) {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("Load Success!!");
//			
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kingsmile", "oracle");
//			System.out.println("Connection Success!!");
//		} catch(ClassNotFoundException e) {
////			System.out.println("드라이브 로드 실패");
////			System.out.println(e.getMessage());
//			e.printStackTrace();
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
} // end Connection Helper
