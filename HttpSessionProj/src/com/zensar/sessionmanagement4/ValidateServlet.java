package com.zensar.sessionmanagement4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateServlet
 */
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String username=null;
	    private String password=null;
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		/*HttpSession session1=request.getSession(false);
		HttpSession session2=request.getSession();*/
		response.getWriter().print("Session id is "+session.getId());
	/*	response.getWriter().println("Session id is "+session1.getId());
		response.getWriter().println("Session id is "+session2.getId());*/
		username = request.getParameter("username");
		password = request.getParameter("password");
		session.setAttribute("username", username);
		session.setAttribute("password", password);
	/*	session.setMaxInactiveInterval(30*60);
		session.invalidate();*/
		response.setContentType("text/html");
		response.getWriter().println("<h1>This is First Server</h1>");
		response.getWriter().println("<html>");
		response.getWriter().println("<body>");
		response.getWriter().println("<form  method='post' action='NextServlet'>");
		//response.getWriter().println("<input type='hidden' name='hiddentxt' value=" + username + "/>");
		response.getWriter().println("<input type='submit' name='btnsubmit' value='submit'/>");
		response.getWriter().println("</form>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	
	}

}
