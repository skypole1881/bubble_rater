package com.bubble.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import com.bubble.po.Blog;

public interface BlogService {
	Blog getBlog(Long id);

	Page<Blog> listBlogPage(Pageable pageable, Blog blog);

	Blog saveBlog(Blog blog);

	Blog updateBlog(Long id, BlogService blog);

	void deleteBlog(Long id);
}
