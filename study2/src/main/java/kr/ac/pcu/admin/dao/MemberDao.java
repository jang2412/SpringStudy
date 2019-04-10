package kr.ac.pcu.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.pcu.admin.web.Member;

@Repository
public class MemberDao implements MemberMapper {

	/* 현재 스프링에 등록된 빈중 타입, 이름이 비슷한 빈을 주입(설정)   */ 
	@Autowired  
	private DataSource dataSource;
	
	// 내부의 로깅처리를 위해 slf4j 로그 사용 
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public List<Member> selectMemberList() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		// 회원정보를 담을 List객체 생성 
		List<Member> list = new ArrayList<Member>();
		try{
			conn = dataSource.getConnection();
			// String sql = "select * from TB_MEMBER order by reg_date DESC";
			
			// 문자열이 여러 줄인 경우 "문자열" + "문자열" 보다 문자열 처리객체(Builder,Buffer) 사용 권장  
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * ");
			sb.append("  FROM tb_member ");
			sb.append(" ORDER by reg_date DESC ");
			
			log.debug(sb.toString());
			
			// 구문 객체 생성 
			pstmt = conn.prepareStatement(sb.toString());
			// 파라미터(?) 설정에 따른 값 설정  
			
			// 구문객체 실행 
			// int      = pstmt.executeUpdate() : DML 구문 실행시 영향 받은 행수 리턴
			// ResultSet = pstmt.executeQuery() : select 구문 실행시 결과집한  리턴
			
			// 기본적으로 ResultSet 타입은 단순하고 빠르게 동작하기 위해  TYPE_FORWARD_ONLY, CONCUR_READ_ONLY 이다.   
			// ResultSet 에 있는   등록,수정 및 이동 등 메서드가 동작하지 않음 			
			rs = pstmt.executeQuery();
			
			// 결과집합을 이용해 프로그램 로직  처리
			while(rs.next()) {
				Member vo = new Member();
				vo.setAddress(rs.getString("address"));
				vo.setBirth(rs.getString("birth"));
				vo.setId(rs.getString("id"));
				vo.setLocaleCd(rs.getString("locale_cd"));
				vo.setName(rs.getString("name"));
				vo.setPoint(rs.getInt("point"));
				vo.setRegDate(rs.getString("reg_date"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
			// 결과 반환
			return list;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;  // 발생한 예외를 그대로 다시 전달  
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}	
	}
	
	//	회원 조회
	@Override
	public Member selectMember(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		// 회원정보를 담을 List객체 생성 
		Member member = null;
		try{
			conn = dataSource.getConnection();
			// String sql = "select * from TB_MEMBER order by reg_date DESC";
			
			// 문자열이 여러 줄인 경우 "문자열" + "문자열" 보다 문자열 처리객체(Builder,Buffer) 사용 권장  
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * ");
			sb.append("  FROM tb_member ");
			sb.append(" WHERE id = ? ");	// id 가 Primary KEY
			
			log.debug(sb.toString());
			
			// 구문 객체 생성 
			pstmt = conn.prepareStatement(sb.toString());
			// 파라미터(?) 설정에 따른 값 설정  
			pstmt.setString(1, id);
			
			// 구문객체 실행 
			// int      = pstmt.executeUpdate() : DML 구문 실행시 영향 받은 행수 리턴
			// ResultSet = pstmt.executeQuery() : select 구문 실행시 결과집한  리턴
			
			// 기본적으로 ResultSet 타입은 단순하고 빠르게 동작하기 위해  TYPE_FORWARD_ONLY, CONCUR_READ_ONLY 이다.   
			// ResultSet 에 있는   등록,수정 및 이동 등 메서드가 동작하지 않음 			
			rs = pstmt.executeQuery();
			
			// 결과집합을 이용해 프로그램 로직  처리
			// PK 조회이기 때문에 조회결과가 없거나 한개
			if(rs.next()) {
				member.setAddress(rs.getString("address"));
				member.setBirth(rs.getString("birth"));
				member.setId(rs.getString("id"));
				member.setLocaleCd(rs.getString("locale_cd"));
				member.setName(rs.getString("name"));
				member.setPoint(rs.getInt("point"));
				member.setRegDate(rs.getString("reg_date"));
				member.setTel(rs.getString("tel"));				
			}
			// 결과 반화 
			return member;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;  // 발생한 예외를 그대로 다시 전달  
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}	
	}
	
	@Override
	public int insertMember(Member member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		int result;
		try{
			conn = dataSource.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO tb_member  "); 
			sb.append("	      (id, name, point, birth, tel, address, locale_cd, reg_date)"); 
    		sb.append("VALUES ( ?, ?, 0, ?, ?, ?, ?, NOW()) ");
			
			log.debug(sb.toString());
			
			// 구문 객체 생성 
			pstmt = conn.prepareStatement(sb.toString());
			// 파라미터(?) 설정에 따른 값 설정
			int idx = 1;
			pstmt.setString(idx++, member.getId() );
			pstmt.setString(idx++, member.getName() );
			pstmt.setString(idx++, member.getBirth() );
			pstmt.setString(idx++, member.getTel() );
			pstmt.setString(idx++, member.getAddress() );
			pstmt.setString(idx++, member.getLocaleCd() );
			
			// 구문객체 실행 
			// int      = pstmt.executeUpdate() : DML 구문 실행시 영향 받은 행수 리턴
			// ResultSet = pstmt.executeQuery() : select 구문 실행시 결과집한  리턴			
			result = pstmt.executeUpdate();		
			return result;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;  // 발생한 예외를 그대로 다시 전달  
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	}
	
	@Override
	public int updateMember(Member member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		int result;
		try{
			conn = dataSource.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE tb_member");
			sb.append("SET NAME=?, birth=?, tel=?, address=?, locale_cd=?, WHERE id=?");
			
			log.debug(sb.toString());
			
			
			// 구문 객체 생성 
			pstmt = conn.prepareStatement(sb.toString());
			// 파라미터(?) 설정에 따른 값 설정
			int idx = 1;
			pstmt.setString(idx++, member.getName() );
			pstmt.setString(idx++, member.getBirth() );
			pstmt.setString(idx++, member.getTel() );
			pstmt.setString(idx++, member.getAddress() );
			pstmt.setString(idx++, member.getLocaleCd() );
			pstmt.setString(idx++, member.getId() );
			
			// 구문객체 실행 
			// int      = pstmt.executeUpdate() : DML 구문 실행시 영향 받은 행수 리턴
			// ResultSet = pstmt.executeQuery() : select 구문 실행시 결과집한  리턴			
			result = pstmt.executeUpdate();		
			return result;
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;  // 발생한 예외를 그대로 다시 전달  
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
	}
}



