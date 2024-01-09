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

public class Payment extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		String cardHolderName = req.getParameter("cardHolderName");
		String cardCategory = req.getParameter("category");
		String credential = req.getParameter("credential");
		String productId = req.getParameter("productId");
		long productPrice = Long.parseLong(req.getParameter("productPrice"));
		long balanceAmount = 0;
		boolean status = false;
		
		System.out.println("credential = " + credential + " productPrice = " + productPrice + " productId = " + productId);
		
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMAML","ORACLE");
			String query = "SELECT AMOUNT FROM TB_ABC_BANK WHERE CARDNUMBER = ?";
			PreparedStatement prepareStatement = con.prepareStatement(query);
			prepareStatement.setString(1, credential);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()){
				System.out.println("actual balance = " + rs.getString("AMOUNT"));
				//balanceAmount = Long.parseLong(rs.getString("AMOUNT"));
			}
			if(balanceAmount > 0)
				status = true;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during fetching data from bank server.");
			System.out.println(e);
			status = false;
			e.printStackTrace();
		}

		System.out.println("BALANCE AMOUNT = " + balanceAmount);
		System.out.println("status = " + status);
	
		if(balanceAmount == 0){
			System.out.println("Something went wrong, unable to fetch account from bank server.");
		}
		if(balanceAmount < 0){
			System.out.println("Payment failed due to low balance.");
		}
		
		if(productPrice >= balanceAmount && status){
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "COMAML", "ORACLE");
				String totalBalance = String.valueOf(balanceAmount - productPrice);
				String query1 = "UPDATE TB_ABC_BANK SET AMOUNT = ? WHERE CARDNUMBER = ?";
				PreparedStatement prepareStatement1 = con.prepareStatement(query1);
				prepareStatement1.setString(1, totalBalance);
				prepareStatement1.setString(2, credential);
				prepareStatement1.executeUpdate();
				
				int stock = 0;
				String query3 = "SELECT PRODUCTQUANT FROM TB_SERVLET_PRODUCTS WHERE PRODUCTID = ?";
				PreparedStatement prepareStatement3 = con.prepareStatement(query3);
				prepareStatement3.setString(1, productId);
				ResultSet rs3 = prepareStatement3.executeQuery();
				while(rs3.next()){
					stock = Integer.parseInt(rs3.getString("PRODUCTQUANT"));
				}
				
				stock = stock - 1;
				
				String query2 = "UPDATE TB_SERVLET_PRODUCTS SET PRODUCTQUANT = ? WHERE PRODUCTID = ?";
				PreparedStatement prepareStatement2 = con.prepareStatement(query2);
				prepareStatement2.setString(1, String.valueOf(stock));
				prepareStatement2.setString(2, productId);
				prepareStatement2.executeUpdate();
				
				System.out.println("Your payment received successfully.");
				System.out.println("Your order is placed.");
				req.getRequestDispatcher("/OrderSuccess.jsp").forward(req, resp);
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something went wrong, during processing your payment.");
				e.printStackTrace();
			}

		}
		else{
			System.out.println("Payment failed due to low balance.");
			req.getRequestDispatcher("/OrderFailure.jsp").forward(req, resp);
		}
		
		
	}

}
