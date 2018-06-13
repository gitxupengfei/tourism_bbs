<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#leave_btn").click(function(){
	   
		  $("#leaveWords").slideToggle("slow");
	    
	  });
	  //提交留言
	  
	 
	});
	
		function submit(postUserId){
			
			var userId=<%=String.valueOf(session.getAttribute("userid"))%>;
			var leaveWords=$("#leaveContent").val();
			$.ajax({
    			type: "post",
    			url: "addLeaveWords",
    			data: {postUserId: postUserId, userId:userId,leaveWords:leaveWords},
    			success: function(html_data){
    				alert("留言成功！");
    				window.location.reload();
    			},
    			error: function(xhr,status,error){
    				alert("系统异常！请稍后再试！");
    			}
    		}); 
		}
		//关注
		function attention(postUserId){
			
			var userId=<%=String.valueOf(session.getAttribute("userid"))%>;
		
			$.ajax({
    			type: "get",
    			url: "addAttention",
    			data: {postUserId: postUserId, userId:userId},
    			success: function(html_data){
    				
    				if(html_data=='OK') {
    					alert("关注成功！");
    				}
    				else	alert("您已经关注了该用户！");
    				
    			},
    			error: function(xhr,status,error){
    				alert("系统异常！请稍后再试！");
    			}
    		}); 
		}
		
</script>
<style type="text/css">
	#personalPhotoDiv{
		padding-top: 30px;
		padding-bottom:30px;
		border-bottom: 3px solid #0066FF;
		margin-bottom: 30px;
	}
	#personalPhoto{
		height: 50px;
		width:50px;
		border-radius: 25px;
	}
	#userName{
		font-weight: bold;
		margin-bottom: 20px;
	}
	.sgtr{
		font-size: small;
		font-weight: bold;
		text-align: center;
		
	}
	#gradetd{
		font-size: medium;
		color: yellow;
	}
	#guideList{
		width: 150px;
		margin-top: 30px;
		text-align: center;
		font-weight: bold;
		color: white;
	}
	#redPoint{
	font-size:larger;
	font-weight: bolder;
	vertical-align: middle;
	color: red;
	}
	.space_a{
		text-decoration: none;
		 cursor:pointer;
		 color: white;
		
	}
	#attention{
		margin-right: 5px;
		margin-bottom: 5px;
	}
	#att_btn{
		height: 30px;
		width: 60px;
		background-color: white;
		color: red;
		border-color: red;
		cursor: pointer;
	}
	#leave_btn{
		height: 40px;
		width: 80px;
		background-color: #0066FF;
		color:white;
		font-weight: bolder;
		cursor: pointer;
		margin-top: 20px;
	}
	#leaveContent{
		border-color:  #0066FF;
		
	}
	#leaveWords{
		display: none;
	}
	#submit{
		background-color:  #0066FF;
		width: 150px;
		color:white;
		height: 25px;
		cursor: pointer;
	}
	#introduce{
		padding-left: 5px;
		padding-right: 5px;
	}
	
</style>
</head>
<body>
<div id="personalPhotoDiv" align="center">
    <div id="attention" align="right">
    	<button id="att_btn" onclick="attention(${user.userId})">关&nbsp;注</button>
    </div>
	<img alt="用户头像" src="userphoto/${user.photo}" id="personalPhoto">
	<br>
	<br>
	<label id="userName">${user.userName }</label>
	<br>
	<br>
	<table width="150px">
	<tr class="sgtr">
	<td>等级</td>
	<td>粉丝</td>
	<td>积分</td>
	</tr>
	<tr class="sgtr">
	<td id="gradetd"><label >V${user.level}</label></td>
	<td><label>${user.attentionNum }</label></td>
	<td><label>${user.experienceNum }</label></td>
	</tr>
	</table>
	<div id="leaveWordsDiv">
	<button id="leave_btn" >留&nbsp;&nbsp;言</button>
	</div>
	<div id="leaveWords">
	<div>
		<textarea rows="10" cols="20" id="leaveContent"></textarea>
	</div>
	<div id="submit" onclick="submit(${user.userId})">
		提&nbsp;&nbsp;&nbsp;&nbsp;交
	</div>
	</div>
	
</div>
<div align="center" id="introduce">
	${user.introduce}
</div>
</body>
</html>