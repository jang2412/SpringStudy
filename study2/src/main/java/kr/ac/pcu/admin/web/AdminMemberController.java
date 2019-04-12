package kr.ac.pcu.admin.web;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.pcu.admin.service.AdminMemberService;

//	스프링이 빈으로 등록하도록 지정, @Service, @Repository, @Componert 등등
@Controller
public class AdminMemberController {
	
		// private AdminMemberService memberService = new AdminMemberServiceImpl();
		// 인터페이스는 메서드에 대한 규약(껍데기)일뿐  구현객체는 아니다. 
		// 실제 객체를 생성하여 사용해야 한다. 
		// 사람  hong = new 홍길동();  홍길동은 사람(상위클래스 또는 인터페이스)을 구현한 객체 
	  	// 사람  mal = new 말자();  말자는 사람(상위클래스 또는 인터페이스)을 구현한 객체
		// 홍길동만을 위한 편의점은 없다.(물론 만들수 있지만 홍길동에 종속되어 진다.)
		// 편의점 사장은 사람을 대한 판매를 하지 홍길동만을 위해서 판매를 하지는 않느다.
		// 인터페이스(또는 상위클래스) 변수명 = new 인터페이스구현 객체(); 
		// 위처럼 작성하는게 일반적이다.	
		
		// 근데  Spring DI를 왜 사용하냐고요??
		
		@Autowired
		private AdminMemberService memberService;
		
		@Autowired
		private SqlSession sqlSession;
		
		// 내부의 로깅처리를 위해 slf4j 로그 사용 
		private Logger log = LoggerFactory.getLogger(this.getClass());
			
		@RequestMapping("/admin/member/list.do")
		public String memberList(Model model) throws Exception {
			// 요청에 대한 검증 
			
			// 비즈니스로직 호출
			log.debug("서비스로 호출");
			List<Member> memberList = memberService.getMemberList();
			
		/*
		log.debug("sqlSession으로 직접 호출"); List<Member> memberList =
		sqlSession.selectList("kr.ac.pcu.admin.dao.MemberMapper.selectMemberList") ;
		 */

			// 해당 결과를 저장 (Model, ModelMap, Map)
			model.addAttribute("memberList", memberList);
			
			// 뷰로 포위드 
			return "admin/member/list";
		}
		
		
		// 사용자 등록을 위해서 입력처리에 대한 2가지를 사용
		// 방법 1.	등록화면 : regist.do, 등록처리 registProc.do
		// 방법 2.	등록화면 : regist.do(GET), 등록처리 registProc.do(POST)
		@RequestMapping(value="/admin/member/regist.do", method=RequestMethod.GET)
		public String memberRegist() throws Exception {
			
			// 뷰로 포위드		
			return "admin/member/regist";
		}
		
		@RequestMapping(value="/admin/member/regist.do", method=RequestMethod.POST)
		public String memberRegist(@Valid Member member, Errors errors) throws Exception {
			//	검증
			if(errors.hasErrors()) {
				return "admin/member/regist";
			}
			
			
			memberService.registMember(member);
			// 등록에 성공했는데... 결과에 대한 처리는 ??		
			return "redirect:/admin/member/list.do";
		}
	
	/*	4월 9일자 강의 내용
	//	현재 등록된 빈 중에 타입, 이름으로 생성된 객체를 의존객체 주입(의존 주입)
	@Autowired
	private MemberMapper memberDao;
	
	@RequestMapping("/admin/member/list.do")
	public String memberList(Model model) throws Exception{
		//	요청에 대한 검증
		
		//	비즈니스로직 호출
		List<Member> memberList = memberDao.selectMemberList();
		//	해당 결과를 저장(Model, ModelMap, Map)
		model.addAttribute("memberList", memberList);
		//	뷰로 전달(포워드)
		return "admin/member/list";
	}
	*/

}
