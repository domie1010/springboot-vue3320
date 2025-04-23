<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta />
<title>申请资助</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="js/popup.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	var shenqingriqiobj = document.getElementById("shenqingriqi"); if(shenqingriqiobj.value==""){document.getElementById("clabelshenqingriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入申请日期</font>";return false;}else{document.getElementById("clabelshenqingriqi").innerHTML="  "; } 
	
}
function gow()
{
	document.location.href="shenqingzizhuadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">申请资助</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					<% 




%>

  
<form action="addShenqingzizhu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						
						<tr ><td width="200">资助批次：</td><td><input name='zizhupici' type='text' id='zizhupici' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zizhupici.value='<%=connDbBean.readzd("zizhuxinxi","zizhupici","id",request.getParameter("id"))%>';document.form1.zizhupici.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">资助金额：</td><td><input name='zizhujine' type='text' id='zizhujine' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zizhujine.value='<%=connDbBean.readzd("zizhuxinxi","zizhujine","id",request.getParameter("id"))%>';document.form1.zizhujine.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">申请人：</td><td><input name='shenqingren' type='text' id='shenqingren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		<tr ><td width="200">申请日期：</td><td><input name='shenqingriqi' type='text' id='shenqingriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelshenqingriqi' /></td></tr>
		<tr 0>
		  <td>样表：</td>
		  <td><input name='shenqingyangbiao' type='text' id='shenqingyangbiao' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />
		    &nbsp;
		    <input type='button' value='上传' onClick="up('shenqingyangbiao')" style='border:solid 1px #000000; color:#666666'/></td>
		  </tr>
		
		
						<tr align='center'   height="22">
						    <td width="200"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;						    </td>
						</tr>
					 </table>
			</form>
			<script language="javascript">popheight = 450;</script>
					
			</div>	
		</div>
	</div>		
</div>
<jsp:include page="qtdown.jsp"></jsp:include>


</body>
</html>

