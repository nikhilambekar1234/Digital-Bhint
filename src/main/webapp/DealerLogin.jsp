<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="CrudPack.EmpDao" %>
<jsp:useBean id="obj" class="CrudPack.Emp"/>
<jsp:setProperty property="*" name="obj"/>

<%--LOGIN PROCESS --%>
  
<%
System.out.println("email1 "+obj.getMobileNumber());
System.out.println("pass1 "+obj.getPassword());
boolean status=EmpDao.validate1(obj);

if(status)
{
%>
<jsp:forward page="OrderViewServlet"/>  
<%
out.println("You are successfully logged in");
}
else
{
%>
<jsp:include page="Index1.html"></jsp:include>
<%

	out.print("Sorry,email or password error");
}
%>
</body>
</html>