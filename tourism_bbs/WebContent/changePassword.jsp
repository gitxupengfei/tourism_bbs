<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){	
		$("#confirm_password").blur(function() {
			var login_password=$("#login_password").val();
			var confirm_password=$("#confirm_password").val();
			if(login_password!=confirm_password){
				$("#difpassword").text("×前后密码输入不一致！");
			}
			else
				$("#difpassword").text("");
			
		});
		
		
		
		
	
	});
	
	function isChangeValidate(form){
		 document.charset="utf-8";
		 oldPassword=form.old_password.value;
		 password=form.register_password.value;
		 confirmPassword=form.confirm_password.value;
		 question1=form.question1.value;
		 answer1=form.answer1.value;
		 question2=form.question2.value;
		 answer2=form.answer2.value;
	     var loginPassword="<%=session.getAttribute("password")%>";
		 
		 var  difpassword= document.getElementById("difpassword").innerText;
		
		 if(oldPassword!=loginPassword){
			 alert("原密码输入错误,请确认后重新输入");
			 form.old_password.focus();
			 return false;
		 }

		 if(oldPassword.trim()==""){
			 alert("请输入原密码！");
			 form.old_password.focus();
			 return false;
		 }
		 
		 if(password.trim()==""){
			 alert("密码不能为空！");
			 form.register_password.focus();
			 return false;
		 }

		 if(confirmPassword.trim()==""){
			 alert("确认密码不能为空！");
			 form.confirm_password.focus();
			 return false;
		 }
		 if(question1.trim()==""){
			 alert("密保问题不能为空！");
			 form.question1.focus();
			 return false;
		 }
		 if(answer1.trim()==""){
			 alert("密保答案不能为空！");
			 form.answer1.focus();
			 return false;
		 }
		 if(answer2.trim()==""){
			 alert("密保答案不能为空！");
			 form.answer2.focus();
			 return false;
		 }
		 if(question1.trim()==""){
			 alert("密保问题不能为空！");
			 form.question1.focus();
			 return false;
		 }
		
		
		
		 if(difpassword.trim()!=""){
			 alert("前后密码不一致！");
			 form.register_password.focus();
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
	
	#difpassword,#errorphone,#errorQQ{
		font-size: small;
		color:red;
		
	}
	
	
</style>
</head>
<body>


<form name="changepasswordform" action="changePassword" method="post" onsubmit="return isChangeValidate(changepasswordform)" accept-charset="UTF-8">
<div id="line" >
|&nbsp;密&nbsp;码&nbsp;修&nbsp;改&nbsp;|
</div>
	<table id="register_table">
	<tr>
			<td class="word">原密码：</td>
			<td><input type="password" name="old_password" class="in" id="old_password"><br></td>
			<td></td>
			
		</tr>
		
		<tr>
			<td class="word">新密码：</td>
			<td><input type="password" name="register_password" class="in" id="login_password"><br></td>
			<td></td>
			
		</tr>
		<tr>
			<td class="word">确认密码：</td>
			<td><input type="password" class="in" name="confirm_password" id="confirm_password"><br></td>
			<td><label id="difpassword" ></label></td>
		</tr>
		<tr>
			<td class="word">密保问题1：</td>
			<td><input type="text" name="question1" class="in"
			value="${personalInfo.question1 }"><br></td>
			
			
			
		<tr>
		
			<td class="word">密保1答案：</td>
			<td><input type="text" name="answer1" class="in"
			value="${personalInfo.answer1 }"><br></td>
			
		</tr>
		<tr>
			<td class="word">密保问题2：</td>
			<td><input type="text" name="question2" class="in"
			value="${personalInfo.question2 }"><br></td>
			
		</tr>
		<tr>
			<td class="word">密保2答案：</td>
			<td><input type="text" name="answer2" class="in"
			value="${personalInfo.answer2 }"><br></td>
			<td></td>
			
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="确认修改" id="register_button"></td>
			<td></td>
			
		</tr>

	</table>
	
</form>

</body>
</html>