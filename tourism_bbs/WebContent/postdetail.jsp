<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
		
		
		function init(postUserId){
			var userId=<%=String.valueOf(session.getAttribute("userid"))%>;
			if(postUserId==userId){
				$("#collection_div").hide();
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
</body>
</html>