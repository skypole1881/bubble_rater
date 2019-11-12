package com.bubble.util;

import java.beans.PropertyDescriptor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class SysUtil {
	
	public static Date getUTCDateTime() {
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));
		// Local time zone
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		// Time in GMT
		Date returnDate = new Date();
		try {
			returnDate = dateFormatLocal.parse(dateFormatGmt.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnDate;
	}
	
	public static String convertDateToISO8601String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String strDate = null;
		if (date != null) {
			strDate = sdf.format(date).toString();
		}
		return strDate == null ? "" : strDate;
	}
	
	public static String[] getNullPropertyNames(Object source) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
		List<String> nullPropertyNames = new ArrayList<>();
		for (PropertyDescriptor pd : pds) {
			String propertyName = pd.getName();
			if (beanWrapper.getPropertyValue(propertyName) == null) {
				nullPropertyNames.add(propertyName);
			}
		}
		return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
	}

}
