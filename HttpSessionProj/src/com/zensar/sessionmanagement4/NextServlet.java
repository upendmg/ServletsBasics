package com.zensar.sessionmanagement4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NextServlet
 */
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		HttpSession session=request.getSession(true);
		System.out.println(session.getId());
		String username=(String) session.getAttribute("username");
		String password=(String) session.getAttribute("password");
		response.getWriter().println("username is"+username);
		response.getWriter().println("password is"+password);
	}

}
