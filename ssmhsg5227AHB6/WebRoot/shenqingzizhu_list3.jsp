<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>申请资助查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">申请资助列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="shenqingzizhuList.do" name="myform" method="post">
									查询   资助批次：<input name="zizhupici" type="text" id="zizhupici" style='border:solid 1px #000000; color:#666666' size="12" />  资助金额：<input name="zizhujine" type="text" id="zizhujine" style='border:solid 1px #000000; color:#666666' size="12" /> 状态：<select name='zhuangtai' id='zhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="已驳回">已驳回</option><option value="已审批">已审批</option></select>  申请人：<input name="shenqingren" type="text" id="shenqingren" style='border:solid 1px #000000; color:#666666' size="12" />  申请日期：<input name="shenqingriqi1" type="text" id="shenqingriqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="shenqingriqi2" type="text" id="shenqingriqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>资助批次</td>
    <td align='center'>资助金额</td>
    <td align='center'>状态</td>
    <td align='center'>申请人</td>
    <td  width='65' align='center'>申请日期</td>
    <td  width='90' align='center'>申请样表</td>
    <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.zizhupici}</td>
    <td>${u.zizhujine}</td>
    <td>${u.zhuangtai}</td>
    <td>${u.shenqingren}</td>
    <td>${u.shenqingriqi}</td>
    <td width='90' align='center'><a href='${u.shenqingyangbiao}' target='_blank'><img src='${u.shenqingyangbiao}' width=88 height=99 border=0 /></a></td>
    <td align='center'>${u.issh} </td>
                              <td align="center"> ${u.addtime } </td>
                             <td align="center"><a href="doUpdateShenqingzizhulb.do?id=${u.id }">审批</a> <a href="shenqingzizhuDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="shenqingzizhuList.do?page=1" >首页</a>
             <a href="shenqingzizhuList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="shenqingzizhuList.do?page=${page.page+1 }">下一页</a>
			<a href="shenqingzizhuList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
