<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	
	#a_1,#a_2{
	color:blue;
	font-size:3px;
	}
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
	
</style>
</head>
<body>

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
				<input type="button" value="登录" id="btn">
			</td>
			
		</tr>
		
		<tr>
			<td align="left" id="a_1">
			忘记密码
			</td>
			<td align="right" id="a_2">
			立即注册
			</td>
		</tr>
		
	
	</table>


</body>
</html>