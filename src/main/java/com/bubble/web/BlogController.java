package com.bubble.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bubble.po.Blog;
import com.bubble.po.User;
import com.bubble.service.BlogService;

@Controller
@RequestMapping("/admin")
public class BlogController {

	private static final String INPUT = "admin/blogs-input";
	private static final String LIST = "admin/blogs";
	private static final String REDIRECT_LIST = "redirect:/admin/blogs";

	@Autowired
	private BlogService blogService;

	@GetMapping("/blogs")
	public String blogs(
			@PageableDefault(size = 8, sort = { "blogId" }, direction = Sort.Direction.ASC) Pageable pageable,
			Blog blog, Model model) {
		model.addAttribute("page", blogService.listBlog(pageable, blog));
		return LIST;
	}

	@PostMapping("/blogs/search")
	public String search(
			@PageableDefault(size = 8, sort = { "blogId" }, direction = Sort.Direction.ASC) Pageable pageable,
			Blog blog, Model model) {
		model.addAttribute("page", blogService.listBlog(pageable, blog));
		return "admin/blogs :: blogList";
	}

	@GetMapping("/blogs/{id}/input")
	public String editInput(@PathVariable Integer id, Model model) {
		Blog blog = blogService.getBlog(id);
		model.addAttribute("blog", blog);
		return INPUT;
	}

	@GetMapping("/blogs/input")
	public String input(Model model) {
		model.addAttribute("blog", new Blog());
		return INPUT;
	}

	@PostMapping("/blogs")
	public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {
//        blog.setUser((User) session.getAttribute("user"));
		Blog b;
		if (blog.getBlogId() == null) {
			b = blogService.saveBlog(blog);
		} else {
			b = blogService.updateBlog(blog.getBlogId(), blog);
		}

		if (b == null) {
			attributes.addFlashAttribute("message", "操作失败");
		} else {
			attributes.addFlashAttribute("message", "操作成功");
		}
		return REDIRECT_LIST;
	}

//    @GetMapping("/blogs/{id}/delete")
//    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
//        blogService.deleteBlog(id);
//        attributes.addFlashAttribute("message", "删除成功");
//        return REDIRECT_LIST;
//    }

}
