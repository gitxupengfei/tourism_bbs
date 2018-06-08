<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js">
</script>
<script type="text/javascript">
	function init(){
		alert("${findPasswordOneInfo}");
	}
	<c:if test="${!empty findPasswordOneInfo}">
	window.onload=init;
	</c:if>
		
	
	function isFindValidate(form){
		 document.charset="utf-8";
		 username=form.username.value;
		 telephone=form.telephone.value;
		 if(username.trim()=="" && telephone.trim()==""){
			 alert("请输入用户名或密码！");
			 form.username.focus();
			 return false;
		 }
		
		 
		 return true;
	
	}
	

</script>
<style type="text/css">
	.word{
		font-weight: bolder;
	}
	#line{
		font-weight: 400;
		font-size:x-large;
		color: gray;
		background-image: url("images/line.PNG");
		height: 50px;
		padding-left: 10%;
		padding-top: 10px;
	}
	#register_table{
		margin-left: 20%;
		text-align: left;
		color: gray;
		
	}
	.in {
		height: 20px;
		width:200px;
}

	#register_button{
		font-weight: bolder;
		font-size: x-large;
		color:white;
		background-color:#0066FF;
		height: 40px;
		width: 200px;
		margin-bottom: 20px;
	
	}
	
	
	
	
</style>
</head>
<body>

<div>
	<jsp:include page="home_head.jsp"></jsp:include>
    </div>
<form name="findpasswordformone" action="findPasswordOne" method="post" onsubmit="return isFindValidate(findpasswordformone)" >
<div id="line" >
|&nbsp;密&nbsp;码&nbsp;找&nbsp;回&nbsp;|
</div>
	<table id="register_table">
	
		
		<tr>
			<td class="word" colspan="2">请输入您注册的用户名或手机！输入其一即可！</td>
			
		</tr>
		<tr>
			<td class="word">用户名：</td>
			<td><input type="text" name="username" class="in"><br></td>
		</tr>
		<tr>
		
			<td class="word">手机号：</td>
			<td><input type="text" name="telephone" class="in"><br></td>
			
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="下一步" id="register_button"></td>
			<td></td>
			
		</tr>

	</table>
	
</form>

</body>
</html>