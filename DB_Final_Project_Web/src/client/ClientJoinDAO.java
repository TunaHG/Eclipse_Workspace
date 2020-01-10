package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientJoinDAO {

	private static ClientJoinDAO instance = new ClientJoinDAO();

	private String id="Input_your_Azure_DB_ID";
	private String pw="Input_your_Azure_DB_PW";   
	private String name_db="Input_your_Azure_DB_name";
	private String name_host="Input_your_Azure_DB_Host";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", name_host, name_db, id, pw);

	public static ClientJoinDAO getInstance() {
		return instance;
	}

	public void insert(ClientJoinDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("insert into client values(next value for seq_client, ?, ?, ?, ?, ?, ?, sysdatetime())");
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
				if (ppst != null)
					ppst.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	}

	public List<ClientJoinDTO> getList() {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		List<ClientJoinDTO> list = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from client");
			rs = ppst.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					ClientJoinDTO data = new ClientJoinDTO();

					data.setNo(rs.getInt("no"));
					data.setName(rs.getString("name"));
					data.setEmail(rs.getString("email"));
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
		return list;
	}

	public ClientJoinDTO getClientJoin(int no) {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		ClientJoinDTO client = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from client where no = ?");
			ppst.setInt(1, no);
			rs = ppst.executeQuery();
			if (rs.next()) {
				client = new ClientJoinDTO();
				client.setNo(rs.getInt("no"));
				client.setName(rs.getString("name"));
				client.setEmail(rs.getString("email"));
				client.setPassword(rs.getString("password"));
				client.setPhone(rs.getString("phone"));
				client.setAge(rs.getString("age"));
				client.setSex(rs.getString("sex"));
				client.setReg_date(rs.getTimestamp("reg_date"));
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
		return client;
	}

	public void update(ClientJoinDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("update client set name = ?, email = ?, password = ?, phone = ?, age = ?, sex = ? where no = ?");
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
			ppst = conn.prepareStatement("delete from client where no = ?");
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
