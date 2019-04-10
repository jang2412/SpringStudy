package kr.ac.pcu.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.pcu.admin.web.Member;

@Mapper
public interface MemberMapper {

	/**
	 * 회원정보를 조회하여 목록을 리턴 <br>
	 * @return List
	 * @throws Exception
	 */
	List<Member> selectMemberList() throws Exception;

	/**
	 * 회원의 id 를 받아서 해당 회원의 정보를 조회하여 리턴 
	 * @param id
	 * @return Member
	 * @throws Exception
	 */
	Member selectMember(String id) throws Exception;

	/**
	 * 회원정보를 테이블에 등록 <br> 
	 * @param member
	 * @return int (영향받은 행수)
	 * @throws Exception
	 */
	int insertMember(Member member) throws Exception;

	/**
	 * 회원정보를 테이블에 변경 <br>
	 * @param member
	 * @return int (영향받은 행수)
	 * @throws Exception
	 */
	int updateMember(Member member) throws Exception;

}