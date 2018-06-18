<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="pagination.css" rel="stylesheet">
<script src="pagination.js"></script>
<script src="jquery-3.3.1.js"></script>
<style type="text/css">
	#comText{
		padding-left: 40px;
		padding-top:10px;
		color: grey;
		padding-bottom: 10px;
		border-bottom:1px dashed gray;
	}
	#comTime{
		color:gray;
		font-size: small;;
	}
	#comUserImg{
		width: 20px;
		height: 20px;
		border-radius:10px;
	}
</style>
</head>
<body>
	<c:forEach var="comment" items="${commentList}">
			<div id="comHead">
			<img alt="用户"  title="${comment.comUserName }" src="userphoto/${comment.comUserPhoto}" id="comUserImg">
			&nbsp;&nbsp;<b>${comment.comUserName}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id="comTime">${comment.comTime}</label>
			</div>
			<div id="comText">
				${comment.comContent}
			</div>
			</c:forEach>
</body>
</html>