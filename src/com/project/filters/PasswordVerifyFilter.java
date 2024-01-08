package com.project.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PasswordVerifyFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("Password verify filter destroyed");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String password = req.getParameter("password");
		int length = password.length();
		if(length >= 6){
			System.out.println("Password is accurate for submission.");
			chain.doFilter(req, resp);
		}
		else{
			System.out.println("Password is not accurate for submission.");
			req.getRequestDispatcher("/register.html").forward(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Password verify filter invoked");
		
	}

}
