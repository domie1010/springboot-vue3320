<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="jiaoshixinxihsgb" scope="page" class="com.bean.JiaoshixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=jiaoshixinxi.xls");
%>
<html>
  <head>
    <title>教师信息</title>
  </head>

  <body >
 <%
			String sql="select * from jiaoshixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>用户名</td>    <td align='center'>密码</td>    <td align='center'>姓名</td>    <td  width='40' align='center'>性别</td>    <td align='center'>联系方式</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=jiaoshixinxihsgb.getAllJiaoshixinxi(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.mima}</td>    <td>${u.xingming}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.lianxifangshi}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

