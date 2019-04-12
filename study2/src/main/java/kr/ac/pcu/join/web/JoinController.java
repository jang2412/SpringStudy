package kr.ac.pcu.join.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.pcu.admin.service.AdminMemberService;
import kr.ac.pcu.admin.web.Member;

@Controller
public class JoinController {

	//	/join/login.do : GET : 로그인 화면
	//	/join/login.do : POST : 로그인 처리
	//	/join/logout.do : 로그아웃 처리
	
	//	@autowire, @resource, @inject : DI 어노테이션
	@Inject
	private AdminMemberService memberService;
	
	@RequestMapping(value="/join/login.do", method=RequestMethod.GET)
	public String login() throws Exception {
		return "join/login";
	}
	
	@PostMapping("/join/login.do")
	public String login(@ModelAttribute("member") Member member
						, Errors error
						, HttpSession session) throws Exception {
		//	입력파라미터 검증
		
		//	서비스 호출
		Member result = memberService.getLoginCheck(member);
		if(result != null) {
			session.setAttribute("LOGIN_INFO", result);
			// 홈으로 리다이렉트
			return "redirect:/";
			
		}else {
			// 해당 회원이 존재하지 않는다는 증거
			return "join/login";
		}
	}
	
	@RequestMapping("/join/logout.do")
	public String logout(HttpSession session) throws Exception{
		// 세션 무효화
		session.invalidate();
		// 홈으로 리다이렉트
		return "redirect:/";
	}
}
