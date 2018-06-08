<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
	#ok{
		font-size: large;
		font-weight: bolder;
		height: 60px;
		margin-left: 200px;
		margin-top: 100px;
		
	}
	#okImg{
		height: 50px;
		width: 50px;
		margin-right: 30px;
	}
	#spaceSa{
		color: blue;
		text-decoration: none;
	}
	
</style>
</head>
<body>
<table id="ok" >
	<tr>
	<td rowspan="3">
	<img alt="OK" src="images/ok.jpg" id="okImg">
	</td>
	<td></td>
	</tr>
	<tr>
	<td>
	</td>
	<td>
	帖子发布成功！可在<a id="spaceSa" href="http://localhost:8080/tourism_bbs/showMyPost" target="spaceRight">我的发帖</a>中查看！
	</td>
	
	</tr>
	<tr>
	<td>
	</td>
	<td>
	</td>
	</tr>
	
</table>
</body>
</html>