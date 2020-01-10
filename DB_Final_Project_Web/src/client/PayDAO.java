package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PayDAO {

	private static PayDAO instance = new PayDAO();

	private String id="Input_your_Azure_DB_ID";
	private String pw="Input_your_Azure_DB_PW";   
	private String name_db="Input_your_Azure_DB_name";
	private String name_host="Input_your_Azure_DB_Host";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", name_host, name_db, id, pw);

	public static PayDAO getInstance() {
		return instance;
	}

	public void insert(PayDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("insert into req values(NEXT VALUE FOR seq_pay, ?, ?, ?, ?, sysdatetime())");
			ppst.setString(1, data.getPhone());
			ppst.setString(2, data.getItem());
			ppst.setInt(3, data.getPrice());
			ppst.setString(3, data.getRespond());
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

	public List<PayDTO> getList() {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		List<PayDTO> list = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from pay");
			rs = ppst.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					PayDTO data = new PayDTO();

					data.setNo(rs.getInt("no"));
					data.setPhone(rs.getString("phone"));
					data.setItem(rs.getString("item"));
					data.setPrice(rs.getInt("price"));
					data.setRespond(rs.getString("respond"));
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
	public PayDTO getPay(int no) {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		PayDTO req = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from pay where no = ?");
			ppst.setInt(1, no);
			rs = ppst.executeQuery();
			if(rs.next()) {
				req = new PayDTO();
				req.setNo(rs.getInt("no"));
				req.setPhone(rs.getString("phone"));
				req.setItem(rs.getString("item"));
				req.setPrice(rs.getInt("price"));
				req.setRespond(rs.getString("respond"));
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
	public void update(PayDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("update pay set phone = ?, item = ?, price = ?, respond = ? where no = ?");
			ppst.setString(1, data.getPhone());
			ppst.setString(2, data.getItem());
			ppst.setInt(3, data.getPrice());
			ppst.setString(4, data.getRespond());
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
			ppst = conn.prepareStatement("delete from pay where no = ?");
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
