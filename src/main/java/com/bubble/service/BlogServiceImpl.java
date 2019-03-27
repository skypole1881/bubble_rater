package com.bubble.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bubble.NotFoundException;
import com.bubble.dao.BlogRepository;
import com.bubble.po.Blog;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog getBlog(Long id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

	@Override
	public Page<Blog> listBlogPage(Pageable pageable, Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.findAll(new Specification<Blog>() {

			@Override
			public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
					predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() +  "%"));
				}
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				return null;
			}
		}, pageable);
	}

	@Override
	public Blog saveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.save(blog);
	}

	@Override
	public Blog updateBlog(Long id, BlogService blog) {
		Blog b = blogRepository.findOne(id);
		if (b == null) {
			throw new NotFoundException("not exist");
		}
		BeanUtils.copyProperties(b, blog);
		return blogRepository.save(b);
	}

	@Override
	public void deleteBlog(Long id) {
		blogRepository.delete(id);

	}

}
