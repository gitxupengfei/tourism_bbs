<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
	table{
		width: 700px;
		margin-left: 10%;
		
		margin-top: 20px;
	}
	
	#title{
		height: 40px;
		vertical-align: middle;
		font-size: large;
		font-weight: bold;
		
		
		
	}
	#time{
		font-size: small;
		color: gray;
		width: 50%;
		padding-left: 30px;
	}
	#label{
		height: 20px;
		font-size: small;
		color: #0066FF;
		width: 50%;
		padding-right: 30px;
		font-weight: bold;
		
	}
	#picture{
		height: 300px;
		
	}
	#content{
		color: gray;
		word-break: break-all;
		word-wrap: break-word;
		padding-left:30px;
		padding-right: 30px;
		padding-top:20px;
		font-size: small; 
		
	}
	#img{
		width: 600px;
		height: 300px;
	}
</style>
</head>
<body>
	<table >
		<tr>
			<td colspan="2" id="title" align="center">${myPost.title }</td>
		</tr>
		<tr>
			<td id="time" align="left">${myPost.postTime }</td>
			<td id="label" align="right">${myPost.styleLabel }&nbsp;&nbsp;|&nbsp;&nbsp;${myPost.placeLabel }</td>
		</tr>
		<tr>
			<td colspan="2" id="picture" align="center">
				<img alt="大学生旅游论坛" src="picture/${myPost.picture }" id="img">
			</td>
		</tr>
		<tr>
			<td colspan="2" id="content" >
				${myPost.postContent }
			</td>
		</tr>
	</table>
</body>
</html>