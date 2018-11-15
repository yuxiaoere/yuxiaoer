package com.accp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.accp.controller.LoginController;


public class MyInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod hm = (HandlerMethod) handler;
		if(hm.getBean() instanceof LoginController) {
			return true;
		}else {
			if(request.getSession().getAttribute("user")!=null) {
				return true;
			}else {
				System.out.println(request.getContextPath());
				response.sendRedirect(request.getContextPath()+"toLogin");
				return false;
			}
		}
	}
}
