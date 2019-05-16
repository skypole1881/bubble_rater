package com.bubble.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bubble.po.Blog;
import com.bubble.service.BlogService;

@Controller
public class IndexController {

	@Autowired
	private BlogService blogService;

	@GetMapping("/")
	public String index(Model model) {
		List<Blog> dtos = blogService.selectTopTwelve();
		if (dtos.size() < 4) {
			for (int i = 0; i < 3; i++) {
				Blog b = new Blog();
				b.setStoreCity("無資料");
				b.setStoreDistrict("");
				b.setStoreBrand("");
				b.setPhotoLink("無圖片");

				dtos.add(b);
			}
		}
		boolean num = true;
		model.addAttribute("num", num);
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

	@GetMapping("/load")
	public String load(Model model, Integer token) {
		List<Blog> dtos = new ArrayList<>();
		dtos = blogService.selectSixMore(token);
		Integer num = dtos.size() + token;
		model.addAttribute("num", num);

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

	@GetMapping("/loadbu")
	public String loadbu(Model model, Integer token) {
		List<Blog> dtos = new ArrayList<>();
		dtos = blogService.selectSixMore(token);
		boolean num = !(dtos.size() < token * 6 + 12);
		model.addAttribute("num", num);
		if (!num) {
			return "home::#bu";
		}
		return null;
	}

	@RequestMapping(value = "/queryCharacters")
	@ResponseBody
	public List<Blog> query(
			@RequestParam(value = "term", required = false, defaultValue = "") String term) {
		List<Blog> suggestions = new ArrayList<Blog>();
		String firstTwoCharacters;
		try {
			// only update when term is three characters.
			if (term.length() == 2) {
				firstTwoCharacters = term;
				suggestions = blogService.query(firstTwoCharacters);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return suggestions;

	}

}
