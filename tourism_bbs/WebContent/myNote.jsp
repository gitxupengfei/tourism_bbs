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
	#line{
		
		
		color: gray;
		background-image: url("images/line.PNG");
		height: 50px;
		padding-left: 10%;
		padding-top: 10px;
		margin-bottom: 20px;
	}
	#none{
		margin-top:100px;
		padding-left: 200px;
		font-size: larger;
		font-weight:bolder;
		color: gray;
	}
	.span{
		height: 40px;
		width: 60px;
		text-align: center;
		color: gray;
		margin-left: 10px;
		cursor: pointer;
	}
	#system{
		background-color: #D9D9D9;
	}
</style>
</head>
<body>
	<div id="line" >
		<span class="span" onclick="systemNote()" id="system">
		系统NOTE
		</span>
		<span class="span" onclick="leaveNote()" id="leave">
		留言NOTE
		</span>
		<span class="span" onclick="commentNote()" id="comment">
		评论NOTE
		</span>
	</div>

<div id="content">
	
	<jsp:include page="systemNote.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript">
	//系统消息
	function systemNote(){
		$("#system").css("background-color","#D9D9D9");
		$("#leave").css("background-color","white");
		$("#comment").css("background-color","white");
		$("#content").load("showNote", {"style":"system"}, function(data, statusTxt,xhr){
			
		    if(statusTxt=="error")
		      alert("系统异常！请稍后再试");
	});
	    }
	//留言
	function leaveNote(){
		$("#system").css("background-color","white");
		$("#leave").css("background-color","#D9D9D9");
		$("#comment").css("background-color","white");
		$("#content").load("showNote", {"style":"leave"}, function(data, statusTxt,xhr){
			
		    if(statusTxt=="error")
		      alert("系统异常！请稍后再试");
	});
	}
	//评论
	function commentNote(){
		$("#system").css("background-color","white");
		$("#leave").css("background-color","white");
		$("#comment").css("background-color","#D9D9D9");
		
$("#content").load("showNote", {"style":"comment"}, function(data, statusTxt,xhr){
			
		    if(statusTxt=="error")
		      alert("系统异常！请稍后再试");
	});
	}
	
</script>
</html>