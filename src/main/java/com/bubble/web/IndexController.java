package com.bubble.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

	// 最開始載入頁面
	@RequestMapping(value = { "/", "/login1" })
	public String index(Model model) {
		List<Blog> dtos = blogService.selectTopTwelve();
		List<Blog> defaultList = blogService.selectDefault();
		Blog blog = blogService.getBlog(33);

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
		model.addAttribute("blog", blog);
		model.addAttribute("default", defaultList);
		model.addAttribute("searchAll", "搜尋全部...");

		return "home";
	}

	// modal單獨頁面
	@RequestMapping(value = "/single/{id}")
	public String indexSingle(Model model, @PathVariable("id") String id) {
		Blog blog = blogService.getBlog(Integer.valueOf(id));
		String rank = "NO." + blogService.getRank(id);
		model.addAttribute("rank", rank);
		model.addAttribute("blog", blog);

		return "single-store";
	}

	// open modal視窗
	@RequestMapping(value = "/modal/{id}", produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<?> modal(ModelMap model, @PathVariable("id") String id) {
		Blog blog = blogService.getBlog(Integer.valueOf(id));
		String rank = "NO." + blogService.getRank(id);
		Map<String, Object> map = new HashMap<>();
		map.put("rank", rank);
		map.put("blog", blog);
		return ResponseEntity.ok(map);
	}

	// 按下GO搜尋
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
			// 我要找 不拘
			// 全空會到這
			dtos = blogService.selectBlogsByCold(keyword, cold, orderby, limitNumStart, limitNumEnd);
		}

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
		model.addAttribute("blogs", dtos);
		return "home::searchPack";
	}

	// 這不知道啥
	@GetMapping("/load")
	public String load(Model model, Integer token) {
		System.out.println("load");
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

	// 找下六筆資料
	@RequestMapping(path = { "/loadsix" }, produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<?> loadsix(Integer token, String criteria, String keyword, String cold, String orderby) {
		System.out.println("loadsix");
		List<Blog> dtos = new ArrayList<>();
		dtos = blogService.selectSixMoreOnly(token);
		Map<String, Object> map = new HashMap<>();
		map.put("blogs", dtos);
		map.put("token", token);
		return ResponseEntity.ok(map);
	}

	// 不知道幹嘛的
	@GetMapping("/loadbu")
	public String loadbu(Model model, Integer token) {
		System.out.println("loadbu");
		List<Blog> dtos = new ArrayList<>();
		dtos = blogService.selectSixMore(token);
		boolean num = !(dtos.size() < token * 6 + 12);
		model.addAttribute("num", num);
		if (!num) {
			return "home::#bu";
		}
		return null;
	}

	// chosen選單 (類onchange)
	@RequestMapping(value = "/querykeyword", produces = { "application/json" })
	@ResponseBody
	public List<Blog> query(@RequestParam(value = "First", required = false, defaultValue = "") String First,
			@RequestParam(value = "Second", required = false, defaultValue = "") String Second) {
		List<Blog> KeyWords = new ArrayList<Blog>();
		System.out.println("First=====" + First);
		System.out.println("Second=====" + Second);
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
		if (!(Second.equals("district") || Second.equals("city"))) {
			KeyWords.add(0, null);
		}
		return KeyWords;
	}
}
