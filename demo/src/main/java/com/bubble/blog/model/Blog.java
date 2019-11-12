package com.bubble.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.bubble.util.BasePojo;

@Entity
@DynamicUpdate
@Table(name = "bubble_blog")
public class Blog extends BasePojo {

	
	@NotNull 
	private String title;

	private String content;

	private String photo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
