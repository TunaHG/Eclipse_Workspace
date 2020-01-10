package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String id="Input_your_Azure_DB_ID";
	private String pw="Input_your_Azure_DB_PW";   
	private String name_db="Input_your_Azure_DB_name";
	private String name_host="Input_your_Azure_DB_Host";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", name_host, name_db, id, pw);


	public ClientDAO(){
	      connectDB();
	   }
	
	private void connectDB() {
	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url);
	      } catch(Exception e) {
	    	  e.printStackTrace();
	      }
	   }
	
	public int login(String phone, String password) {
		String SQL ="SELECT password FROM client WHERE phone = ";
		try {
			pstmt = conn.prepareStatement(SQL + "'" + phone + "'");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(password)) {
					return 1;
				}
				else
					return 0;
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	public int loginNo(String phone) {
		String SQL = "select no from client where phone = ";
		try {
			pstmt = conn.prepareStatement(SQL + "'" + phone + "'");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int num = rs.getInt("no");
				return num;
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} return -1;
	}
}
