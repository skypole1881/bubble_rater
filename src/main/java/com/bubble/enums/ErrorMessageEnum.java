package com.bubble.enums;

public enum ErrorMessageEnum {
	Auth_User_Has_No_Access("0010101", "You can't access, the resources are not belonging to your corporate"),
	Database_Unknown_Database("9020101", "The database [%s] is not exist!")
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
