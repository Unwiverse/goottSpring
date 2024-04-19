package com.spring.parts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.PC;
import com.spring.model.PCService;

@Controller
public class PCController {
	@Inject
	private PCService service;
	
	@RequestMapping("pc_list.go")
	public String list(Model model) {
		List<PC> list = this.service.getList();
		
		model.addAttribute("List", list);
		return "pc_list";
	}
	@RequestMapping("pc_insert.go") 
	public String insert() {
		
		return "pc_insert";
	}
	@RequestMapping("pc_insert_confirm.go")
	public void insertok(PC dto, HttpServletResponse response) throws IOException {
		int check = this.service.insert(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
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
	@RequestMapping("pc_content.go")
	public String cont(@RequestParam("pnum") int no, Model model) {
		PC pc = this.service.content(no);
		model.addAttribute("PC", pc);
		return "pc_content";
	}
	
}
