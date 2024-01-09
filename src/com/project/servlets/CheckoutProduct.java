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

public class CheckoutProduct extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("CheckoutProduct servlet called");
		
		String productId = req.getParameter("productId");
		String actionType = req.getParameter("actionType");
		
		Map<String, String> map = new LinkedHashMap<>();
		
		
		
		if(actionType.equals("Buy")){
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "COMAML", "ORACLE");
				String query = "SELECT PRODUCTID, PRODUCTRITLE, PRODUCTPRICE, "
						+ "PRODUCTDESC, PRODUCTQUANT, PRODUCTIMAGEURL, PRODUCTCATG, ADDING_TIME "
						+ "FROM TB_SERVLET_PRODUCTS WHERE PRODUCTID = ?";
				PreparedStatement prepareStatement = con.prepareStatement(query);
				prepareStatement.setString(1, productId);
				ResultSet rs = prepareStatement.executeQuery();
				while(rs.next()){
					map.put("PRODUCTID", rs.getString("PRODUCTID"));
					map.put("PRODUCTRITLE", rs.getString("PRODUCTRITLE"));
					map.put("PRODUCTPRICE", rs.getString("PRODUCTPRICE"));
					map.put("PRODUCTDESC", rs.getString("PRODUCTDESC"));
					map.put("PRODUCTQUANT", rs.getString("PRODUCTQUANT"));
					map.put("PRODUCTIMAGEURL", rs.getString("PRODUCTIMAGEURL"));
					map.put("PRODUCTCATG", rs.getString("PRODUCTCATG"));
				}
				System.out.println("Product fetched successfully from databse.");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something went wrong during product fetching from databse.");
				System.out.println(e);
			}
			req.setAttribute("PRODUCT", map);
			req.getRequestDispatcher("/prodcutDetailsForPayment.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("ProdcutMoveToTray").forward(req, resp);
		}
	}

}
