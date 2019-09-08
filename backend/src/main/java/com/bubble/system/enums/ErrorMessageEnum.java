package com.bubble.system.enums;

public enum ErrorMessageEnum {
	Auth_User_Has_No_Access("00001", "You can't access, the resources are not belonging to your corporate"),
	Database_Unknown_Database("00002", "The database [%s] is not exist!"),
	User_Is_Exist("00003", "User is exist!")
	;
	
	private String code;
	private String desc;

	private ErrorMessageEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
