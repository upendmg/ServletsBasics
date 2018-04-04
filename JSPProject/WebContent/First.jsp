<%-- <%@page import="java.util.Date"%>
 --%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
private String user = null;
private String password = null;
%>


<%
String Name=config.getInitParameter("driver");
out.println(Name);


user = request.getParameter("username");
password = request.getParameter("password");
pageContext.setAttribute("user",user,pageContext.SESSION_SCOPE);
%>
<h1>Welcome</h1>
<a href="second.jsp">second jsp</a>
</body>
</html>




<%-- 	<%!int a = 100, b = 200, c = 0;
	java.util.Date d = null;

	public int sum(int a, int b, int c) {
		return a + b + c;
	}%>
	<%
		System.out.println("sum will be printed on browser");
		d = new Date();
		System.out.println("Date is " + d);
		System.out.println("Sum of method is " + sum(1, 2, 3));
	%>
	<!-- hey man -->
	<%=c=a+b%>
    <%=d %>

	<%=sum(3, 4, 5)%> --%>
