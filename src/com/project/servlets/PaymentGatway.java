package com.project.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleTypes;

public class PaymentGatway extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("CheckoutProduct servlet called");
		
		String productId = req.getParameter("productId");
		String productPrice = req.getParameter("productPrice");
		String actionType = req.getParameter("actionType");
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("EMAIL");
		List<Map<String, String>> list = new LinkedList<Map<String,String>>();
		
		req.setAttribute("productId", productId);
		req.setAttribute("productPrice", productPrice);
		
		if(actionType != null && actionType.equals("Remove")){
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "COMAML", "ORACLE");
				String query = "DELETE FROM TB_PRODCUT_IN_BASKET WHERE EMAIL = ? AND PRODUCTID = ?";
				PreparedStatement prepareStatement = con.prepareStatement(query);
				prepareStatement.setString(1, email);
				prepareStatement.setString(2, productId);
				prepareStatement.executeUpdate();
				
				
				
				
				CallableStatement callableStatement = con.prepareCall("{CALL STP_GET_BASKETDETAILS(?,?)}");
				callableStatement.setString(1, email);
				callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
				callableStatement.execute();
				ResultSet rs = (ResultSet) callableStatement.getObject(2);
				while(rs.next()){
					Map<String, String> map = new LinkedHashMap<String, String>();
					map.put("EMAIL", rs.getString("EMAIL"));
					map.put("PRODUCTID", rs.getString("PRODUCTID"));
					map.put("PRODUCTRITLE", rs.getString("PRODUCTRITLE"));
					map.put("PRODUCTPRICE", rs.getString("PRODUCTPRICE"));
					map.put("PRODUCTIMAGEURL", rs.getString("PRODUCTIMAGEURL"));
					map.put("PRODUCTCATG", rs.getString("PRODUCTCATG"));
					list.add(map);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something went wrong during removing product from basket.");
				e.printStackTrace();
			}
			System.out.println("PRODUCTS IN BASKET = " + list);
			req.setAttribute("PRODUCTS", list);
			req.getRequestDispatcher("/prodcutMoveToTray.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("/paymentGatway.jsp").forward(req, resp);
		}
		
	}

}
