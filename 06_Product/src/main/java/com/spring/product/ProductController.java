package com.spring.product;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}