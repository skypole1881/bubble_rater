package com.bubble.util;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@MappedSuperclass
@DynamicUpdate
public class BasePojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dtm")
	private Date createdDtm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modifieddtm")
	private Date lastModifedDTM;

//	@Where(clause="deleted=1")
	private Boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDtm() {
		return createdDtm;
	}

	public void setCreatedDtm(Date createdDtm) {
		this.createdDtm = createdDtm;
	}

	public Date getLastModifedDTM() {
		return lastModifedDTM;
	}

	public void setLastModifedDTM(Date lastModifedDTM) {
		this.lastModifedDTM = lastModifedDTM;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void updateCommonInfo() {

		Timestamp now = new Timestamp(new Date().getTime());
//		now = new Timestamp(SysUtil.getUTCDateTime().getTime());
//		LocalDateTime localDateTime = LocalDateTime.now();
		if (this.getId() == 0) { // New PoJo
			if (this.getCreatedDtm() == null) {
				this.setCreatedDtm(now);
			}
			this.setLastModifedDTM(now);
			this.setDeleted(false);
		} else { // Update this
			this.setLastModifedDTM(now);
		}
	}

}
