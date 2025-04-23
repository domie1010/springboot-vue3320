<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>资助信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  资助信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>资助批次：</td><td width='39%'>${zizhuxinxi.zizhupici}</td><td  rowspan=2 align=center><a href=${zizhuxinxi.tupian} target=_blank><img src=${zizhuxinxi.tupian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>资助金额：</td><td width='39%'>${zizhuxinxi.zizhujine}</td></tr><tr><td width='11%' height=100  >详细：</td><td width='39%' colspan=2 height=100 >${zizhuxinxi.xiangxi}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

