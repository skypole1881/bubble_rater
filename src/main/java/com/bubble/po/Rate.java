package com.bubble.po;

import java.util.Date;

public class Rate {

	private int rateId;
	private float sweetness;
	private float bubbleElasticity;
	private float teaConcentration;
	private float godfeeling;
	private int version;
	private Date createdDtm;
	private Date lastModifiedDtm;
	private int deleted;

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public float getSweetness() {
		return sweetness;
	}

	public void setSweetness(float sweetness) {
		this.sweetness = sweetness;
	}

	public float getBubbleElasticity() {
		return bubbleElasticity;
	}

	public void setBubbleElasticity(float bubbleElasticity) {
		this.bubbleElasticity = bubbleElasticity;
	}

	public float getTeaConcentration() {
		return teaConcentration;
	}

	public void setTeaConcentration(float teaConcentration) {
		this.teaConcentration = teaConcentration;
	}

	public float getGodfeeling() {
		return godfeeling;
	}

	public void setGodfeeling(float godfeeling) {
		this.godfeeling = godfeeling;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getCreatedDtm() {
		return createdDtm;
	}

	public void setCreatedDtm(Date createdDtm) {
		this.createdDtm = createdDtm;
	}

	public Date getLastModifiedDtm() {
		return lastModifiedDtm;
	}

	public void setLastModifiedDtm(Date lastModifiedDtm) {
		this.lastModifiedDtm = lastModifiedDtm;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}
