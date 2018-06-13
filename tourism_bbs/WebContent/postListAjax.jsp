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
function init(){
		alert("${loginInfo}");
}
<c:if test="${!empty loginInfo}">
	window.onload=init;
</c:if>

function readMore(postId,postUserId){
	

	var userid=<%=session.getAttribute("userid")%>;
	if(userid==null){
		alert("查看详细信息，请先登录！");
	}
	else 
		 window.top.location='showPostDetail?postId='+postId+'&postUserId='+postUserId;
}


</script>
<style type="text/css">

	


	.select{
		height: 30px;
	}
	
	#select_span{
		width: 400px;
		height: 35px
	
	}
	
	#search_text{
		width:150px;
		height:25px;
		border: 1px solid gray;
		margin-bottom:5px;
		position: absolute;
		right: 120px;
	}
	#search_btn{
		width: 30px;
		height: 25px;
		position:absolute;
		right: 50px;
	
	}
	
	#content{
		width:80%;
		height:200px;
		margin-left: 10%;
		margin-top: 0px;
		margin-right: 10%;
		border-bottom: 1px solid gray;
		
		
	}
	
	#person_photo{
		height: 40px;
		width: 40px;
		
		
	
		
	}
	#grade{
		font-size: large;
		font-weight: bolder;
		color: yellow;
	
	}
	#collectnum,#commentnum,#timenum{
		color: gray;
		font-size: small;
		margin-top: 0px;
	}
	#viewimg{
		margin-left:20px;
		height: 180px;
	}

	#postdiv1{
		width:700px;
		height: 50px;
		text-align:center;
		margin-top:10px;
		padding-left:10px;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	#postdiv2{
		width:700px;
		padding-left:40px;
		white-space:nowrap;
		height:20px;
		margin-bottom:30px;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	#posthead{
		font-size: large;
		font-weight: bold;
	}
	#postContent{
		
		
	}
	
	#readmore{
		
		font-size: small;
		
	}
	
	
	
	a.a2:link{
		  color:red;
		  text-decoration:none; 
  }
  a.a2:hover{
  		  color:orange;
  }
  a.a2:visited{
		  color:gray;
  }
  
  a.a3:link{
		  color:#0066FF;
		  text-decoration:none; 
  }
  a.a3:hover{
  		  color:orange;
  }
  
	#zxj1{
		font-size: small;
		text-decoration: none;
		margin-left: 20px;
		
	}
	#zxj2{
		font-size: small;
		text-decoration: none;
		margin-left:150px;
	}
	
	#page{
		margin-top: 40px;
		text-align: center;
		margin-bottom: 40px;
	}
	
	
	
</style>
</head>
<body>
<div id="postListDiv">
	<c:forEach var="post" items="${postList}">
	<table id="content" >
		<tr height="50px"  id="tabhead">
			<td width="35%"  align="left">
				<img alt="person_photo" src="userphoto/${post.photo }" id="person_photo">
				&nbsp;
				<label id="author">${post.userName}</label>
				&nbsp;&nbsp;
				
				<label id="grade">V${post.level}</label>
			</td>
			<td align="right" width="35%">
				<img alt="like" src="images/collect.jpg" title="收藏人数" height="20px" width="20px">
			    <label id="collectnum">${post.postCollectionNum} </label>
			    &nbsp;&nbsp;
			    <img alt="comment" src="images/comment.jpg" title="评论的人数" height="20px" width="20px">
			    <label id="commentnum">${post.postCommentNum}</label>
			    &nbsp;&nbsp;
			    <img alt="time" src="images/time.jpg" title="发帖时间" height="20px" width="20px" >
			    <label id="timenum">${post.postTime}</label>
			</td>
			<td rowspan="4" >
				<img alt="view" src="picture/${post.picture}" title="大学生旅游" id="viewimg">
			</td>
		</tr>
		<tr height="50px">
			<td colspan="2" rowspan="2" id="postContent">
			<div id="postdiv1">
				<label id="posthead">${post.title}</label>
			</div>
			<div id="postdiv2">
				${post.postContent }
			</div>
			</td>
		</tr>
		<tr height="50px"></tr>
		<tr >
			<td ><div id="readmore" onclick="readMore(${post.postId},${post.postUserId })"><a href="javascript:;" id="read_a" class="a2" title="点击查看详细内容">>>READ &nbsp;&nbsp;MORE</a></div></td>
			<td>
			<span id="zxj1">
			<a href="javascript:;" id="style_a" class="a3"><label id="style_label" title="点击查看更多同方式帖子">${post.styleLabel}</label></a>
			</span>
			<span id="zxj2">
			<a href="javascript:;" id="place_a" class="a3"><label id="place_label" title="点击查看更多该景区帖子">${post.placeLabel }</label></a>
			</span>
			</td>
		</tr>
	</table>
	</c:forEach>
	</div>
	<div id="page">
	<div id="pagination" class="pagination"></div>
	</div>
	
</body>
<script type="text/javascript">
var config = {
		total: '<%=request.getAttribute("pageCount")%>', // 当前页面记录总条数
		current_page:'<%=request.getAttribute("currentPage")%>' , // 当前页码
		page_size: 5 // 每页的记录数目
	};
	var pagination = new Pagination('pagination', config);
	pagination.onchange = function(page){
		
		$("#postListDiv").load("changePostListByPage", {"pageNo":page}, function(data, statusTxt,xhr){
			
			    if(statusTxt=="error")
			      alert("系统异常！请稍后再试");
		});
	};
</script>

</html>