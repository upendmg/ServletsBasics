package com.zensar.add.to.cart;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingItems
 */
@WebServlet("/AddingItems")
public class AddingItems extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private Connection con=null;
 private Statement st=null;
 ResultSet rs=null;
 Statement smt=null;
 int number=0;
 int j=0;
 String str=" " ;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hi","root", "upen");
	         st=con.createStatement();
	         String[] items = request.getParameterValues("item");
			 String item=" ";
			 for(int i=0;i<items.length;i++) {
				 if(item.equals(" ")){
				  item+=items[i]+str;
				 }
				  item+=items[i]+str;
			 }
		    for(j=1;j<5;j++){
			String query="insert into getitem values('"+j+"','"+item+"');";
			number=st.executeUpdate(query);
			 
			if(number > 0){
				response.getWriter().println("RECORD INSERTED");
				rs = smt.executeQuery("select * from getitem  where id= '"+j+"'");
				while(rs.next()){
				response.getWriter().println("Selected items are "+rs.getString(1));	
				}
			
			} else {
				response.getWriter().println("RECORD INSERTION FAILED");
			}
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
