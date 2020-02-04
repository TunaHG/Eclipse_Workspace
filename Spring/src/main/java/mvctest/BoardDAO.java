package mvctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

public class BoardDAO {
	public ArrayList<BoardVO> getList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
//			1. JDBC driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
//			3. sql정의 - 전송
			PreparedStatement ps = con.prepareStatement("select * from board");
//			4. sql 실행 결과 이용
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				// select record가 있을 때 반복
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getString("time"));
				vo.setViewcount(rs.getInt("viewcount"));
				list.add(vo);
			}
//			5. db 연결 해제
			rs.close();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
