package com.mybatis.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybatis.model.Dept;
import com.mybatis.model.Emp;
import com.mybatis.model.EmpDAO;

@Controller
public class EmpController {
	@Inject
	private EmpDAO dao;
	@RequestMapping("emp_list.go")
	public String list(Model model) {
		
		List<Emp> list = this.dao.getEmpList();
		model.addAttribute("EmpList", list);
		
		return "emp_list";
	}
	@RequestMapping("emp_insert.go")
	public String insert(Model model) {
		List<Dept> dept = this.dao.getDeptList();
		model.addAttribute("Dept", dept);
		return "emp_insert";
	}
	@RequestMapping("emp_insert_ok.go")
	public void insertok(Emp dto, HttpServletResponse response) throws IOException {
		System.out.println(dto);
		
		
		int check = this.dao.insertEmp(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check >0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='emp_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("emp_content.go")
	public String content(@RequestParam("no") int no, Model model) {
		Emp dto = this.dao.getEmp(no);
		
		model.addAttribute("Cont", dto);
		return "emp_content";
	}
	@RequestMapping("emp_update.go")
	public String update(@RequestParam("no") int no, Model model) {
		List<Dept> dept = this.dao.getDeptList();
		model.addAttribute("Dept", dept);
		
		Emp update = this.dao.getEmp(no);
		
		model.addAttribute("update", update);
		
		return "emp_update";
	}
	@RequestMapping("emp_update_ok.go")
	public void updateok(Emp dto, HttpServletResponse response) throws IOException {
		int check = this.dao.updateEmp(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='emp_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("emp_delete.go")
	public void deleteok(@RequestParam("no") int no, Model model, HttpServletResponse response) throws IOException {
		int check = this.dao.deleteEmp(no);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='emp_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
