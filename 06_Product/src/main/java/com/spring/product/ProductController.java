package com.spring.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.ProductService;

@Controller
public class ProductController {
	@Inject
	private ProductService service;
	
	@RequestMapping("product_list.go")
	public String list(Model model) {
		List<Product> list = this.service.getList();
		
		model.addAttribute("List", list);
		
		return "product_list";
	}
	@RequestMapping("product_insert.go")
	public String insert(Model model) {
		List<Category> list = this.service.categoryList();
		
		model.addAttribute("List" ,list);
		
		return "product_insert";
	}
	@RequestMapping("product_insert_ok.go")
	public void insertok(Product dto, HttpServletResponse response) throws IOException {
		int check = this.service.insert(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(check>0) {
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='product_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("location.href='product_list.go'");
			out.println("</script>");
		}
		
		
	}
	@RequestMapping("product_content.go")
	public ModelAndView content(@RequestParam("pnum") int pnum) {
		ModelAndView mav = new ModelAndView();
		
		Product cont = this.service.content(pnum);
		mav.addObject("cont", cont);
		mav.setViewName("product_content");
		
		return mav;
	}
	@RequestMapping("product_update.go")
	public String update(Model model, @RequestParam("pnum") int pnum) {
		
		Product pro = this.service.content(pnum);
		model.addAttribute("List", pro);
		
		
		return "product_update";
	}
	@RequestMapping("product_update_ok.go")
	public void updateok(@ModelAttribute("product")Product product, HttpServletResponse response) throws IOException {
		int result = this.service.update(product);
		System.out.println(product.getProducts_name());
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result >0) {
			out.println("<script>");
			out.println("alert('00됨')");
			out.println("location.href='product_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨22')");
			out.println("location.href='product_list.go'");
			out.println("</script>");
		}
		
		
	}
	@RequestMapping("product_delete_ok.go")
	public void delete(@RequestParam("pnum") int pnum, HttpServletResponse response) throws IOException {
		int result = this.service.delete(pnum);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(result>0) {
			this.service.sequence(pnum);
			out.println("<script>");
			out.println("alert('됨')");
			out.println("location.href='product_list.go'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('안됨')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
}
