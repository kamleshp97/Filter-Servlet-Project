package com.project.servlets;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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
import oracle.jdbc.oracore.OracleType;

public class ProdcutMoveToTray extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("ProdcutMoveToTray servlet called");
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("EMAIL");
		List<Map<String, String>> list = new LinkedList<Map<String,String>>();
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "COMAML", "ORACLE");
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
			System.out.println("PRODUCTS IN BASKET = " + list);
			req.setAttribute("PRODUCTS", list);
			req.getRequestDispatcher("prodcutMoveToTray.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during fetching data from database for basket.");
			e.printStackTrace();
		}
		
		
		
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("ProdcutMoveToTray servlet called");
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("EMAIL");
		List<Map<String, String>> list = new LinkedList<Map<String,String>>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "COMAML", "ORACLE");
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
			System.out.println("PRODUCTS IN BASKET = " + list);
			req.setAttribute("PRODUCTS", list);
			req.getRequestDispatcher("prodcutMoveToTray.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during fetching data from database for basket.");
			e.printStackTrace();
		}
	
	}

}
