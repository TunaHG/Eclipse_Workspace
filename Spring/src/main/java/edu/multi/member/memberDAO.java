package edu.multi.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class memberDAO {
	@Autowired
	SqlSession session;
	
	public int checkMember(memberVO vo) {
		int result = session.selectOne("checkid", vo);
		return result;
	}
	
	public int insertMember(memberVO vo) {
		int result = session.insert("insertmember", vo);
		return result;
	}
}
