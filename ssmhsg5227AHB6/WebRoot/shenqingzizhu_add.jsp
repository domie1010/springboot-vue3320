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
		<TITLE>添加申请资助</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="shenqingzizhu_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addShenqingzizhu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加申请资助</td>
						</tr>
						<tr ><td width="200">资助批次：</td><td><input name='zizhupici' type='text' id='zizhupici' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zizhupici.value='<%=connDbBean.readzd("zizhuxinxi","zizhupici","id",request.getParameter("id"))%>';document.form1.zizhupici.setAttribute("readOnly",'true');</script>		<tr ><td width="200">资助金额：</td><td><input name='zizhujine' type='text' id='zizhujine' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zizhujine.value='<%=connDbBean.readzd("zizhuxinxi","zizhujine","id",request.getParameter("id"))%>';document.form1.zizhujine.setAttribute("readOnly",'true');</script>		<tr style='display:none'><td width="200">状态：</td><td><select name='zhuangtai' id='zhuangtai'><option value="已驳回">已驳回</option><option value="已审批">已审批</option></select></td></tr>		<tr ><td width="200">申请人：</td><td><input name='shenqingren' type='text' id='shenqingren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">申请日期：</td><td><input name='shenqingriqi' type='text' id='shenqingriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelshenqingriqi' /></td></tr>		<tr ><td width="200">申请样表：</td><td><input name='shenqingyangbiao' type='text' id='shenqingyangbiao' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('shenqingyangbiao')" style='border:solid 1px #000000; color:#666666'/></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shenqingriqiobj = document.getElementById("shenqingriqi"); if(shenqingriqiobj.value==""){document.getElementById("clabelshenqingriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请日期</font>";return false;}else{document.getElementById("clabelshenqingriqi").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
