package com.zensar.product;

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

/**
 * Servlet implementation class DeleteItemServlet
 */
public class DeleteItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private Statement st = null;
    private int count=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  prodId=Integer.parseInt(request.getParameter("txtid"));
		String prodName=request.getParameter("txtname");
		int  prodCost=Integer.parseInt(request.getParameter("txtcost"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
			st=con.createStatement();
			String query="delete from  product where product Name='+prodName+'";
			count=st.executeUpdate(query);
			
			 response.getWriter().println("<html>");
			 response.getWriter().println("<body>");
			 if(count>0){
				 response.getWriter().println("<h1>ITEM DELETED SUCCESSFULLY FROM THE LIST</h1>");
				  response.getWriter().println("<a href='http://localhost:8080/ZensarProductProject/index.html'>BACK</a>");
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
