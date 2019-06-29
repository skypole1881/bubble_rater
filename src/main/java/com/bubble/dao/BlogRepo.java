package com.bubble.dao;

import java.util.List;

import com.bubble.po.Blog;

public interface BlogRepo {
	public abstract List<Blog> sixMore(int token);
}
