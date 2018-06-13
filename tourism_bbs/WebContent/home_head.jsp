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
	//登录
	  $("#a_login").click(function(){
		   
		   
		  $(".lock").css("height",$(document).height());     
		  $(".lock").css("width",$(window).width()); 
		  $(".lock").show();

		  $("#login").show();
	  });
	//登录取消
	$("#cancle").click(function(){
		$(".lock").hide();
		 $("#login").hide();
	});
	//注册页跳转
	 $("#a_register").click(function(){
		 
		 window.location.href='register.jsp';
	 });
	//返回主页
	 $("#a_home").click(function(){
		 window.location.href='home';
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
        width:60px;
        position:absolute;
        top:0px;
        right:0px;
        background-image: url("images/menu.jpg");
        cursor: pointer;
  }
  
  #head{
		background-color:#1C86EE;
  
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
  #login{
  	width:330px;
  	height:330px;
  	left:30%;
  	top:30%;
  	position:absolute;
  	display:none;
  background-color:white;
  	z-index: 9999;
  	
  }
  
  #cancle{
  width:30px;
  height:30px;
  margin-top: 0px;
  margin-right: 0px;
  cursor: pointer;
  
  }
   .lock{ 
    background-color:#000000;
    position: absolute;
    top: 0px;
    left: 0px;
    filter:alpha(opacity=30); /*IE滤镜，透明度50%*/
    -moz-opacity:0.3; /*Firefox私有，透明度50%*/
    opacity:0.3;/*其他，透明度50%*/
    z-index: 999;/* 层叠顺序 */  
}
</style>
</head>
<body>
<div id="body"  >
  <div id="head">
	<input type="button" title="点击查看菜单" id="menu">
	</div>
	<img alt="大学生旅游论坛" src="images/headbg.jpg" id="headbg">

<div id="panel" >
    <p>
	<a href="javascript:;" id="a_login" class="a1">登录</a><br>
	<p>
	<a href="javascript:;" class="a1" id="a_register">注册</a>
	<p>
	<a href="javascript:;" class="a1" id="a_home">主页</a>
</div>
</div>
<div id="login" align="right">
<img alt="关闭" src="images/cancle.PNG" title="取消登录" id="cancle">
	<jsp:include page="login.jsp"></jsp:include>
</div>
<div class="lock"></div> 
</body>
</html>