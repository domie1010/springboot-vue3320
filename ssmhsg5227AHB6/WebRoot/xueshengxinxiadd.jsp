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
<title>学生信息</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="qtimages/css/reset.css" rel="stylesheet" />
<link href="qtimages/css/main.css" rel="stylesheet"/>
<link href="qtimages/css/sub.css" rel="stylesheet"/>
<script src="qtimages/jquery.js"></script> 
<script src="js/jquery.SuperSlide.2.1.1.js"></script>

<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
</head>
<%

  String id="";


 



   %>


	
<script language=javascript >  
function hsgcheck() {
		var xuehao = $("#xuehao").val();
		if(xuehao==""||(xuehao.length<6||xuehao.length>12)){
			 $("#clabelxuehao").html("<font color=red>学号不能为空且长度在3～12位之间！</font>");
			 $("input[id=xuehao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelxuehao").html("");
			$.ajax({
				url : "quchongXueshengxinxi.do",
				type : "post",
				data : "xuehao=" + xuehao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelxuehao").html("<font color=red>学号已存在，请更换！</font>");
					$("input[id=xuehao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelxuehao").html("系统异常，请检查错误！");
					$("input[id=xuehao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>
	<script language="javascript">
function checkform()
{
	var xuehaoobj = document.getElementById("xuehao"); if(xuehaoobj.value==""){document.getElementById("clabelxuehao").innerHTML="&nbsp;&nbsp;<font color=red>请输入学号</font>";return false;}else{document.getElementById("clabelxuehao").innerHTML="  "; } 
	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var xingbieobj = document.getElementById("xingbie"); if(xingbieobj.value==""){document.getElementById("clabelxingbie").innerHTML="&nbsp;&nbsp;<font color=red>请输入性别</font>";return false;}else{document.getElementById("clabelxingbie").innerHTML="  "; } 
	var nianlingobj = document.getElementById("nianling"); if(nianlingobj.value==""){document.getElementById("clabelnianling").innerHTML="&nbsp;&nbsp;<font color=red>请输入年龄</font>";return false;}else{document.getElementById("clabelnianling").innerHTML="  "; } 
	var nianlingobj = document.getElementById("nianling"); if(nianlingobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(nianlingobj.value)){document.getElementById("clabelnianling").innerHTML=""; }else{document.getElementById("clabelnianling").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var yuanxiobj = document.getElementById("yuanxi"); if(yuanxiobj.value==""){document.getElementById("clabelyuanxi").innerHTML="&nbsp;&nbsp;<font color=red>请输入院校</font>";return false;}else{document.getElementById("clabelyuanxi").innerHTML="  "; } 
	var lianxifangshiobj = document.getElementById("lianxifangshi"); if(lianxifangshiobj.value==""){document.getElementById("clabellianxifangshi").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系方式</font>";return false;}else{document.getElementById("clabellianxifangshi").innerHTML="  "; } 
	var lianxifangshiobj = document.getElementById("lianxifangshi"); if(lianxifangshiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxifangshiobj.value)){document.getElementById("clabellianxifangshi").innerHTML=""; }else{document.getElementById("clabellianxifangshi").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}  
    var yinxingkaobj = document.getElementById("yinxingka"); if(yinxingkaobj.value==""){document.getElementById("clabelyinxingka").innerHTML="&nbsp;&nbsp;<font color=red>请输入银行卡</font>";return false;}else{document.getElementById("clabelyinxingka").innerHTML="  "; } 
	var yinxingkaobj = document.getElementById("yinxingka"); if(yinxingkaobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(yinxingkaobj.value)){document.getElementById("clabelyinxingka").innerHTML=""; }else{document.getElementById("clabelyinxingka").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    
}
function gow()
{
	document.location.href="xueshengxinxiadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>

<div class="content">
	<div class="wrap">
		<div class="pad0">
			<div class="s_title">
				<div class="name">学生信息</div>
				<div class="menu">
					
				</div>
			</div>
			<div class="det_con"> 
					
					<% 




%>

  
<form action="addXueshengxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						
						<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxuehao' /></td></tr>
		<tr ><td width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr>
		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select>&nbsp;*<label id='clabelxingbie' /></td></tr>
		<tr ><td width="200">年龄：</td><td><input name='nianling' type='text' id='nianling' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelnianling' /></td></tr>
		<tr ><td width="200">院校：</td><td><select name='yuanxi' id='yuanxi' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("yuanxixinxi","yuanxi")%></select>&nbsp;*<label id='clabelyuanxi' /></td></tr>
		<tr ><td width="200">联系方式：</td><td><input name='lianxifangshi' type='text' id='lianxifangshi' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxifangshi' /></td></tr>
		<tr ><td width="200">银行卡：</td><td><input name='yinxingka' type='text' id='yinxingka' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelyinxingka' /></td></tr>
		
		
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

