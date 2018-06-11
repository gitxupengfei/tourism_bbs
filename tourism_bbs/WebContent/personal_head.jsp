<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tourism_forum</title>
<script src="jquery-3.3.1.js"></script>
<script >

$(document).ready(function(){
	
	
	//菜单
	  $("#menu").click(function(){
	    $("#panel").slideToggle("slow");
	  });
	
	
	//个人中心页跳转
	 $("#a_personalcenter").click(function(){
		 
		 window.top.location='spaceIframe.jsp';
	 });
	//返回主页
	 $("#a_personalhome").click(function(){
		 window.top.location='home';
	 });
	
	
	 
	});
	
</script>
<style type="text/css">
body{
       margin:0px;
       
}
  #body{
  		
  		height:150px;
  }
  #menu{
        height:40px;
        width:40px;
        position:absolute;
        top:0px;
        right:0px;
      	 cursor:pointer;
  }
  
  #head{
		background-color:#1C86EE;
		border-radius: 40px;
  
  }
  #headbg{
  		height:100%;
  		width:100%;
  
  }
  a.a1:link{
  color:white;
  text-decoration:none; 
  }
  a.a1:hover{
  color:orange;
  }
  a.a1:visited{
  color:white;
  }
  
  #panel{
  width:60px;
  position:absolute;
  top:40px;
  right:0px;
   text-align:center;
   background-color:blue;
   display:none;
  
  }
  
      

}
</style>
</head>
<body  >
<div id="body"  >
  <div id="head">
	
	<img alt="menu" src="userphoto/${sessionScope.photo}" title="点击查看菜单" id="menu">
	
	</div>
	<img alt="大学生旅游论坛" src="images/headbg.jpg" id="headbg">

<div id="panel" >
    <p>
	<a href="javascript:;" target="_top" id="a_personalcenter" class="a1">空间</a><br>
	<p>
	<a href="javascript:;" target="_top" class="a1" id="a_personalhome">主页</a>
	<p>
	<a href="javascript:if(confirm('您确定要退出当前用户吗?'))top.location='exitLogin'" target="top" class="a1" id="a_exit">注销</a>
</div>
</div>


</body>
</html>