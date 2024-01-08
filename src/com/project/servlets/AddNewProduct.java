package com.project.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

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
		
	;
		System.out.println(category + " " + title + " " + description + " " + price + " " + quantity + " "  );
	}

}
