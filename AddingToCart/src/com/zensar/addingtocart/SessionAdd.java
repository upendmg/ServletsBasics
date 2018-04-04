package com.zensar.addingtocart;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionAdd
 */
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int number=0;
	 String str=" " ;
	 ResultSet rs=null;
	 Statement smt=null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList al=new ArrayList();
		
	    String[] items = request.getParameterValues("item");
	    String item=" ";
		 for(int i=0;i<items.length;i++) {
			 if(item.equals(" ")){
			  item+=items[i]+str;
			 }
			  item+=items[i]+str;
		   }
			
		 
			response.setContentType("text/html");
			response.getWriter().println("<h1>Welcome to Book Shop</h1>");
			response.getWriter().println("<html>");
			response.getWriter().println("<body>");
			response.getWriter().println("<form  method='post' action='SessionChoose'>");
			response.getWriter().println("<input type='submit' name='btnsubmit' value='submit'/>");
			response.getWriter().println("</form>");
			response.getWriter().println("</body>");
			response.getWriter().println("</html>");
	}

}
