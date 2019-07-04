package com.bubble.dao;

import java.util.List;

import com.bubble.po.Blog;
import com.bubble.po.Condition;

public interface BlogRepo {
	public abstract List<Blog> sixMore(int token);

	public abstract List<Blog> selectAll(Condition cdt);

	public abstract List<Blog> selectAllWithCold(Condition cdt);

	public abstract List<Blog> selectAllByCity(Condition cdt);

	public abstract List<Blog> selectAllByCityWithCold(Condition cdt);

	public abstract List<Blog> selectAllByDistrict(Condition cdt);

	public abstract List<Blog> selectAllByDistrictWithCold(Condition cdt);

	public abstract List<Blog> selectAllByName(Condition cdt);

	public abstract List<Blog> selectAllByNameWithCold(Condition cdt);

	public abstract List<Blog> selectAllByKeyword(Condition cdt);
}
