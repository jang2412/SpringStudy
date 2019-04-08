package kr.ac.pcu.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//	스프링이 빈으로 등록하도록 지정, @Service, @Repository, @Componert 등등
@Controller
public class AdminMemberController {
	
	@RequestMapping("/admin/member/list.do")
	public String memberList(Model model) throws Exception{
		//	요청에 대한 검증
		
		//	비즈니스로직 호출
		
		//	해당 결과를 저장(Model, ModelMap, Map)
		
		//	뷰로 전달(포워드)
		
		return "admin/member/list";
	}

}
