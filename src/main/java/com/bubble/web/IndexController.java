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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bubble.po.Blog;
import com.bubble.po.Condition;
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
	public String index(Condition cdt, BindingResult br, Model model) {
		List<Blog> dtos = new ArrayList<>();
		// 假設keyword是空的, btnGroup2的所有條件都無效, 直接進入判斷btnGroup1程序
		if (cdt.getKeyword().trim().equals("")) {
			dtos = blogService.selectNoKeyword(cdt);
		}else {
			if (cdt.getCriteria().equals("city")) {
				dtos = blogService.selectAllByCity(cdt);
			} else if (cdt.getCriteria().equals("district")) {
				dtos = blogService.selectAllByDistrict(cdt);
			} else if (cdt.getCriteria().equals("store")) {
				dtos = blogService.selectAllByName(cdt);
			} else {
				// btnGroup1 跟 btnGroup 都沒有選, 只有選keyword(這時的keyword只有店家名稱)
				dtos = blogService.selectByKeyword(cdt);
			}
		}
		boolean num = true;
		if(dtos.size() <= 12) {
			num = false;
		}else {
			dtos.remove(cdt.getLimitNumEnd()-1);
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
		model.addAttribute("num", num);
		model.addAttribute("blogs", dtos);
		return "home::searchPack";
	}

	// 找下六筆資料
	@RequestMapping(path = { "/loadsix" }, produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<?> loadsix(Condition cdt, BindingResult br) {
		System.out.println("loadsix");
		// 每 6 筆為一頁，第token + 1 頁 (從0開始，前面12筆固定等於內建0跟1頁)
		cdt.setLimitNumStart(12 + (cdt.getToken() - 1) * 6);
		cdt.setLimitNumEnd(7);
		System.out.println("limitNumStart==" + cdt.getLimitNumStart());
		System.out.println("limitNumEnd==" + cdt.getLimitNumEnd());

		List<Blog> dtos = new ArrayList<>();
		// 假設keyword是空的, btnGroup2的所有條件都無效, 直接進入判斷btnGroup1程序
		if (cdt.getKeyword().trim().equals("")) {
			dtos = blogService.selectNoKeyword(cdt);
		}else {
			if (cdt.getCriteria().equals("city")) {
				dtos = blogService.selectAllByCity(cdt);
			} else if (cdt.getCriteria().equals("district")) {
				dtos = blogService.selectAllByDistrict(cdt);
			} else if (cdt.getCriteria().equals("store")) {
				dtos = blogService.selectAllByName(cdt);
			} else {
				// btnGroup1 跟 btnGroup 都沒有選, 只有選keyword(這時的keyword只有店家名稱)
				dtos = blogService.selectByKeyword(cdt);
			}
		}
		boolean num = true;
		if(dtos.size() <= 6) {
			num = false;
		}else {
			dtos.remove(cdt.getLimitNumEnd()-1);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("blogs", dtos);
		map.put("token", cdt.getToken());
		map.put("num", num);
		return ResponseEntity.ok(map);
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
