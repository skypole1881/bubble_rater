package com.bubble.util;

public enum CommonResult {
	SUCCESS(0),

	/**
	 * System Exceptions or Errors
	 **/
	BUSINESS_EXCEPTION(-1),

	/**
	 * Business Exceptions
	 **/
	ERROR(-2);

	private int code;
	private String msg;

	private CommonResult(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
