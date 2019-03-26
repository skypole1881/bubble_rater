package com.bubble.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
//		String blog = null;
//		if (blog == null) {
//			throw new NotFoundException("nnnnn");
//		}
		System.out.println("index");
		return "index";
	}
}
