package com.bubble.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bubble.po.Blog;
import com.bubble.service.BlogService;

@Controller
public class IndexController {

	@Autowired
	private BlogService blogService;

	@GetMapping("/")
	public String index(Model model) {
		List<Blog> dtos = blogService.selectAll();
		if (dtos.size() < 3) {
			for (int i = 0; i < 3; i++) {
				Blog b = new Blog();
				b.setStoreCity("無資料");
				b.setStoreDistrict("");
				b.setStoreBrand("");

				dtos.add(b);
			}

		}
		model.addAttribute("blog", dtos);
		return "home";
	}
	@GetMapping("/test")
	public String index(Model model,String criteria) {
		List<Blog> dtos = blogService.selectAllByCriteria(criteria);
		if (dtos.size() < 3) {
			for (int i = 0; i < 3; i++) {
				Blog b = new Blog();
				b.setStoreCity("無資料");
				b.setStoreDistrict("");
				b.setStoreBrand("");

				dtos.add(b);
			}

		}
		model.addAttribute("blog", dtos);
		return "home::#search";
	}
}
