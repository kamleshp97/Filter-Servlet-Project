package com.project.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheck extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginCheck Servlet Called");
		
		String email = (String) req.getAttribute("passedEmail");
		System.out.println("passedEmail = " + email);
		
		req.setAttribute("passedEmail", email);
		HttpSession session = req.getSession();
		session.setAttribute("EMAIL", email);
		session.setAttribute("isLoginPass", true);
		
		if(email.equals("admin@kp.com")){
			req.getRequestDispatcher("/admin.jsp").forward(req, resp);
		}
		else if(email.contains("@kp.com")){
			req.getRequestDispatcher("mainPage").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("mainPage").forward(req, resp);
		}
	}
	
}
