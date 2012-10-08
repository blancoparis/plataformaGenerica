package org.tfc.controller.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.tfc.action.utils.MenuDbpUtils;

public class MenuInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		MenuDbpUtils.establecerMenu(request);
		return super.preHandle(request, response, handler);
	}


	

	
	
}
