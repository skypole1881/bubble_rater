package com.bubble.detail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bubble_score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="score_id")
	private Integer id;
	@Column(name = "raw_bubblerate")
	private double rawBubbleRate;
	@Column(name = "bubble_rate")
	private double bubbleRate;
	@Column(name = "raw_tearate")
	private double rawTeaRate;
	@Column(name = "teaRate")
	private double teaRate;
	@Column(name = "sweetnessRate")
	private double sweetnessRate;
	@Column(name = "sweetness")
	private String sweetness;
	@Column(name = "godfeeling_rate")
	private double godFeelingRate;
	@Column(name = "total_rate")
	private double totalRate;

	public Score() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getRawBubbleRate() {
		return rawBubbleRate;
	}

	public void setRawBubbleRate(double rawBubbleRate) {
		this.rawBubbleRate = rawBubbleRate;
	}

	public double getBubbleRate() {
		return bubbleRate;
	}

	public void setBubbleRate(double bubbleRate) {
		this.bubbleRate = bubbleRate;
	}

	public double getRawTeaRate() {
		return rawTeaRate;
	}

	public void setRawTeaRate(double rawTeaRate) {
		this.rawTeaRate = rawTeaRate;
	}

	public double getTeaRate() {
		return teaRate;
	}

	public void setTeaRate(double teaRate) {
		this.teaRate = teaRate;
	}

	public double getSweetnessRate() {
		return sweetnessRate;
	}

	public void setSweetnessRate(double sweetnessRate) {
		this.sweetnessRate = sweetnessRate;
	}

	public String getSweetness() {
		return sweetness;
	}

	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}

	public double getGodFeelingRate() {
		return godFeelingRate;
	}

	public void setGodFeelingRate(double godFeelingRate) {
		this.godFeelingRate = godFeelingRate;
	}

	public double getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(double totalRate) {
		this.totalRate = totalRate;
	}

}
