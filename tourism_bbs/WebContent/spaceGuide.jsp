<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js"></script>
<style type="text/css">
	#personalPhotoDiv{
		padding-top: 30px;
		padding-bottom:30px;
		border-bottom: 3px solid #0066FF;
	}
	#personalPhoto{
		height: 50px;
		width:50px;
		border-radius:25px;
		
	}
	#userName{
		font-weight: bold;
		margin-bottom: 20px;
	}
	.sgtr{
		font-size: small;
		font-weight: bold;
		text-align: center;
		
	}
	#gradetd{
		font-size: medium;
		color: yellow;
	}
	#guideList{
		width: 150px;
		margin-top: 30px;
		text-align: center;
		font-weight: bold;
		color: white;
	}
	#redPoint{
	font-size:larger;
	font-weight: bolder;
	vertical-align: middle;
	color: red;
	}
	.space_a{
		text-decoration: none;
		 cursor:pointer;
		 color: white;
		
	}
</style>
</head>
<body>
<div id="personalPhotoDiv" align="center">
	<img alt="用户头像" src="userphoto/${user.photo}" id="personalPhoto">
	<br>
	<br>
	<label id="userName">${user.userName }</label>
	<br>
	<br>
	<table width="150px">
	<tr class="sgtr">
	<td>等级</td>
	<td>粉丝</td>
	<td>积分</td>
	</tr>
	<tr class="sgtr">
	<td id="gradetd"><label >V${user.level}</label></td>
	<td><label>${user.attentionNum }</label></td>
	<td><label>${user.experienceNum }</label></td>
	</tr>
	</table>
</div>
<div align="center">
<table  id="guideList">
<tr height="30px" bgcolor="#0066FF"><td><a href="http://localhost:8080/tourism_bbs/showPersonalInfo" target="spaceRight" class="space_a">个人信息</a></td></tr>
<tr height="20px" ><td></td></tr>
<tr height="30px" bgcolor="#0066FF"><td><a href="http://localhost:8080/tourism_bbs/showPassword" target="spaceRight" class="space_a">密码修改</a></td></tr>
<tr height="20px" ><td></td></tr>
<tr height="30px" bgcolor="#0066FF"><td><a href="http://localhost:8080/tourism_bbs/showMyPost" target="spaceRight" class="space_a">我的发帖</a></td></tr>
<tr height="20px" ><td></td></tr>
<tr height="30px" bgcolor="#0066FF"><td><a href="spacePosting.jsp" target="spaceRight" class="space_a">我要发帖</a></td></tr>
<tr height="20px" ><td></td></tr>
<tr height="30px" bgcolor="#0066FF"><td><a  href="http://localhost:8080/tourism_bbs/showMyCollection" target="spaceRight" class="space_a">我的收藏</a></td></tr>
<tr height="20px" ><td></td></tr>
<tr height="30px" bgcolor="#0066FF"><td><a  href="http://localhost:8080/tourism_bbs/showMyAttention" target="spaceRight" class="space_a">我的关注</a></td></tr>
<tr height="20px" ><td></td></tr>
<tr height="30px" bgcolor="#0066FF"><td><a  href="http://localhost:8080/tourism_bbs/showNote" target="spaceRight" class="space_a">我需留意</a></td></tr>
<tr height="20px" ><td></td></tr>

</table>
</div>
</body>
</html>