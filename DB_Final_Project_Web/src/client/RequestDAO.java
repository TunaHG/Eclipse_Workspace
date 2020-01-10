package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

	private static RequestDAO instance = new RequestDAO();

	private String id="Input_your_Azure_DB_ID";
	private String pw="Input_your_Azure_DB_PW";   
	private String name_db="Input_your_Azure_DB_name";
	private String name_host="Input_your_Azure_DB_Host";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", name_host, name_db, id, pw);

	public static RequestDAO getInstance() {
		return instance;
	}

	public void insert(RequestDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("insert into req values(NEXT VALUE FOR seq_req, ?, ?, ?, ?, sysdatetime())");
			ppst.setString(1, data.getRoom());
			ppst.setString(2, data.getContent());
			ppst.setString(3, data.getIng());
			ppst.setString(4, data.getRespond());
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

	public List<RequestDTO> getList() {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		List<RequestDTO> list = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from req");
			rs = ppst.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					RequestDTO data = new RequestDTO();

					data.setNo(rs.getInt("no"));
					data.setRoom(rs.getString("room"));
					data.setContent(rs.getString("content"));
					data.setRespond(rs.getString("respond"));
					data.setIng(rs.getString("ing"));
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
	public RequestDTO getRequest(int no) {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		RequestDTO req = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from req where no = ?");
			ppst.setInt(1, no);
			rs = ppst.executeQuery();
			if(rs.next()) {
				req = new RequestDTO();
				req.setNo(rs.getInt("no"));
				req.setRoom(rs.getString("room"));
				req.setContent(rs.getString("content"));
				req.setRespond(rs.getString("respond"));
				req.setIng(rs.getString("ing"));
				req.setReg_date(rs.getTimestamp("reg_date"));
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
		return req;
	}
	public void update(RequestDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("update req set room = ?, content = ?, respond = ?, ing = ? where no = ?");
			ppst.setString(1, data.getRoom());
			ppst.setString(2, data.getContent());
			ppst.setString(3, data.getRespond());
			ppst.setString(4, data.getIng());
			ppst.setInt(5, data.getNo());
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
			ppst = conn.prepareStatement("delete from req where no = ?");
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
