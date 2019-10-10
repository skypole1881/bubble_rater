package com.bubble.detail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bubble_score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int bubbleId;
	private double bubbleRate;
	private double bubbleRateCalculated;
	private double teaRate;
	private double teaRateCalculated;
	private double sweetnessRate;
	private String sweetnessRateCalculated;
	private double goldFeelingRate;
	private double totalRate;

}
