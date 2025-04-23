<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shenqingzizhuhsgb" scope="page" class="com.bean.ShenqingzizhuBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shenqingzizhu.xls");
%>
<html>
  <head>
    <title>申请资助</title>
  </head>

  <body >
 <%
			String sql="select * from shenqingzizhu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>资助批次</td>    <td align='center'>资助金额</td>    <td align='center'>状态</td>    <td align='center'>申请人</td>    <td  width='65' align='center'>申请日期</td>    <td  width='90' align='center'>申请样表</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shenqingzizhuhsgb.getAllShenqingzizhu(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zizhupici}</td>    <td>${u.zizhujine}</td>    <td>${u.zhuangtai}</td>    <td>${u.shenqingren}</td>    <td>${u.shenqingriqi}</td>    <td width='90' align='center'><a href='${u.shenqingyangbiao}' target='_blank'><img src='${u.shenqingyangbiao}' width=88 height=99 border=0 /></a></td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shenqingzizhu'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

