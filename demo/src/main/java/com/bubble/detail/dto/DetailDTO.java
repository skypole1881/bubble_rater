package com.bubble.detail.dto;

import javax.persistence.Column;

import com.bubble.detail.model.Score;

public class DetailDTO {
	private int id;

	private String country;

	private String city;

	private String district;

	private String address;

	private String name;

	private String content;

	private String item;

	private String photo;
	
	private ScoreDTO score;
}
