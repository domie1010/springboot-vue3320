<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xueshengxinxihsgb" scope="page" class="com.bean.XueshengxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xueshengxinxi.xls");
%>
<html>
  <head>
    <title>学生信息</title>
  </head>

  <body >
 <%
			String sql="select * from xueshengxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>学号</td>
    <td align='center'>密码</td>
    <td align='center'>姓名</td>
    <td  width='40' align='center'>性别</td>
    <td align='center'>年龄</td>
    <td align='center'>院校</td>
    <td align='center'>联系方式</td>
    <td align='center'>银行卡</td>
    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
  </tr>
   <%		
				List pagelist3=xueshengxinxihsgb.getAllXueshengxinxi(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>
    <td>${u.mima}</td>
    <td>${u.xingming}</td>
    <td align='center'>${u.xingbie}</td>
    <td>${u.nianling}</td>
    <td>${u.yuanxi}</td>
    <td>${u.lianxifangshi}</td>
    <td>${u.yinxingka}</td>
    <td align='center'>${u.issh} <input type="button" value="审核" onClick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=xueshengxinxi'"/></td>
  </tr>
  	<%
  }}
   %>
</table>
<br>
  </body>
</html>

