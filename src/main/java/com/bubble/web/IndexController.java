package com.bubble.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<Blog> defaultList = blogService.selectDefault();

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
		model.addAttribute("default", defaultList);
		return "home";
	}

	@GetMapping("/single")
	public String indexSingle(Model model, @RequestParam("Id") String Id) {
		Blog blog = blogService.getBlog(Integer.valueOf(Id));
		String rank = "NO." + blogService.getRank(Id);
		model.addAttribute("rank", rank);
		model.addAttribute("blog", blog);
		return "single-store";
	}

	// 這裡看要不要改成POST
	@GetMapping("/search")
	public String index(Model model, String criteria, String keyword, String cold, String orderby,
			Integer limitNumStart, Integer limitNumEnd) {
		List<Blog> dtos = new ArrayList<>();

		if (criteria.equals("city")) {
			dtos = blogService.selectAllByKeywordByCity(keyword, cold, orderby, limitNumStart, limitNumEnd);
		} else if (criteria.equals("district")) {
			dtos = blogService.selectAllByKeywordByDistrict(keyword, cold, orderby, limitNumStart, limitNumEnd);
		} else if (criteria.equals("store")) {
			dtos = blogService.selectAllByKeywordByName(keyword, cold, orderby, limitNumStart, limitNumEnd);
		} else {
			//我要找 不拘 
			//全空會到這
			dtos = blogService.selectBlogsByCold(cold, orderby, limitNumStart, limitNumEnd);
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

	@RequestMapping(value = "/querykeyword")
	@ResponseBody
	public List<Blog> query(@RequestParam(value = "First", required = false, defaultValue = "") String First,
			@RequestParam(value = "Second", required = false, defaultValue = "") String Second) {
		List<Blog> KeyWords = new ArrayList<Blog>();
		try {
			KeyWords = blogService.queryKeyWord(First, Second);
			if (Second.equals("district")) {
				for (Blog blog : KeyWords) {
					blog.setStoreDistrict(blog.getStoreDistrict() + "," + blog.getStoreCity());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return KeyWords;

	}

}
