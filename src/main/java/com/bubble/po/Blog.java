package com.bubble.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "bubble_blog")
public class Blog {
	@Id
	@GeneratedValue
	@Column(name = "blog_id")
	private Integer blogId;
	@Column(name = "title")
	private String title;
	@Column(name = "store_city")
	private String storeCity;
	@Column(name = "store_district")
	private String storeDistrict;
	@Column(name = "store_brand")
	private String storeBrand;
	@Column(name = "store_address")
	private String storeAddress;
	@Column(name = "content")
	private String content1;
	@Column(name = "item")
	private String item;
	@Column(name = "photo_link")
	private String photoLink;
	@Column(name = "cold")
	private boolean cold;
	@Column(name = "bubble_rate")
	private float bubbleRate;
	@Column(name = "bubble_rate_PR")
	private float bubbleRatePR;
	@Column(name = "tea_rate")
	private float teaRate;
	@Column(name = "tea_rate_PR")
	private float teaRatePR;
	@Column(name = "sweetness_rate")
	private float sweetnessRate;
	@Column(name = "sweetness")
	private String sweetness;
	@Column(name = "godfeeling_rate")
	private float godfeelingRate;
	@Column(name = "user_rate")
	private float userRate;
	@Column(name = "total_rate")
	private float totalRate;
	@Column(name = "latest")
	private boolean latest;
	@Column(name = "publish")
	private boolean publish;
	@Column(name = "likes")
	private int likes;
	@Column(name = "views")
	private int views;
	@Column(name = "version")
	private int version;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dtm")
	private Date createdDtm;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_dtm")
	private Date lastModifiedDtm;
	@Column(name = "deleted")
	private int deleted;

	public Blog() {

	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}

	public String getStoreDistrict() {
		return storeDistrict;
	}

	public void setStoreDistrict(String storeDistrict) {
		this.storeDistrict = storeDistrict;
	}

	public String getStoreBrand() {
		return storeBrand;
	}

	public void setStoreBrand(String storeBrand) {
		this.storeBrand = storeBrand;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public boolean isCold() {
		return cold;
	}

	public void setCold(boolean cold) {
		this.cold = cold;
	}

	public float getBubbleRate() {
		return bubbleRate;
	}

	public void setBubbleRate(float bubbleRate) {
		this.bubbleRate = bubbleRate;
	}

	public float getBubbleRatePR() {
		return bubbleRatePR;
	}

	public void setBubbleRatePR(float bubbleRatePR) {
		this.bubbleRatePR = bubbleRatePR;
	}

	public float getTeaRate() {
		return teaRate;
	}

	public void setTeaRate(float teaRate) {
		this.teaRate = teaRate;
	}

	public float getTeaRatePR() {
		return teaRatePR;
	}

	public void setTeaRatePR(float teaRatePR) {
		this.teaRatePR = teaRatePR;
	}

	public float getSweetnessRate() {
		return sweetnessRate;
	}

	public void setSweetnessRate(float sweetnessRate) {
		this.sweetnessRate = sweetnessRate;
	}

	public String getSweetness() {
		return sweetness;
	}

	public void setSweetness(String sweetness) {
		this.sweetness = sweetness;
	}

	public float getGodfeelingRate() {
		return godfeelingRate;
	}

	public void setGodfeelingRate(float godfeelingRate) {
		this.godfeelingRate = godfeelingRate;
	}

	public float getUserRate() {
		return userRate;
	}

	public void setUserRate(float userRate) {
		this.userRate = userRate;
	}

	public float getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(float totalRate) {
		this.totalRate = totalRate;
	}

	public boolean isLatest() {
		return latest;
	}

	public void setLatest(boolean latest) {
		this.latest = latest;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
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
