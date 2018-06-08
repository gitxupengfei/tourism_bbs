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

		
	function isFindValidate(form){
		var answer1=form.answer1.value;
		
		var answer2=form.answer2.value;
		//正确的问题答案。
		var answerOne="<%=request.getAttribute("answer1")%>";
		
		var answerTwo="<%=request.getAttribute("answer2")%>";
		if(answer1!=answerOne || answer2!=answerTwo ){
			alert("回答错误！请重新输入答案！");
			form.answer1.focus();
			return false;
			
		}
		return true;
	}
	
	

</script>
<style type="text/css">
	.word{
		font-weight: bolder;
	}
	.word2{
		font-weight: bolder;
		color: grey;
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
<form name="findpasswordformtwo" action="findPasswordTwo" method="post" onsubmit="return isFindValidate(findpasswordformtwo)" >
<div id="line" >
|&nbsp;密&nbsp;码&nbsp;找&nbsp;回&nbsp;|
</div>
	<table id="register_table">
	
		
		<tr>
			<td class="word" colspan="2">正确回答以下问题，即可找回密码！</td>
			
		</tr>
		<tr>
			<td class="word2" >问题1：</td>
			<td class="word2">${passwordInfo.question1}</td>
			
		</tr>
		<tr>
			<td class="word">答案：</td>
			<td><input type="text" name="answer1" class="in"><br></td>
		</tr>
		<tr>
			<td class="word2" >问题2：</td>
			<td class="word2">${passwordInfo.question2}</td>
			
		</tr>
		<tr>
		
			<td class="word">答案：</td>
			<td><input type="text" name="answer2" class="in"><br></td>
			
		</tr>
		<tr>
			<td></td>
			<td><input type="hidden" name="passwordInfo_username" value="${passwordInfo.userName}"></td>
			<td><input type="hidden" name="passwordInfo_password" value="${passwordInfo.password}"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="找回密码" id="register_button"></td>
			<td></td>
			
		</tr>

	</table>
	
</form>

</body>
</html>