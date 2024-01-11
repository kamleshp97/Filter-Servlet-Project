package com.project.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("AuthenticationFilter destroy..");

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AuthenticationFilter Filter Called");

		String emailLogin = req.getParameter("emailLogin");
		String passwordLogin = req.getParameter("passwordLogin");
		String email = null;
		String password = null;
		System.out.println("passwordLogin = " + emailLogin + " passwordLogin = " + passwordLogin);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMAML","ORACLE");
			String query = "SELECT EMAIL, PASSWORD FROM TB_SERVLET_REGISTER WHERE EMAIL = ? AND PASSWORD = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, emailLogin);
			preparedStatement.setString(2, passwordLogin);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				email = rs.getString("EMAIL");
				password = rs.getString("PASSWORD");
			}
			System.out.println("Email = " + email + " Password = " + password);
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during login.");
		}	
		
		if(email != null && password != null){
			req.setAttribute("passedEmail", email);
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("AuthenticationFilter invoked..");

	}

}
