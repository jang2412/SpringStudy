package kr.ac.pcu.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

@Repository
public class MemberDao {
	
	//	현재 스프링에 등록된 빈 중에 타입, 이름이 비슷한 빈을 주입(설정)
	@Autowired
	private DataSource dataSource;
	
	public List<Member> getMemberList() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = dataSource.getConnection();
		
		return null;
	}

}
