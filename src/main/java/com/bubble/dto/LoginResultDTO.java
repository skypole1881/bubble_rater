package com.bubble.dto;

public class LoginResultDTO {
	private String token;

	private Integer userId;

	private String userName;

	private String userFirstName;

	private String userLastName;

	private String orgId;

	private String companyId;

	private String defaultLocale;

	private boolean startUpHelpEnabled;
//
//	    private List<Role> userRoles;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}

	public boolean isStartUpHelpEnabled() {
		return startUpHelpEnabled;
	}

	public void setStartUpHelpEnabled(boolean startUpHelpEnabled) {
		this.startUpHelpEnabled = startUpHelpEnabled;
	}

//	    public List<Role> getUserRoles() {
//	        return userRoles;
//	    }
//
//	    public void setUserRoles(List<Role> userRoles) {
//	        this.userRoles = userRoles;
//	    }
}
