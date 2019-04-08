package kr.ac.pcu.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	// String 뷰이름  
	// 파라미터에 Model, ModelMap, Map : 속성에 저장 
	@RequestMapping("/board/list.do")
	public String list(Model model) {
		model.addAttribute("msg", "주말 잘 보내세요..~~~");
		return "board/a";
	}

}
