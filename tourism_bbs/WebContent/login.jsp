<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	function isValidate(form){
		username=form.username.value;
		password=form.password.value;
		if(username==""){
			alert("请输入用户名！");
			form.username.focus();
			return false;
		}
		
		if(password==""){
			alert("请输入密码！");
			form.password.focus();
			return false;
		}
		return true;
	}

</script>


<style type="text/css">
	
	
	
	#btn{
		width:200px;
		height:40px;
		background-color: blue;
		color:white;
		font-weight: bolder;
	}
	#word1,#word2{
		valign:middle;
		font-weight: bold;
	}
	.login_a{
		text-decoration: none;
		color:blue;
	    font-size:3px;
	}
	
</style>

</head>
<body>
<form name="loginform" action="login" method="post" onsubmit="return isValidate(loginform)">
	<table width="330px" height="300px" >
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr align="center" >
			<td id="word1">&nbsp;&nbsp;用户名：</td>
			<td><input type="text" name="username" height="30px"></td>
		</tr>
		<tr align="center">
			<td id="word2" >&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
			<td><input type="password" name="password" height="30px"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<!-- <input type="submit" value="登录" id="btn"> -->
				<input type="submit" value="登录" id="btn">
			</td>
			
		</tr>
		
		<tr>
			<td align="left" >
			<a href="register.jsp" title="点击找回密码" class="login_a">忘记密码</a>
			</td>
			<td align="right" >
			<a href="register.jsp" title="点击注册" class="login_a">立即注册</a>
			</td>
		</tr>
		
	
	</table>

</form>
</body>
</html>