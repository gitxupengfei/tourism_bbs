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
	#note{
		margin-left: 15%;
		width: 650px;
		background-color: #EEEED1;
	}
	#head{
		padding-left: 40px;
		padding-top:10px;
		color: gray;
		border-bottom: 1px  dashed gray;
		
	}
	#noteBody{
		padding-left: 60px;
		color: gray;
		padding-right: 60px;
		padding-top: 20px;
		padding-bottom: 20px;
		margin-bottom: 5px;
	
	}
	#none{
		margin-top:100px;
		padding-left: 200px;
		font-size: larger;
		font-weight:bolder;
		color: gray;
	}
</style>
</head>
<body onload="init()">
<c:forEach var="note" items="${noteList}">
		<div id="note">
			<div id="head"><b>系统消息</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="2">${note.noteTime}</font></div>
			<div id="noteBody">
				&nbsp;&nbsp;&nbsp;&nbsp;您发表的文章“${note.title}”由于违反了相关规定，已于审查过程中被管理员删除。并给予荣誉值减一的处罚！
		</div>
		</div>
		</c:forEach>
		
</body>
<script type="text/javascript">
</script>
</html>