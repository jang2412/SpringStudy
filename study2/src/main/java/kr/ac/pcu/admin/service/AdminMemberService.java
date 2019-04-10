package kr.ac.pcu.admin.service;

import java.util.List;

import kr.ac.pcu.admin.web.Member;

public interface AdminMemberService {
	// 인터페이스는 기본적으로 public 입니다. 
	
	/**
	 * 회원정보를 조회하여 목록을 리턴 <br>
	 * @return List
	 * @throws Exception
	 */
	List<Member> getMemberList() throws Exception;

	/**
	 * 회원의 id 를 받아서 해당 회원의 정보를 조회하여 리턴 
	 * @param id
	 * @return Member
	 * @throws Exception
	 */
	Member getMember(String id) throws Exception;

	/**
	 * 회원정보를 테이블에 등록 <br> 
	 * @param member
	 * @return boolean (성공여부) 
	 * @throws Exception
	 */
	boolean registMember(Member member) throws Exception;

	/**
	 * 회원정보를 테이블에 변경 <br>
	 * @param member
	 * @return boolean (성공여부)
	 * @throws Exception
	 */
	boolean modifyMember(Member member) throws Exception;

}
