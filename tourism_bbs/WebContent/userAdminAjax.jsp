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
		height: 30px;
		margin-bottom: 5px;
		margin-left: 5px;
		font-size: large;
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
	<th>用户ID</th><th>用户名</th><th>手机</th><th>QQ</th><th>等级</th><th>Status</th><th></th>
</tr>
<c:forEach var="user" items="${userList}">
<tr>
	<td>${user.userId }</td><td>${user.userName }</td><td>${user.telephone }</td><td>${user.QQ }</td><td>V${user.level}</td><td>${user.status }</td><td><input type="button" value="▲" class="c" id="add" title="加一" onclick="add(${user.userId},${user.status })"><input type="button" value="▼" class="c" id="sub" title="减一" onclick="sub(${user.userId},${user.status })"></td>
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
		
		$("#table_div").load("showUserAdmin", {"pageNo":page}, function(data, statusTxt,xhr){
			
			    if(statusTxt=="error")
			      alert("系统异常！请稍后再试");
		});
	};
	
	function add(userId,status){
		var pageNo='<%=request.getAttribute("currentPage")%>';
		if(status<3){
			$("#table_div").load("adminOperation", {"userId":userId,"pageNo":pageNo,"style":"add"}, function(data, statusTxt,xhr){
				
				if(statusTxt=="success") alert("修改成功！");
			    if(statusTxt=="error")
			      alert("系统异常！请稍后再试");
		});
		}
		else alert("该用户的信誉值已达到上限，不能上升！");
	}
	function sub(userId,status){
		var pageNo='<%=request.getAttribute("currentPage")%>';
		if(status>0){
			$("#table_div").load("adminOperation", {"userId":userId,"pageNo":pageNo,"style":"sub"}, function(data, statusTxt,xhr){
				
				if(statusTxt=="success") alert("修改成功！");
			    if(statusTxt=="error")
			      alert("系统异常！请稍后再试");
		});
		}
		else alert("该用户的信誉值已达到下限，不能下降！");
		
	}
</script>
</html>