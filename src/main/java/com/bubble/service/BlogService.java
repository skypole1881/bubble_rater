package com.bubble.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bubble.po.Blog;
import com.bubble.vo.BlogQuery;

public interface BlogService {

	Blog getBlog(Long id);

	Blog getAndConvert(Long id);

	Page<Blog> listBlog(Pageable pageable, Blog blog);

	Page<Blog> listBlog(Pageable pageable);

	Page<Blog> listBlog(Long tagId, Pageable pageable);

	Page<Blog> listBlog(String query, Pageable pageable);

	List<Blog> listRecommendBlogTop(Integer size);

	Map<String, List<Blog>> archiveBlog();

	Long countBlog();

	Blog saveBlog(Blog blog);

	Blog updateBlog(Long id, Blog blog);

	void deleteBlog(Long id);
}
