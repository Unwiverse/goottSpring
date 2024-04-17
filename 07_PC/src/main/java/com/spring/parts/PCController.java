package com.spring.parts;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.model.PC;
import com.spring.model.PCService;

@Controller
public class PCController {
	@Inject
	private PCService service;
	
	@RequestMapping("pc_list.go")
	public String insert(Model model) {
		List<PC> list = this.service.getList();
		
		model.addAttribute("List", list);
		return "pc_list";
	}
	
}
