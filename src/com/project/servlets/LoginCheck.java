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

		String email = req.getParameter("emailLogin");
		String password = req.getParameter("passwordLogin");
		String getEmail = null;
		String getPassword = null;
		System.out.println("EMAIL = " + email + " PASSWORD = " + password);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMAML","ORACLE");
			String query = "SELECT EMAIL, PASSWORD FROM TB_SERVLET_REGISTER WHERE EMAIL =? AND PASSWORD  =?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				getEmail = rs.getString("EMAIL");
				getPassword = rs.getString("PASSWORD");
			}
			
			if(getEmail != null && getPassword != null){
				System.out.println("Successful Login.");
				HttpSession session = req.getSession();
				session.setAttribute("EMAIL", getEmail);
				session.setAttribute("isLoginPass", true);
				req.getRequestDispatcher("mainPage").forward(req, resp);
			}
			else{
				System.out.println("Login Failed.");
				req.getRequestDispatcher("/login.html").forward(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during login.");
		}	
	}
	
}
