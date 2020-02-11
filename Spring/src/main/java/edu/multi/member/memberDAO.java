package edu.multi.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session;
	
	public int checkMember(String userid) {
		int result = session.selectOne("checkid", userid);
		return result;
	}
	
	public int insertMember(MemberVO vo) {
		int result = session.insert("insertmember", vo);
		return result;
	}
	
	public MemberVO selectMember(String userid, String password) {
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		
		vo = session.selectOne("getmember", vo);
		return vo;
	}
}
