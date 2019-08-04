package com.bubble.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bubble.enums.ErrorMessageEnum;
import com.bubble.exception.BusinessException;

@SuppressWarnings("rawtypes")
public class CommonResultMap extends HashMap implements Map {

	private static final long serialVersionUID = -3469936673137441995L;
	private static String STATUS = "STATUS";
	private static String MSG = "MSG";

	public CommonResultMap() {
		this.setResult(CommonResult.BUSINESS_EXCEPTION);
		this.setMessage("");
	}

	@SuppressWarnings("unchecked")
	public void setResult(CommonResult result) {
		this.put(STATUS, result.getCode());
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public void setResult(CommonResult result, String message) {

		if (message != null && message.indexOf("Unknown database") > -1) {
			String database = message.substring(message.lastIndexOf("Unknown database") + 17);
			setResult(new BusinessException(ErrorMessageEnum.Database_Unknown_Database, database));
		} else {
			this.put(STATUS, result.getCode());
			this.setMessage(message);
			if (message == null && result.getCode() != CommonResult.SUCCESS.getCode()) {
				// result is error and message not set.
				this.setMessage("UNKNOWN ERROR");
			}
			if (result.getCode() == CommonResult.ERROR.getCode()) {
				LoggerFactory.getLogger(CommonResultMap.class).error(message);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void setResult(BusinessException e) {
		this.put(STATUS, e.getErrorCode());

		String message = e.getMessage();
		if (e.getParam() != null) {
			message = String.format(message, e.getParam());
		}

		this.setMessage(message);
		if (message == null) {
			// result is error and message not set.
			this.setMessage("UNKNOWN ERROR");
		}
		if (e.getErrorCode() != null) {
			LoggerFactory.getLogger(CommonResultMap.class).error(message);
		}
	}

	public void addToResultList(CommonResult result, String message) {
		if (result != CommonResult.SUCCESS) {
			this.setResult(result);
		}
		String msg = this.getMessage();
		if (msg == null) {
			msg = "";
		}
		msg += result.name() + ":" + message + " \r\n<br/>";
		this.setMessage(msg);
	}

	public Integer getStatus() {
		return (Integer) this.get(STATUS);
	}

	public boolean succeed() {
		boolean result = false;
		if (this.getStatus().equals(CommonResult.SUCCESS.getCode())) {
			result = true;
		}
		return result;
	}

	public Object getData() {
		return this.get("DATA");
	}

	@SuppressWarnings("unchecked")
	public void setData(Object obj) {
		if (obj == null || (obj instanceof List && ((List) obj).size() == 0)) {
			this.setMessage("empty");
		}
		this.put("DATA", obj);
		this.setResult(CommonResult.SUCCESS);
	}

	public Integer getIntData() {
		Object data = this.getData();
		if (data != null && data instanceof Number) {
			return Integer.parseInt(data.toString());
		} else {
			return null;
		}
	}

	public Float getFloatData() {
		Object data = this.getData();
		if (data != null && data instanceof Number) {
			return Float.parseFloat(data + "");
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public void setResultCount(int count) {
		this.put("COUNT", count);
	}

	@SuppressWarnings("unchecked")
	public void setResultTotalCount(Integer count) {
		this.put("TOTAL_COUNT", count);
	}

	@SuppressWarnings("unchecked")
	public void setResultSize(int size) {
		this.put("size", size);
	}

	public String getMessage() {
		String msg = (String) this.get("msg");
		return msg;
	}

	@SuppressWarnings("unchecked")
	public void setMessage(String message) {
		this.put(MSG, message);
	}

	@SuppressWarnings("unchecked")
	public void setLoginPage(String loginPage) {
		this.put("LoginPage", loginPage);
	}

	@SuppressWarnings("unchecked")
	public void setContext(Object obj) {
		this.put("context", obj);
	}

	@SuppressWarnings("unchecked")
	public void setUserId(Integer userId) {
		this.put("USER_ID", userId);
	}

	@SuppressWarnings("unchecked")
	public void setToken(String token) {
		this.put("token", token);
	}

	@SuppressWarnings("unchecked")
	public void setUserName(String userName) {
		this.put("USER_NAME", userName);
	}

	@SuppressWarnings("unchecked")
	public void setOrgId(String orgId) {
		this.put("ORG_ID", orgId);
	}

	@SuppressWarnings("unchecked")
	public void setCompany_ID(String companyId) {
		this.put("Company_ID", companyId);
	}

//	@SuppressWarnings("unchecked")
//	public void setUserRoles(List<Role> userRoles) {
//		this.put("userRoles", userRoles);
//	}

	@SuppressWarnings("unchecked")
	public void putTemporaryEntry(String key, Object object) {
		this.put(key, object);
	}
}
