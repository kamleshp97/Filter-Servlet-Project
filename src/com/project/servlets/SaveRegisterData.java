package com.project.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveRegisterData extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("EMAIL = " + email + " PASSWORD = " + password);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","COMAML","ORACLE");
			String query = "INSERT INTO TB_SERVLET_REGISTER (EMAIL, PASSWORD, CREATETIONTIME) VALUES (?, ?, SYSTIMESTAMP)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();
			System.out.println("Registeration successfully done.");
			req.getRequestDispatcher("/login.html").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong during registeration.");
		}	
	}
}
