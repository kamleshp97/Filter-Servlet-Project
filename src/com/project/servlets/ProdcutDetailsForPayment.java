package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdcutDetailsForPayment extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("ProdcutDetailsForPayment servlet called");
		
		req.getRequestDispatcher("prodcutDetailsForPayment.jsp").forward(req, resp);
		
	}

}
