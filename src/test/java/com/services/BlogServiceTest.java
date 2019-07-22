package com.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bubble.service.BlogServiceImpl;


@SpringBootTest(classes = { BlogServiceImpl.class })
public class BlogServiceTest {
	
	@Autowired
	BlogServiceImpl blogServiceImpl;

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	void testGet() {
		assertEquals(blogServiceImpl.countBlog(),"");
	}

}
