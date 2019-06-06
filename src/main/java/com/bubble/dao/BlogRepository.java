package com.bubble.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bubble.po.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>, JpaSpecificationExecutor<Blog> {

//	@Query("select b from Blog b where b.recommend = true")
//	List<Blog> findTop(Pageable pageable);
//
//	@Query("select b from Blog b where b.title like ?1 or b.content like ?1")
//	Page<Blog> findByQuery(String query, Pageable pageable);
//
//	@Transactional
//	@Modifying
//	@Query("update Blog b set b.views = b.views+1 where b.id = ?1")
//	int updateViews(Long id);
//
//	@Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc ")
//	List<String> findGroupYear();
//
//	@Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
//	List<Blog> findByYear(String year);

	@Query("select b from Blog b  where publish = '1' order by bubbleRate desc")
	List<Blog> selectBlogOrderByBubbleRate();

	@Query("select b from Blog b where publish = '1' order by teaRate desc")
	List<Blog> selectBlogOrderByTeaRate();

	@Query("select b from Blog b where publish = '1' order by createdDtm desc")
	List<Blog> selectBlogOrderByCreatedTime();

	@Query("select b from Blog b where publish = '1' order by totalRate desc")
	List<Blog> selectBlogOrderByTotalRate();
	
	// 限制筆數
	@Query("select b from Blog b where publish = '1' order by totalRate desc,godfeelingRate")
	List<Blog> selectTopTwelveBlogOrderByTotalRate(Pageable pageable);

	@Query("select b from Blog b where publish = '1' order by totalRate desc,godfeelingRate")
	List<Blog> selectSixMore(Pageable pageable);

	//go 搜尋條件
	@Query("select b from Blog b where publish = '1' and cold =:cold and storeCity=:keyword")
	List<Blog> selectAllByKeywordByCityWithCold(@Param("keyword") String keyword, @Param("cold")Boolean cold, @Param("orderby")Pageable pageable);
	@Query("select b from Blog b where publish = '1' and cold=:cold and storeDistrict=:keyword")
	List<Blog> selectAllByKeywordByDistrictWithCold(@Param("keyword") String keyword, @Param("cold")Boolean cold, @Param("orderby")Pageable pageable);
	@Query("select b from Blog b where publish = '1' and cold=:cold and storeBrand=:keyword")
	List<Blog> selectAllByKeywordByNameWithCold(@Param("keyword") String keyword, @Param("cold")Boolean cold, @Param("orderby")Pageable pageable);
	//without cold
	@Query("select b from Blog b where publish = '1' and cold =:cold and storeCity=:keyword")
	List<Blog> selectAllByKeywordByCity(@Param("keyword") String keyword, @Param("orderby")Pageable pageable);
	@Query("select b from Blog b where publish = '1' and cold=:cold and storeDistrict=:keyword")
	List<Blog> selectAllByKeywordByDistrict(@Param("keyword") String keyword, @Param("orderby")Pageable pageable);
	@Query("select b from Blog b where publish = '1' and cold=:cold and storeBrand=:keyword")
	List<Blog> selectAllByKeywordByName(@Param("keyword") String keyword, @Param("orderby")Pageable pageable);
	
	
	
	
	@Query("select b from Blog b where publish = '1' and storeCity=:criteria order by totalRate desc,godfeelingRate ")
	List<Blog> selectBlogOrderByCriteriaStoreCity(@Param("criteria") String criteria);

	@Query("select COUNT(*) from Blog b where publish = '1'")
	Integer countBlog();

	@Query("select DISTINCT (b.storeCity) from Blog b where publish = '1' and storeCity LIKE CONCAT('%',:firstTwoCharacters,'%')")
	List<Blog> queryCity(@Param("firstTwoCharacters") String firstTwoCharacters);

	
	
	// query key word
	@Query("select DISTINCT (b.storeCity) from Blog b where publish = '1'")
	List<Blog> queryKeyWordByStoreCity();

	@Query("select DISTINCT (b.storeBrand) from Blog b where publish = '1'")
	List<Blog> queryKeyWordByStoreName();

	@Query("select DISTINCT (b.storeDistrict),b.storeCity from Blog b where publish = '1'")
	List<Blog> queryKeyWordByDistrict();

	// query key word with ice
	@Query("select DISTINCT (b.storeCity) from Blog b where publish = '1'and cold=:cold")
	List<Blog> queryKeyWordByStoreCityWithCold(@Param("cold") Boolean cold);

	@Query("select DISTINCT (b.storeBrand) from Blog b where publish = '1'and cold=:cold")
	List<Blog> queryKeyWordByStoreNameWithCold(@Param("cold") Boolean cold);

	@Query("select DISTINCT (b.storeDistrict),b.storeCity from Blog b where publish = '1'and cold=:cold")
	List<Blog> queryKeyWordByDistrictWithCold(@Param("cold") Boolean cold);

	
	
	@Transactional
	@Modifying
	@Query("update Blog b set b.bubbleRatePR = :score where blogId=:id")
	int updateBubbleRatePR(@Param("score") float score, @Param("id") int id);

	@Transactional
	@Modifying
	@Query("update Blog b set b.teaRatePR =:score where blogId=:id")
	int updateTeaRatePR(@Param("score") float score, @Param("id") int id);

	@Transactional
	@Modifying
	@Query("update Blog b set b.latest =:latest where blogId=:id")
	void updateLatest(@Param("latest") boolean b, @Param("id") int id);

	@Transactional
	@Modifying
	@Query("update Blog b set b.totalRate =:rate where blogId=:id")
	void updateTotalRate(@Param("rate") float rate, @Param("id") int id);



}
