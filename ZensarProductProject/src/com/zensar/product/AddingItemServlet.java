package com.zensar.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddingItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;
	private int count = 0;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("txtid"));
		String prodName = request.getParameter("txtname");
		int prodCost = Integer.parseInt(request.getParameter("txtcost"));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "upen");
			ps = con.prepareStatement("insert into product values(? ,? ,?)");
			ps.setInt(1, prodId);
			ps.setString(2, prodName);
			ps.setInt(3, prodCost);

			count = ps.executeUpdate();
			response.getWriter().println("<html>");
			response.getWriter().println("<body>");
			if (count > 0) {
				response.getWriter().println("<h1>ITEM ADDED IN THE LIST</h1>");
			}

			rs = ps.executeQuery("select * from product");

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
			response.getWriter().println("<form method='post' action='update.html'>");

			response.getWriter().println("</form>");
			response.getWriter().println("<form method='post' action='delete.html'>");

			response.getWriter().println("</form>");
			response.getWriter().println("</body>");
			response.getWriter().println("</html>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
