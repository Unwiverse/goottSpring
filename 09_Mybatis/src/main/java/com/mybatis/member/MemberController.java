package com.mybatis.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.model.Member;
import com.mybatis.model.MemberDAO;

@Controller
public class MemberController {
	@Inject
	private MemberDAO dao;
	
	@RequestMapping("member_list.go")
	public String list(Model model) {
		List<Member> list= this.dao.getMemberList();
		
		model.addAttribute("List" ,list);
		
		return "member_list";
	}
	
}
