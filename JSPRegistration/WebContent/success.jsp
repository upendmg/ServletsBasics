<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
<br>You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
<br>Welcome</br> <%=session.getAttribute("userid")%>
<a href='logout.jsp'>Log out</a>
<%
    }
%>