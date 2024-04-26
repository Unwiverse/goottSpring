package com.mybatis.pc_mybatis_mvc2;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybatis.model.PMMDAO;
import com.mybatis.model.Page;

@Controller
public class PC_MyBatis_MVC2_Controller {
	
	@Inject
	private PMMDAO dao;
	
	//한 페이지에 보여줄 게시물 수 
	private final int rowsize=3;
	
	//DB 상의 전체 게시물 수
	private int totalRecord=0;
	
	int nowpage; //현재 페이지
	
	@RequestMapping("pc_list.go")
	public String list(HttpServletRequest req, Model model) {
		//페이징 처리 작업
		if(req.getParameter("page") != null) {
			nowpage =Integer.parseInt(req.getParameter("page"));
		} else { //처음으로 게시물 전체 목록 태그를 클릭함
			nowpage=1;
		}
		return null;
		
		
		
	}
	
	
}
