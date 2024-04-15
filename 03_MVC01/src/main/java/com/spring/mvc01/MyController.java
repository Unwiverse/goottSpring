package com.spring.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	/*
	 * 스프링 MVC에서 Model이란?
	 * - 컨트롤러에 매핑을 통해 요청 정보가 들오면 매핑으로 일치하는 매핑을 찾음.
	 * - 찾고나면 해당 메서드에서 비지니스 로직이 수행됨.
	 *   비지니스 로직이 수행이 되고나면 대체적으로 view page로 보내줄 정보들이 만들어짐.
	 * - 스프링에선 이걸 Model이라고 함. 이 Model 정보를 view 페이지로 보내게됨.
	 * 
	 * 
	 */
	@RequestMapping("info")
	public String aaa(Model model) {
		model.addAttribute("Name", "홍길동").addAttribute("Email", "hong@email.com")
		.addAttribute("Phone", "01050028033").addAttribute("Addr", "부일로 11길 128");
			
		return "person";
	}
		@RequestMapping("member")
		public ModelAndView bbb() {
			ModelAndView mav = new ModelAndView();
			mav.addObject("Name", "세종대왕").addObject("userId", "sejong")
			.addObject("Addr", "옥천허브");
			
			mav.setViewName("/member/memberInfo");
			
			return mav;
		}
}
