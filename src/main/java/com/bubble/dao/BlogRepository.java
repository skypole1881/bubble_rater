package com.bubble.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bubble.po.Blog;

public interface BlogRepository extends JpaRepository<Blog,Long>,JpaSpecificationExecutor<Blog>{

	Page<Blog> findAll(Specification<Blog> specification, Pageable pageable);

}
