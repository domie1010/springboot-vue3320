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
		<TITLE>添加申请更换银行卡</TITLE>
	    

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
	document.location.href="shenqinggenghuanyinxingka_add.jsp?id=<%=id%>";
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
			<form action="addShenqinggenghuanyinxingka.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加申请更换银行卡</td>
						</tr>
						<tr ><td width="200">申请人：</td><td><input name='shenqingren' type='text' id='shenqingren' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelshenqingren' /></td></tr>		<tr ><td width="200">新银行卡：</td><td><input name='xinyinxingka' type='text' id='xinyinxingka' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxinyinxingka' /></td></tr>		<tr ><td width="200">申请时间：</td><td><input name='shenqingshijian' type='text' id='shenqingshijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelshenqingshijian' /></td></tr>		<tr ><td width="200">申请原因：</td><td><textarea name='shenqingyuanyin' cols='50' rows='5' id='shenqingyuanyin' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelshenqingyuanyin' /></td></tr>		
		
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
 
	var shenqingrenobj = document.getElementById("shenqingren"); if(shenqingrenobj.value==""){document.getElementById("clabelshenqingren").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请人</font>";return false;}else{document.getElementById("clabelshenqingren").innerHTML="  "; } 	var xinyinxingkaobj = document.getElementById("xinyinxingka"); if(xinyinxingkaobj.value==""){document.getElementById("clabelxinyinxingka").innerHTML="&nbsp;&nbsp;<font color=red>请输入新银行卡</font>";return false;}else{document.getElementById("clabelxinyinxingka").innerHTML="  "; } 	var xinyinxingkaobj = document.getElementById("xinyinxingka"); if(xinyinxingkaobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(xinyinxingkaobj.value)){document.getElementById("clabelxinyinxingka").innerHTML=""; }else{document.getElementById("clabelxinyinxingka").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      var shenqingshijianobj = document.getElementById("shenqingshijian"); if(shenqingshijianobj.value==""){document.getElementById("clabelshenqingshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请时间</font>";return false;}else{document.getElementById("clabelshenqingshijian").innerHTML="  "; } 	var shenqingyuanyinobj = document.getElementById("shenqingyuanyin"); if(shenqingyuanyinobj.value==""){document.getElementById("clabelshenqingyuanyin").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请原因</font>";return false;}else{document.getElementById("clabelshenqingyuanyin").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
