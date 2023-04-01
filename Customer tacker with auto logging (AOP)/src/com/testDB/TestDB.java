package com.testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//setup connection variables
		String user = "kaushik";
		String password = "kaushik";
		String uri = "jdbc:mysql://localhost:3306/customer_relationship?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//connect to DB
		try {
			PrintWriter out = response.getWriter();
			
			out.println("connecting to the database ok\n\n" + uri);
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(uri, user, password); 
			
			out.println("Connection successful");
			
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServerException("Error occured connecting to database");
		}
	}

}
