package com.mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.model.PC;
import com.mybatis.model.PCDAO;

@Controller
public class PCController {
	@Inject
	private PCDAO dao;
	
	@RequestMapping("pc_list.go")
	public String list(Model model) throws IOException {
		List<PC> list = this.dao.getPCList();
		for(PC pc : list) {
			if(pc.getImg() != null) {
				pc.setImg("resources/"+pc.getImg());
			}
		}
		model.addAttribute("List", list);
		return "pc_list";
	}
	@RequestMapping("pc_content.go")
	public String content(@RequestParam("no") int no, Model model) {
		PC dto = this.dao.getPC(no);
		
		model.addAttribute("Cont", dto);
		return "pc_content";
	}
	@RequestMapping("pc_insert.go")
	public String insert() {
		return "pc_insert";
	}
	@RequestMapping("pc_insert_ok.go")
	public void insertok(PC dto, HttpServletResponse res) throws IOException {
		int confirm =this.dao.insertPC(dto);
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=  res.getWriter();
		
		if(confirm >0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='pc_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('됨?')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("pc_update.go")
	public String update(@RequestParam("no") int no, Model model) {
		PC dto = this.dao.getPC(no);
		model.addAttribute("Upt", dto);
		
		return "pc_update";
	}
	@RequestMapping("pc_update_ok.go")
	public void updateok(PC dto, HttpServletResponse res) throws IOException {
		int check = this.dao.updatePC(dto);
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='pc_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("pc_delete.go")
	public void delete(@RequestParam("no") int no, HttpServletResponse res) throws IOException {
		int check = this.dao.deletePC(no);
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		if(check>0) {
			this.dao.updateSeq(no);
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='pc_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('되겠냐??')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("pc_search.go")
	public String search(@RequestParam("field") String field, 
						 @RequestParam("keyword") String keyword, Model model) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Field", field);
		map.put("Keyword", keyword);
		
		List<PC> searchList = this.dao.searchPCList(map);
		
		model.addAttribute("Search", searchList);
		return "pc_search_list";
	}
	
	
}
