package com.bubble.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bubble.po.Blog;

public interface BlogService {

	Blog getBlog(Integer id);

	Blog getAndConvert(Integer id);

	Page<Blog> listBlog(Pageable pageable, Blog blog);

	Page<Blog> listBlog(Pageable pageable);

	Page<Blog> listBlog(String query, Pageable pageable);

	List<Blog> listRecommendBlogTop(Integer size);

	Map<String, List<Blog>> archiveBlog();

	Long countBlog();

	Blog saveBlog(Blog blog);

	Blog updateBlog(Integer id, Blog blog);

	void deleteBlog(Integer id);

	List<Blog> selectAll();

	List<Blog> selectAllByCriteria(String criteria, String orderBy);

	List<Blog> selectAllByKeywordByCity(String keyword, String cold, String orderby, Integer limitNumStart, Integer limitNumEnd);

	List<Blog> selectAllByKeywordByDistrict(String keyword, String cold, String orderby, Integer limitNumStart, Integer limitNumEnd);
	
	List<Blog> selectAllByKeywordByName(String keyword, String cold, String orderby, Integer limitNumStart, Integer limitNumEnd);

	List<Blog> selectAllByCriteriaByName(String criteria);

	List<Blog> selectTopTwelve();

	List<Blog> selectSixMore(Integer token);

	Integer countAllBlog();

	List<Blog> query(String firstTwoCharacters);

	List<Blog> queryKeyWord(String first, String second);

	List<Blog> selectDefault();

	Integer getRank(String id);

	List<Blog> selectBlogsByCold(String cold, String orderby, Integer limitNumStart, Integer limitNumEnd);


}
