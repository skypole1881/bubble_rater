package com.bubble.Interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BubbletagInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String sId = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + " : " + cookie.getValue());
				if (cookie.getName().equals("bubbletag")) {
					sId = cookie.getValue();
				}
			}
		}
		if (sId == null || sId.trim() == "") {
			sId = request.getSession().getId();
		}
		System.out.println("sId====="+sId);
		request.getSession().setAttribute("bubbletag", sId);
		Cookie cookie = new Cookie("bubbletag", sId);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 365 * 5);
		cookie.setHttpOnly(false);
		response.addCookie(cookie);
		return true;
	}
}
