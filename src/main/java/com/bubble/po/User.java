package com.bubble.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bubble_user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	@Column(name="user_name")
	private String username;
	@Column(name="user_password")
	private String password;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="admin")
	private boolean admin;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String userpassword) {
		this.password = userpassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
