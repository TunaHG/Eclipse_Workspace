package edu.multi.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class BoardDAO {
	// 저장된 모든 게시물 받아오는 메소드
	public ArrayList<BoardVO> getList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
//			1. JDBC driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
//			3. sql정의 - 전송
			PreparedStatement ps = con.prepareStatement("select * from board order by time desc");
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
	
	// 게시물 1개 저장 메소드
	public int insertBoard(BoardVO vo){
		int result = 0;
		try {
//			1. JDBC driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
//			3. sql정의 - 전송
			String insertsql = "insert into board values ((select max(seq)+1 from board), ?, ?, ?, sysdate, ?, 0)";
			PreparedStatement ps = con.prepareStatement(insertsql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContents());
			ps.setString(3, vo.getWriter());
			ps.setInt(4, vo.getPassword());
//			4. sql 실행 결과 이용
			result = ps.executeUpdate();
//			5. db 연결 해제
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시물 1개 조회 메소드
	public BoardVO boardDetail(int seq) {
		BoardVO vo = new BoardVO();
		try {
//			1. JDBC driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
//			3. sql정의 - 전송
			PreparedStatement ps = con.prepareStatement("select * from board where seq = ?");
			PreparedStatement ps0 = con.prepareStatement("update board set viewcount = viewcount + 1 where seq = ?");
			ps.setInt(1, seq);
			ps0.setInt(1, seq);
//			4. sql 실행 결과 이용
			ps0.executeUpdate();
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContents(rs.getString("contents"));
			vo.setWriter(rs.getString("writer"));
			vo.setTime(rs.getString("time"));
			vo.setViewcount(rs.getInt("viewcount"));
//			5. db 연결 해제
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 게시물 1개 수정 메소드
	public int updateBoard(BoardVO vo) {
		int result = 0;
		try {
//			1. JDBC driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
//			3. sql정의 - 전송
			String updatesql = "update board set title=?, contents=?, writer=?, password=?, time=sysdate where seq=?";
			PreparedStatement ps = con.prepareStatement(updatesql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContents());
			ps.setString(3, vo.getWriter());
			ps.setInt(4, vo.getPassword());
			ps.setInt(5, vo.getSeq());
//			4. sql 실행 결과 이용
			result = ps.executeUpdate();
//			5. db 연결 해제
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 게시물 1개 삭제 메소드
	public int deleteBoard(int seq) {
		int result = 0;
		try {
//			1. JDBC driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
//			3. sql정의 - 전송
			String deletesql = "delete from board where seq=?";
			PreparedStatement ps = con.prepareStatement(deletesql);
			ps.setInt(1, seq);
//			4. sql 실행 결과 이용
			result = ps.executeUpdate();
//			5. db 연결 해제
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
