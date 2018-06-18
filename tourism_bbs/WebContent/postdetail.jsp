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
<script type="text/javascript">
		
		
		function init(postUserId){
			var userId=<%=String.valueOf(session.getAttribute("userid"))%>;
			if(postUserId==userId){
				$("#collection_div").hide();
			}
			var comment='<%=request.getAttribute("commentList")%>';
			
			if(comment=='[]'){
				$("#page").hide();
				$("#commentShow").hide();
			}
		}

		function collection(postId){
			$.ajax({
    			type: "get",
    			url: "addCollection",
    			data: {postId: postId},
    			success: function(html_data){
    				if(html_data=='OK') {
    					alert("收藏成功！");
    				}
    				else	alert("您已经收藏了该文章！");
    			},
    			error: function(xhr,status,error){
    				alert("系统异常！请稍后再试！");
    			}
    		}); 
		}
</script>
<style type="text/css">
	body{
		
	}
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
		padding-left:35px;
		padding-right: 35px;
		padding-top:20px;
		font-size: small; 
		
	}
	#img{
		width: 600px;
		height: 300px;
	}
	#collection_div{
		position: absolute;
		right: 5%;
		top: 100px; 
		
	}
	#collection_img{
		width: 80px;
		height: 112px;
		cursor: pointer;
		
	}
	#page{
		margin-top:10px;
		text-align: center;
		margin-left: 13%;
		width: 630px;
		background-color:#EEEED1; 
		
	}
	#comment{
		margin-left:13%;
		margin-top: 50px;
		
	}
	#commentShow{
		margin-left: 13%;
		background-color: #EEEED1;
		width: 630px;
		
	}
	#submitComment{
		text-align: right;
		width: 630px;
	}
	#submit_btn{
		width: 60px;
		height: 30px;
		color: white;
		background-color: #0066FF;
		cursor: pointer;
	}
	#comHead{
		
	}
	
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
<body onload="init(${post.postUserId})">
	<table >
		<tr>
			<td colspan="2" id="title" align="center">${post.title }</td>
		</tr>
		<tr>
			<td id="time" align="left">${post.postTime }</td>
			<td id="label" align="right">${post.styleLabel }&nbsp;&nbsp;|&nbsp;&nbsp;${post.placeLabel }</td>
		</tr>
		<tr>
			<td colspan="2" id="picture" align="center">
				<img alt="大学生旅游论坛" src="picture/${post.picture }" id="img">
			</td>
		</tr>
		<tr>
			<td colspan="2" id="content" >
				${post.postContent }
			</td>
		</tr>
	</table>
	<div id="collection_div">
		<img alt="收藏" src="images/collection.jpg" title="点击收藏文章" id="collection_img" onclick="collection(${post.postId})">
	</div>
	<div id="comment">
		<div id="inputComment">
			<textarea rows="5" cols="95" id="commentContent"></textarea>
		</div>
		<div id="submitComment" >
			<input type="button" value="评论"  id="submit_btn" onclick="submitComment(${post.postId})">
		</div>
	
	</div>
	
		<div id="commentShow">
		<c:forEach var="comment" items="${commentList}">
			<div id="comHead">
			<img alt="用户"  title="${comment.comUserName }" src="userphoto/${comment.comUserPhoto}" id="comUserImg">
			&nbsp;&nbsp;<b>${comment.comUserName}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id="comTime">${comment.comTime}</label>
			</div>
			<div id="comText">
				${comment.comContent}
			</div>
			</c:forEach>
		</div>
		<div id="page">
		<div id="pagination" class="pagination"></div>
		</div>
		
	
</body>
<script type="text/javascript">
//分页
var config = {
		total: <%=(int)request.getAttribute("pageCount")%>, // 当前页面记录总条数
		current_page:<%=(int)request.getAttribute("currentPage")%> , // 当前页码
		page_size: 3, // 每页的记录数目
		display_home: false,
		display_skip: false
	};
	var pagination = new Pagination('pagination', config);
	pagination.onchange = function(page){
		var postId='<%=request.getAttribute("postId")%>';
		$("#commentShow").load("showCheckedPost", {"pageNo":page,"postId":postId}, function(data, statusTxt,xhr){
			
			    if(statusTxt=="error")
			      alert("系统异常！请稍后再试");
		});
	};
	//评论
	function submitComment(postId){
		var userId='<%=String.valueOf(session.getAttribute("userid"))%>';
		var commentContent=$("#commentContent").val();
		if(commentContent.trim()!=""){
		$.ajax({
			type: "post",
			url: "addLeaveWords",
			data: {postId: postId, userId:userId,commentContent:commentContent},
			success: function(html_data){
				alert("评论成功！");
				window.location.reload();
			},
			error: function(xhr,status,error){
				alert("系统异常！请稍后再试！");
			}
		}); 
		}
		else alert("请输入评论内容！");
	}
</script>
</html>