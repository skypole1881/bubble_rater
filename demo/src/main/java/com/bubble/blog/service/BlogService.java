package com.bubble.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bubble.blog.model.Blog;
import com.bubble.blog.repository.BlogRepository;
import com.bubble.util.SysUtil;

import javassist.NotFoundException;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	@Transactional
	public void createBlog(Blog blog) throws Exception {
		if (blog.getId() != 0) {
			throw new Exception("Id should be empty");
		}
		blog.updateCommonInfo();
		blogRepository.save(blog);
	}

	public Object getBlog(Integer id) {
		return blogRepository.findById(id);
	}

	@Transactional
	public void deleteBlog(Integer id) {
		blogRepository.deleteById(id);
	}

	public List<Blog> queryBlog(Integer pageNo, Integer pageSize, String sortBy, String criteritera) {
		int limitStart = 0;
		int limitEnd = 10;

		if (sortBy == null) {
			sortBy = "id";
		}
		if (criteritera == null) {
			criteritera = "";
		}

		if (pageNo != null && pageSize != null) {
			limitStart = (pageSize) * (pageNo - 1);
			limitEnd = pageSize;
		}
		return blogRepository.queryBlog(criteritera, sortBy, limitStart, limitEnd);
	}

	@Transactional
	public void updateBlog(Blog blog) throws Exception {
		if (blog.getId() == 0) {
			throw new Exception("Id can not be empty");
		}
		Blog blogObject = blogRepository.findById(blog.getId()).orElse(blog);
		BeanUtils.copyProperties(blog, blogObject, SysUtil.getNullPropertyNames(blog));
		blogObject.updateCommonInfo();
		blogRepository.save(blogObject);
	}

}
