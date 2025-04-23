<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shenqinggenghuanyinxingkahsgb" scope="page" class="com.bean.ShenqinggenghuanyinxingkaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shenqinggenghuanyinxingka.xls");
%>
<html>
  <head>
    <title>申请更换银行卡</title>
  </head>

  <body >
 <%
			String sql="select * from shenqinggenghuanyinxingka  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>申请人</td>    <td align='center'>新银行卡</td>    <td  width='65' align='center'>申请时间</td>    <td align='center'>申请原因</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shenqinggenghuanyinxingkahsgb.getAllShenqinggenghuanyinxingka(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shenqingren}</td>    <td>${u.xinyinxingka}</td>    <td>${u.shenqingshijian}</td>    <td>${u.shenqingyuanyin}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shenqinggenghuanyinxingka'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

