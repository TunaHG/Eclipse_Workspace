package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffJoinDAO {
	
	private static StaffJoinDAO instance = new StaffJoinDAO();

	private String id="Input_your_Azure_DB_ID";
	private String pw="Input_your_Azure_DB_PW";   
	private String name_db="Input_your_Azure_DB_name";
	private String name_host="Input_your_Azure_DB_Host";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", name_host, name_db, id, pw);

	private StaffJoinDAO() {}
	public static StaffJoinDAO getInstance() {
		return instance;
	}
	
	public void insert(StaffJoinDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("insert into staff values(NEXT VALUE FOR seq_staff, ?, ?, ?, ?, ?, ?, sysdatetime())");
			ppst.setString(1, data.getName());
			ppst.setString(2, data.getEmail());
			ppst.setString(3, data.getPassword());
			ppst.setString(4, data.getPhone());
			ppst.setString(5, data.getAge());
			ppst.setString(6, data.getSex());
			ppst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}
	public List<StaffJoinDTO> getList(){
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		List<StaffJoinDTO> list = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from staff");
			rs = ppst.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<>();
				do {
					StaffJoinDTO data = new StaffJoinDTO();
					
					data.setNo(rs.getInt("no"));
					data.setName(rs.getString("name"));
					data.setEmail(rs.getString("email"));
					data.setPassword(rs.getString("password"));
					data.setPhone(rs.getString("phone"));
					data.setAge(rs.getString("age"));
					data.setSex(rs.getString("sex"));
					data.setReg_date(rs.getTimestamp("reg_date"));
					
					list.add(data);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ppst != null) ppst.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return list;
	}
	public StaffJoinDTO getStaffJoin(int no) {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		StaffJoinDTO stf = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from staff where no = ?");
			ppst.setInt(1, no);
			rs = ppst.executeQuery();
			if (rs.next()) {
				stf = new StaffJoinDTO();
				stf.setNo(rs.getInt("no"));
				stf.setName(rs.getString("name"));
				stf.setEmail(rs.getString("email"));
				stf.setPassword(rs.getString("password"));
				stf.setPhone(rs.getString("phone"));
				stf.setAge(rs.getString("age"));
				stf.setReg_date(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
		return stf;
	}

	public void update(StaffJoinDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("update staff set name = ?, email = ?, password = ?, phone = ?, age = ?, sex = ? where no = ?");
			ppst.setString(1, data.getName());
			ppst.setString(2, data.getEmail());
			ppst.setString(3, data.getPassword());
			ppst.setString(4, data.getPhone());
			ppst.setString(5, data.getAge());
			ppst.setString(6, data.getSex());
			ppst.setInt(7, data.getNo());
			ppst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}

	public void delete(int no) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("delete from staff where no = ?");
			ppst.setInt(1, no);
			ppst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}
}
