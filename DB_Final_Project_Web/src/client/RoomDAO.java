package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

	private static RoomDAO instance = new RoomDAO();

	private String id="Input_your_Azure_DB_ID";
	private String pw="Input_your_Azure_DB_PW";   
	private String name_db="Input_your_Azure_DB_name";
	private String name_host="Input_your_Azure_DB_Host";
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", name_host, name_db, id, pw);

	public static RoomDAO getInstance() {
		return instance;
	}

	public void insert(RoomDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("insert into room values(NEXT VALUE FOR seq_room, ?, ?, ?, ?, ?, ?)");
			ppst.setString(1, data.getRoomno());
			ppst.setString(2, data.getType());
			ppst.setString(3, data.getUsee());
			ppst.setString(4, data.getTow());
			ppst.setString(5, data.getBed());
			ppst.setString(6, data.getAmenity());
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

	public List<RoomDTO> getList() {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		List<RoomDTO> list = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from room");
			rs = ppst.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					RoomDTO data = new RoomDTO();
					
					data.setNo(rs.getInt("no"));
					data.setRoomno(rs.getString("roomno"));
					data.setType(rs.getString("type"));
					data.setUsee(rs.getString("usee"));
					data.setTow(rs.getString("tow"));
					data.setBed(rs.getString("bed"));
					data.setAmenity(rs.getString("amenity"));
					
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
	public RoomDTO getRoom(int no) {
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		RoomDTO room = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("select * from room where no = ?");
			ppst.setInt(1, no);
			rs = ppst.executeQuery();
			if(rs.next()) {
				room = new RoomDTO();
				room.setRoomno(rs.getString("roomno"));
				room.setType(rs.getString("type"));
				room.setUsee(rs.getString("usee"));
				room.setTow(rs.getString("tow"));
				room.setBed(rs.getString("bed"));
				room.setAmenity(rs.getString("amenity"));
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
		return room;
	}
	public void update(RoomDTO data) {
		Connection conn = null;
		PreparedStatement ppst = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url);
			ppst = conn.prepareStatement("update room set roomno = ?, type = ?, usee = ?, tow = ?, bed = ?, amenity = ? where no = ?");
			ppst.setString(1, data.getRoomno());
			ppst.setString(2, data.getType());
			ppst.setString(3, data.getUsee());
			ppst.setString(4, data.getTow());
			ppst.setString(5, data.getBed());
			ppst.setString(6, data.getAmenity());
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
			ppst = conn.prepareStatement("delete from room where no = ?");
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
