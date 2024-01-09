package com.project.servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MainPage extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Main page called after successful LOGIN");
		HttpSession session = req.getSession();
		boolean isLoginPass = (boolean) session.getAttribute("isLoginPass");
		List<Map<String, String>> list = new LinkedList<>();
		if(isLoginPass){
			
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "COMAML", "ORACLE");
				String query = "SELECT PRODUCTID, PRODUCTRITLE, PRODUCTPRICE, PRODUCTDESC, "
						+ "PRODUCTQUANT, PRODUCTIMAGEURL, PRODUCTCATG, ADDING_TIME "
						+ "FROM "
						+ "TB_SERVLET_PRODUCTS "
						+ "WHERE ROWNUM < 11 "
						+ "ORDER BY ADDING_TIME";
				PreparedStatement prepareStatement = con.prepareStatement(query);
				ResultSet rs = prepareStatement.executeQuery();
				
				while(rs.next()){
					Map<String, String> map = new HashMap<String, String>();
					map.put("PRODUCTID", rs.getString("PRODUCTID"));
					map.put("PRODUCTRITLE", rs.getString("PRODUCTRITLE"));
					map.put("PRODUCTPRICE", rs.getString("PRODUCTPRICE"));
					map.put("PRODUCTQUANT", rs.getString("PRODUCTQUANT"));
					map.put("PRODUCTIMAGEURL", rs.getString("PRODUCTIMAGEURL"));
					map.put("PRODUCTCATG", rs.getString("PRODUCTCATG"));
					map.put("ADDING_TIME", rs.getString("ADDING_TIME"));
					map.put("PRODUCTDESC", rs.getString("PRODUCTDESC"));
					list.add(map);
					
				}
				System.out.println("Products fetched successfully from database.");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Something went wrong during product fetching from database.");
				System.out.println(e);
			}
			
			req.setAttribute("PRODUCTS", list);
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
			System.out.println("list = " + list);
			
		}
		else
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Map<String, String>> list = new LinkedList<>();

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "COMAML", "ORACLE");
			String query = "SELECT PRODUCTID, PRODUCTRITLE, PRODUCTPRICE, PRODUCTDESC, "
					+ "PRODUCTQUANT, PRODUCTIMAGEURL, PRODUCTCATG, ADDING_TIME "
					+ "FROM "
					+ "TB_SERVLET_PRODUCTS "
					+ "WHERE ROWNUM < 11 "
					+ "ORDER BY ADDING_TIME";
			PreparedStatement prepareStatement = con.prepareStatement(query);
			ResultSet rs = prepareStatement.executeQuery();
			
			while(rs.next()){
				Map<String, String> map = new HashMap<String, String>();
				map.put("PRODUCTID", rs.getString("PRODUCTID"));
				map.put("PRODUCTRITLE", rs.getString("PRODUCTRITLE"));
				map.put("PRODUCTPRICE", rs.getString("PRODUCTPRICE"));
				map.put("PRODUCTQUANT", rs.getString("PRODUCTQUANT"));
				map.put("PRODUCTIMAGEURL", rs.getString("PRODUCTIMAGEURL"));
				map.put("PRODUCTCATG", rs.getString("PRODUCTCATG"));
				map.put("ADDING_TIME", rs.getString("ADDING_TIME"));
				map.put("PRODUCTDESC", rs.getString("PRODUCTDESC"));
				list.add(map);
				
			}
			System.out.println("Products fetched successfully from database.");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during product fetching from database.");
			System.out.println(e);
		}
		req.setAttribute("PRODUCTS", list);
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
		System.out.println("list = " + list);
	}

}
