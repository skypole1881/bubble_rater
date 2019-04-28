package com.bubble.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bubble.service.BlogService;

@Controller
public class IndexController {

	@Autowired
	private BlogService blogService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("blog", blogService.selectAll());
		return "home";
	}
}
