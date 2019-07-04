package com.bubble.po;

public class Condition {
	private String criteria;
	private String keyword;
	private String cold;
	private String orderby;
	private Integer limitNumStart;
	private Integer limitNumEnd;
	private Integer token;
	private Boolean coldBoolean;
	public Condition() {
		super();
	}
	public Condition(String criteria, String keyword, String cold, String orderby, Integer limitNumStart,
			Integer limitNumEnd, Integer token, Boolean coldBoolean) {
		super();
		this.criteria = criteria;
		this.keyword = keyword;
		this.cold = cold;
		this.orderby = orderby;
		this.limitNumStart = limitNumStart;
		this.limitNumEnd = limitNumEnd;
		this.token = token;
		this.coldBoolean = coldBoolean;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCold() {
		return cold;
	}
	public void setCold(String cold) {
		this.cold = cold;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public Integer getLimitNumStart() {
		return limitNumStart;
	}
	public void setLimitNumStart(Integer limitNumStart) {
		this.limitNumStart = limitNumStart;
	}
	public Integer getLimitNumEnd() {
		return limitNumEnd;
	}
	public void setLimitNumEnd(Integer limitNumEnd) {
		this.limitNumEnd = limitNumEnd;
	}
	public Integer getToken() {
		return token;
	}
	public void setToken(Integer token) {
		this.token = token;
	}
	public Boolean getColdBoolean() {
		return coldBoolean;
	}
	public void setColdBoolean(Boolean coldBoolean) {
		this.coldBoolean = coldBoolean;
	}
}
