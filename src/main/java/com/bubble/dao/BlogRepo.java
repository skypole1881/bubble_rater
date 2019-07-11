package com.bubble.dao;

import java.util.List;

import com.bubble.po.Blog;
import com.bubble.po.Condition;
import com.bubble.po.Rating;

public interface BlogRepo {
	public abstract List<Blog> sixMore(int token);

	public abstract List<Blog> selectAll();
	
	public abstract List<Blog> selectAllOrderBy(Condition cdt);

	public abstract List<Blog> selectAllWithCold(Condition cdt);

	public abstract List<Blog> selectAllByCity(Condition cdt);

	public abstract List<Blog> selectAllByCityWithCold(Condition cdt);

	public abstract List<Blog> selectAllByDistrict(Condition cdt);

	public abstract List<Blog> selectAllByDistrictWithCold(Condition cdt);

	public abstract List<Blog> selectAllByName(Condition cdt);

	public abstract List<Blog> selectAllByNameWithCold(Condition cdt);

	public abstract List<Blog> selectAllByKeyword(Condition cdt);

	public abstract List<Object> queryKeyWordByStoreCityWithCold(Boolean cold);

	public abstract List<Object> queryKeyWordByDistrictWithCold(Boolean cold);

	public abstract List<Object> queryKeyWordByStoreNameWithCold(Boolean cold);
	
	public abstract List<Object> queryKeyWordByStoreCity();
	
	public abstract List<Object> queryKeyWordByDistrict();
	
	public abstract List<Object> queryKeyWordByStoreName();
	
	public abstract void updateLatest(Blog blog);
	
	public abstract List<Rating> selectRating(String bubbletag);
}
