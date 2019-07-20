package com.bubble.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bubble.po.Blog;
import com.bubble.po.Condition;
import com.bubble.po.Rating;

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
	
	List<Blog> setLatest(List<Blog> dtos);

	List<Blog> selectAll();
	
	List<Blog> selectNoKeyword(Condition cdt);
	
	List<Blog> selectAllByCity(Condition cdt);
	
	List<Blog> selectAllByDistrict(Condition cdt);
	
	List<Blog> selectAllByName(Condition cdt);
	
	List<Blog> selectByKeyword(Condition cdt);

	List<Blog> selectAllByCriteria(String criteria, String orderBy);

	List<Blog> selectAllByCriteriaByName(String criteria);

	List<Blog> selectTopTwelve();

	List<Blog> selectSixMore(Integer token);

	Integer countAllBlog();

	List<Blog> query(String firstTwoCharacters);

	List<Object> queryKeyWord(String first, String second);

	List<Blog> selectDefault();

	Integer getRank(String id);

	List<Blog> selectSixMoreOnly(Integer token);

	List<Rating> selectRating(String bubbletag);
}
