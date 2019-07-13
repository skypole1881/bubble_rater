package com.bubble.util;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bubble.po.Blog;

@Component
public class BlogUtils {
	public List<Blog> setLatest(List<Blog> dtos){
		Date now = new Date();
		for (Blog blog : dtos) {
			if (now.getTime() - blog.getCreatedDtm().getTime() >= 7 * 24 * 60 * 60 * 1000) {
				blog.setLatest(false);
			} else {
				blog.setLatest(true);
			}
		}
		return dtos;
	}
}
