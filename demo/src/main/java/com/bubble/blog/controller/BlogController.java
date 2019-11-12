package com.bubble.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bubble.blog.model.Blog;
import com.bubble.blog.service.BlogService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/bubble/blog")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createBlog(@RequestBody Blog blog) throws Exception {
		blogService.createBlog(blog);
		return new ResponseEntity<>("Blog is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> updateDetail(@RequestBody Blog blog) throws Exception {
		blogService.updateBlog(blog);
		return new ResponseEntity<>("Bubble detail is updated successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable("id") Integer id) {
		blogService.deleteBlog(id);
		return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Object> query(@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "name", required = false) String name) {
		return new ResponseEntity<>(blogService.queryBlog(pageNo, pageSize, sortBy, name), HttpStatus.OK);
	}

}
