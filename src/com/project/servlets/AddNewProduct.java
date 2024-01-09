package com.project.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
					maxFileSize = 1024 * 1024 * 5,   // 5 MB
					maxRequestSize = 1024 * 1024 * 10) // 10 MB
public class AddNewProduct extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("addNewProduct servelet called");
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");
		Part filePart = req.getPart("image");
		filePart.getName().getBytes();
	
		System.out.println(category + " " + title + " " + description + " " + price + " " + quantity + " "  );
		
		String imageURL = null;
		
		if(category.equals("Apple"))
			imageURL = "https://logowik.com/content/uploads/images/apple8110.logowik.com.webp";
		else if(category.equals("Samsung"))
			imageURL = "https://seeklogo.com/images/S/samsung-logo-4BA7D9F6D7-seeklogo.com.png?v=638252008540000000";
		else
			imageURL = "https://play-lh.googleusercontent.com/AzUHe1S5W-Z-3FRpqCC2BIDGHnS05mpoaDx3KhEWXy40GlFcg25kpGwtxc3_WpbJkLj2";
		
		Random id = new Random();
		int nextInt = id.nextInt(999999);
		String productId = String.format("%06d", nextInt);
		System.out.println("productId = " + productId);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "COMAML", "ORACLE");
			String query = "INSERT INTO  TB_SERVLET_PRODUCTS "
					+ "(PRODUCTID, PRODUCTRITLE, PRODUCTPRICE, PRODUCTDESC, PRODUCTQUANT, PRODUCTIMAGEURL, PRODUCTCATG, ADDING_TIME) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, SYSTIMESTAMP)";
			PreparedStatement prepareStatement = con.prepareStatement(query);
			prepareStatement.setString(1, productId);
			prepareStatement.setString(2, title);
			prepareStatement.setString(3, price);
			prepareStatement.setString(4, description);
			prepareStatement.setString(5, quantity);
			prepareStatement.setString(6, imageURL);
			prepareStatement.setString(7, category);
			
			prepareStatement.executeUpdate();
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
			
			System.out.println("Product Added Successfully");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			req.getRequestDispatcher("/newProduct.jsp").forward(req, resp);
			System.out.println("Something went wrong during adding product into database.");
		}
		
		
	}

}
