package com.bubble.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		model.addAttribute("blogs", dtos);
		return "home";
	}

	@GetMapping("/search")
	public String index(Model model, String criteria, Integer token) {
		List<Blog> dtos = new ArrayList<>();
		// ByCity
		if (token == 1) {
			dtos = blogService.selectAllByCriteriaByCity(criteria);
		}
		// ByDistrict
		if (token == 2) {
			dtos = blogService.selectAllByCriteriaByDistrict(criteria);
		}
		// By name
		if (token == 3) {

			dtos = blogService.selectAllByCriteriaByName(criteria);
		}

		if (dtos.size() < 3) {
			for (int i = 0; i < 3; i++) {
				Blog b = new Blog();
				b.setStoreCity("無資料");
				b.setStoreDistrict("");
				b.setStoreBrand("");

				dtos.add(b);
			}

		}
		model.addAttribute("blogs", dtos);
		return "home::#search";
	}

}
