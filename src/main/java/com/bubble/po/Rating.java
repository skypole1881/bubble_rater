package com.bubble.po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
public class Rating {
	@Id
	@GeneratedValue
	private Integer rId;
	private Integer blogId;
	private String storeBrand;
	private String cusBubbletag;
	private Date cusRateDtm;
	private Double cusRate;
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getStoreBrand() {
		return storeBrand;
	}
	public void setStoreBrand(String storeBrand) {
		this.storeBrand = storeBrand;
	}
	public String getCusBubbletag() {
		return cusBubbletag;
	}
	public void setCusBubbletag(String cusBubbletag) {
		this.cusBubbletag = cusBubbletag;
	}
	public Date getCusRateDtm() {
		return cusRateDtm;
	}
	public void setCusRateDtm(Date cusRateDtm) {
		this.cusRateDtm = cusRateDtm;
	}
	public Double getCusRate() {
		return cusRate;
	}
	public void setCusRate(Double cusRate) {
		this.cusRate = cusRate;
	}
}
