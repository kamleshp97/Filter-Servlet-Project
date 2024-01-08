package com.project.servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MainPage extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Main page called after successful LOGIN");
		HttpSession session = req.getSession();
		boolean isLoginPass = (boolean) session.getAttribute("isLoginPass");
		if(isLoginPass)
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
