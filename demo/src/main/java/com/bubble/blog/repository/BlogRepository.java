package com.bubble.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bubble.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
	@Query(value = "SELECT * FROM bubble_blog WHERE title like %?1% order by?2 limit ?3, ?4", nativeQuery = true)
	List<Blog> queryBlog(String criteritera, String sortBy, Integer limitStart, Integer limitEnd);

}
