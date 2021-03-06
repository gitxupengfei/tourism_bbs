<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生旅游旅游论坛管理员界面</title>
<link href="pagination.css" rel="stylesheet">
<script src="pagination.js"></script>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	function init(){
		var adminId='<%=session.getAttribute("adminId")%>';
		if(adminId=='null'){
			window.location.href='home';
		}
	}
	
	function exit(){
		if(confirm('您确定要退出管理员模式吗?')){
			window.location.href='home';
		}
	}
</script>
<style type="text/css">
body{
       margin:0px;
       
}
  #body{
  		
  		height:150px;
  }
  #exit{
        height:40px;
        width:60px;
        position:absolute;
        top:0px;
        right:0px;
        background-color:#1C86EE;
        cursor: pointer;
        border-color: #1C86EE;
        color: white;
        font-size: large;
        font-weight: bolder;
  }
  
  #head{
		background-color:#1C86EE;
  
  }
  #headbg{
  		height:100%;
  		width:100%;
  
  }
  #guide{
  	width: 18%;
  
  	background-color:#1C86EE; 
  }
  .item{
  	padding-top: 10px;
  	padding-bottom:10px;
  	border:1px double white;
  	background-color:#1C86EE; 
  	text-align: center;
  	font-weight: bold;
  	color:white;
  	cursor: pointer;
  }
  #content{
  	
  	width: 60%;
  	height: 500px;
  	position: absolute;
  	left: 25%;
  	top: 160px;
  	
  }
  #line{
		font-weight:bold;
		
		color: gray;
		background-image: url("images/line.PNG");
		height: 50px;
		padding-left: 10%;
		padding-top:8px;
		
	}
	#table_div{
		margin-top: 10px;
	}
	
	table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
	table.imagetable th {
		background:#b5cfd2 url('images/cell-blue.jpg');
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #999999;
	}
	table.imagetable td {
		background:#dcddc0 url('images/cell-grey.jpg');
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #999999;
	}
	
	td{
		text-align: center;
	}
	table{
		width: 600px;
	}
	.c{
		width:40px;
		height: 25px;
		margin-bottom: 5px;
		margin-left: 5px;
		font-weight: bolder;
		color:  gray;
		cursor: pointer;
	}
	#input_postId{
		width: 80px;
		margin-right: 100px;
	}
	#input_userName{
		width: 80px;
	}
	#query_btn{
		width: 60px;
		height: 25px;
		margin-left: 150px;
		cursor: pointer;
		color: gray;
		font-weight: bold;
	}
	#page{
		margin-top: 30px;
		text-align: center;
		margin-bottom: 600px;
	}
 </style>
</head>
<body onload="init()">
	<div id="body"  >
  <div id="head">
	<input type="button" title="点击退出登录" id="exit" value="退出" onclick="exit()">
	</div>
	<img alt="大学生旅游论坛" src="images/admin_head.jpg" id="headbg">
	</div>
	<div id="guide">
	<div id="user" class="item" onclick="userAdmin()">用户管理</div>
	<div id="post" class="item" onclick="postAdmin()">帖子管理</div>
	</div>
	<div id="content">
	<div id="line" >
    	帖子ID：<input type="text" name="postIdText" id="input_postId">
    	帖子作者：<input type="text" name="userNameText" id="input_userName">
    	<input type="button" id="query_btn" value="查询" onclick="query()">
  </div>
  <div id="table_div">
   <table class="imagetable" align="center">
<tr>
	<th>帖子ID</th><th>作者</th><th>标题</th><th>收藏数</th><th>评论数</th><th>发帖时间</th><th></th>
</tr>
<c:forEach var="post" items="${postList}">
<tr>
	<td>${post.postId }</td><td>${post.userName }</td><td>${post.title }</td><td>${post.postCollectionNum }</td><td>${post.postCommentNum}</td><td>${post.postTime }</td><td><input type="button" value="删除" class="c" id="delete" title="删除帖子" onclick="deletePost(${post.postId},${post.postUserId},'${post.title}')"></td>
</tr>
</c:forEach>
</table>

<div id="page">
	<div id="pagination" class="pagination"></div>
	</div>
  </div>
	</div>
	
</body>
<script type="text/javascript">
var config = {
		total: <%=(int)request.getAttribute("pageCount")%>, // 当前页面记录总条数
		current_page:<%=(int)request.getAttribute("currentPage")%> , // 当前页码
		page_size: 6// 每页的记录数目
		
	};
	var pagination = new Pagination('pagination', config);
	pagination.onchange = function(page){
		
		$("#table_div").load("showPostAdmin", {"pageNo":page}, function(data, statusTxt,xhr){
			
			    if(statusTxt=="error")
			      alert("系统异常！请稍后再试");
		});
	};
	
	$("#input_userName").blur(function(){
		var userName=$("#input_userName").val();
		console.log(userName);
		if(userName.trim()!=""){
			$("#input_postId").attr("readonly", "readonly");
		}
		else $("#input_postId").removeAttr("readonly");
	});
	
	$("#input_postId").blur(function(){
		var postId=$("#input_postId").val();
		if(postId.trim()!=""){
			$("#input_userName").attr("readonly","readonly");
		}
		else $("#input_userName").removeAttr("readonly");
	});
	
	function query(){
		var postId=$("#input_postId").val();
		var userName=$("#input_userName").val();
		if(postId!="" || userName!=""){
		$("#table_div").load("showPostAdmin", {"postId":postId,"userName":userName}, function(data, statusTxt,xhr){
			
			
		    if(statusTxt=="error")
		      alert("系统异常！请稍后再试");
	});
		}
		else {
			alert("查询前请输入帖子ID或者帖子作者！")
		}
	}
	
	function deletePost(postId,userId,postTitle){
		if(confirm('您确定要删除该帖子?')){
			var pageNo='<%=request.getAttribute("currentPage")%>';
			
				$("#table_div").load("adminOperation", {"postId":postId,"pageNo":pageNo,"userId":userId,"title":postTitle,"style":"delete"}, function(data, statusTxt,xhr){
					
					if(statusTxt=="success") alert("删除成功！");
				    if(statusTxt=="error")
				      alert("系统异常！请稍后再试");
			});
			
			
		}
		
	}
	
	function userAdmin(){
		window.location.href='showUserAdmin';
	}
	function postAdmin(){
		window.location.href='showPostAdmin';
		
	}
</script>
</html>