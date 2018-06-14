<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="pagination.css" rel="stylesheet">
<script src="pagination.js"></script>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	
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
	#input_userId{
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
<body>
	<div id="table_div">
   <table class="imagetable" align="center">
	<tr>
	<th>帖子ID</th><th>作者</th><th>标题</th><th>收藏数</th><th>评论数</th><th>发帖时间</th><th></th>
</tr>
<c:forEach var="post" items="${postList}">
<tr>
	<td>${post.postId }</td><td>${post.userName }</td><td>${post.title }</td><td>${post.postCollectionNum }</td><td>${post.postCommentNum}</td><td>${post.postTime }</td><td><input type="button" value="删除" class="c" id="delete" title="删除帖子" onclick="deletePost(${post.postId})"></td>
</tr>
</c:forEach>
</table>

<div id="page">
	<div id="pagination" class="pagination"></div>
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
	
	function deletePost(postId){
		if(confirm('您确定要删除该帖子?')){
			var pageNo='<%=request.getAttribute("currentPage")%>';
			
				$("#table_div").load("adminOperation", {"postId":postId,"pageNo":pageNo,"style":"delete"}, function(data, statusTxt,xhr){
					
					if(statusTxt=="success") alert("删除成功！");
				    if(statusTxt=="error")
				      alert("系统异常！请稍后再试");
			});
			
			
		}
		
	}
</script>
</html>