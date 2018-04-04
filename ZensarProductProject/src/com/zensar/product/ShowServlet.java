package com.zensar.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private Statement smt = null;
	ResultSet rs = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			smt = con.createStatement();
			rs = smt.executeQuery("select * from product");
			response.getWriter().println("<table>");
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>Product Id</td>");
			response.getWriter().println("<td>Product Name</td>");
			response.getWriter().println("<td>Product Cost</td>");
			response.getWriter().println("</tr>");
			while (rs.next()) {
				response.getWriter().println("<tr>");
				response.getWriter().println("<td>" + rs.getInt(1) + "</td>");
				response.getWriter().println("<td>" + rs.getString(2) + "</td>");
				response.getWriter().println("<td>" + rs.getInt(3) + "</td>");
				response.getWriter().println("<td><input type='submit' value='DELETE ITEM'/></td>");
				response.getWriter().println("<td><input type='submit' value='UPDATE ITEM'/></td>");
				response.getWriter().println("</tr>");
				response.getWriter().println("<tr>");
				response.getWriter().println("</tr>");
			}
			response.getWriter().println("</table>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
