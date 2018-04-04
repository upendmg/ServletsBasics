<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" >
<form name="frm" method="post" action="AddingItems">
<h1> MY BOOK STORE </h1>
<%! int count=0; 
%>
<h2> You have <%=count %> items in your cart</h2>

<%!
private  Connection con=null;
private Statement  smt=null;
private ResultSet rs=null;
String bookname=null;
%>

<%
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hi" , "root", "upen");
smt=con.createStatement();
rs=smt.executeQuery("select * from items");
while(rs.next()){
%>
<table><tr><td>
<input type ="Checkbox" name="item" value=<%=rs.getString(2)%>>Item <%=rs.getInt(1) %>::<%=rs.getString(2) %></td></tr><tr></tr>
 	    <%} %>	    
</table><br> <br>
<input type ="submit" value ="ADD TO CART"/>
</form>
</div>
</body>
</html>