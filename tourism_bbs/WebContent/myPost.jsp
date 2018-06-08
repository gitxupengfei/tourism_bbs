<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	function init(){
		var post='<%=request.getAttribute("myPosts")%>';
		var posting=document.getElementById("none");
		if(post=='[]'){
			posting.style.display="block";
		}
		else posting.style.display="none";
	}
	
	
	function delete_item(postId){
		var msg = "确定要删除该篇帖子吗？";  
        if (confirm(msg)==true){  
        	$.ajax({
    			type: "get",
    			url: "deleteMyPost",
    			data: {postId: postId},
    			success: function(html_data){
    				window.location.reload();
    			}
    		}); 
        } 
		
	 	
	}

	
</script>
<style type="text/css">
	#postTable{
	
	border: 1px solid gray;
	height: 60px;
	width: 80%;
	margin-bottom: 10px;
	margin-left: 60px;
	}
	#none{
		margin-top:100px;
		padding-left: 200px;
		font-size: larger;
		font-weight:bolder;
		color: gray;
	}
	#title{
	    
		padding-left: 50px;
		font-size: larger;
		font-weight:bolder;
	}
	#post_a{
		color: gray;
		padding-right: 20px;
		
		
	}
	#time{
		color:gray;
		padding-left: 80px;
		font-size: small;
		
	}
	#look_a{
		text-decoration: none;
		color: blue;
		cursor: pointer;
	}
	#delete_a{
		text-decoration: none;
		color: red;
		cursor: pointer;
	}
	#line{
		font-weight: 400;
		font-size:x-large;
		color: gray;
		background-image: url("images/line.PNG");
		height: 50px;
		padding-left: 10%;
		padding-top: 10px;
		margin-bottom: 30px;
	}
	#posting_a{
		color:blue;
		text-decoration: none;
	}
</style>
</head>
<body onload="init()">
<form >
<div id="line" >
|&nbsp;我&nbsp;的&nbsp;发&nbsp;帖&nbsp;|
</div>
<div id="none">您还未发表过帖子！现在去<a id="posting_a" href="spacePosting.jsp" target="spaceRight">发帖</a>!</div>
	<c:forEach var="post" items="${myPosts}">
	<table id="postTable" >
	<tr>
		<td id="title" >${post.title}</td>
		<td id="post_a" align="right">
			<a id="look_a" href="showMyPostDetail?postId=${post.postId }">查看</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a id="delete_a"  onclick="delete_item(${post.postId})">删除</a>
		</td>
	</tr>
	<tr>
		<td id="time">时间：${post.postTime}</td>
		<td> </td>
	</tr>
	</table>
	
	</c:forEach>
	</form>
</body>
</html>