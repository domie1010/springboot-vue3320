<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>申请资助详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  申请资助详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>资助批次：</td><td width='39%'>${shenqingzizhu.zizhupici}</td><td  rowspan=5 align=center><a href=${shenqingzizhu.shenqingyangbiao} target=_blank><img src=${shenqingzizhu.shenqingyangbiao} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>资助金额：</td><td width='39%'>${shenqingzizhu.zizhujine}</td></tr><tr><td width='11%' height=44>状态：</td><td width='39%'>${shenqingzizhu.zhuangtai}</td></tr><tr><td width='11%' height=44>申请人：</td><td width='39%'>${shenqingzizhu.shenqingren}</td></tr><tr><td width='11%' height=44>申请日期：</td><td width='39%'>${shenqingzizhu.shenqingriqi}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

