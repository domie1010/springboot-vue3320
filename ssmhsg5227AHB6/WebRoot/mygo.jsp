<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'adminyanzheng.jsp' starting page</title>
    

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  <%
if (request.getSession().getAttribute("cx").equals("学生"))
{
	response.sendRedirect("left3.jsp");
} 

if (request.getSession().getAttribute("cx").equals("教师"))
{
	response.sendRedirect("left2.jsp");
}
if (request.getSession().getAttribute("cx").equals("基金会") )
{
	response.sendRedirect("left.jsp");
}
 %>
  </body>
</html>

