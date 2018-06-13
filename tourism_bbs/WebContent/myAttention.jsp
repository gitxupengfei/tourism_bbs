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
	var post='<%=request.getAttribute("attentionList")%>';
	
	var posting=document.getElementById("none");
	if(post=='[]'){
		posting.style.display="block";
	}
	else posting.style.display="none";
}
</script>
<style type="text/css">
	#attentions{
	  width: 700px;
	  padding: 15px;
	  margin-left:15%;
	  
	  display: grid;
	  grid-template-columns: repeat(5, 1fr);
	  grid-gap:10px;
	  grid-template-rows: auto;
	}
	.attention{
	  height: 150px;
	  border: 1px solid #0066FF; 
	 border-radius: 15px;
	 background-color: #D4D4D4;
	 margin-left: 20px;
	}
	.head{
		height: 23px;
		margin-bottom: 7px;
		 font-weight: bolder;
		 color: yellow;
	}
	.photo{
		height: 50px;
		margin-bottom: 10px;
		 padding-left: 10px;
		 text-align: center;
		 
	}
	
	.delete{
		height: 20px;
		width: 20px;
		margin-left: 55px;
		cursor: pointer;
		margin-top: 3px;
		
	}
	.img{
		height: 50px;
		width: 50px;
		border-radius: 25px;
	}
	.name{
		height: 20px;
		margin-bottom: 10px;
		text-align: center;
		font-weight: bolder;
		color: white;
	}
	.school{
		height: 20px;
		text-align: center;
		font-size: small;
		color: blue;
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
	#none{
		margin-top:100px;
		padding-left: 200px;
		font-size: larger;
		font-weight:bolder;
		color: gray;
	}
</style>
</head>
<body onload="init()">
<div id="line" >
|&nbsp;我&nbsp;的&nbsp;关&nbsp;注&nbsp;|
</div>
<div id="none">您还未关注过任何用户！</div>
	<div id="attentions">
	<c:forEach var="attention" items="${attentionList}">
		<div class="attention">
		<div class="head">
		&nbsp;V${attention.attLevel}
		<img alt="删除" src="images/delete.jpg" title="点击取消关注" class="delete"
		onclick="deleteAtt(${attention.attentionId})" >
		</div>
		<div class="photo">
			<img alt="用户图像" src="userphoto/${attention.attPhoto }" class="img">
		</div>
		<div class="name">${attention.attToUserName}</div>
		<div class="school">${attention.attSchool}</div>
		</div>
		</c:forEach>
	</div>
</body>
<script type="text/javascript">

	
	
	//取消关注


	function deleteAtt(id){
		var msg = "确定要取消关注吗？";  
        if (confirm(msg)==true){  
        	$.ajax({
    			type: "get",
    			url: "deleteMyPost",
    			data: {attentionId: id},
    			success: function(html_data){
    				window.location.reload();
    			},
    			error:function(html_data){
    				alert("系统异常，请稍后再试！");
    			}
    		}); 
        } 
		
	}
</script>
</html>