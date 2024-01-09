package com.project.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentGatway extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("CheckoutProduct servlet called");
		
		String productId = req.getParameter("productId");
		String productPrice = req.getParameter("productPrice");
		
		req.setAttribute("productId", productId);
		req.setAttribute("productPrice", productPrice);
		req.getRequestDispatcher("/paymentGatway.jsp").forward(req, resp);
		
	}

}
