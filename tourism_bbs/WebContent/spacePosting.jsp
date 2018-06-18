<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
	function isPostingValidate(form){
		title=form.title.value;
		place=form.place.value;
		picture=form.picture.value;
		content=form.postContent.value;
		if(title.trim()==""){
			alert("请输入帖子标题！");
			form.title.focus();
			return false;
		}
		if(place.trim()==""){
			alert("请输入地点标签！");
			form.place.focus();
			return false;	
		}
		if(picture.trim()==""){
			alert("请上传一张旅游图片！");
			form.picture.focus();
			return false;
		}
		if(content.trim()==""){
			alert("请输入帖子内容！");
			form.postContent.focus();
			return false;
			
		}
		return true;
		
	}
	$(document).ready(function(){
	
		$("#upPicture").click(function (){
			
			$("#picture").click();
			
			
		});
		
		$("#picture").change(function(){
			if($("#picture").val()!=""){
				$("#upPicture").val("更改图片");
			}
			else $("#upPicture").val("上传图片");
			  
			});
		
	});
</script>
<style type="text/css">
	#posting_button{
		font-weight: bolder;
		font-size: x-large;
		color:white;
		background-color:#0066FF;
		height: 40px;
		width: 200px;
		margin-bottom: 20px;
		margin-left: 100px;
		margin-top: 20px;
	
	}
	.font{
		font-weight: bolder;
	
		}
	#title {
		height: 20px;
		width:250px;
}
   #select{
   		height: 20px;
		width:80px;
   }
   #place{
   		height: 20px;
		width:120px;
   }
   #picture{
   		display: none;
	
   }
   td{
   	padding-top: 10px;
   }
  #posting_table{
  		margin-left: 100px;
  }
  #upPicture{
  	height: 30px;
  	width: 80px;
  	color:white;
  	background-color:#0066FF; 
  }
  
</style>
</head>
<body>
<form action="posting" name="postingform" method="post" enctype="multipart/form-data" onsubmit="return isPostingValidate(postingform)">
	<table id="posting_table">
		<tr>
			<td class="font">标题：</td>
			<td><input type="text" id="title" name="title"></td>
			<td><label class="note" id="titleNote"></label></td>
		</tr>
		<tr>
			<td class="font">出行方式：</td>
			<td>
				<select name="style" id="select">
				<option value="任何方式" selected="selected">任何方式</option>
				<option value="步行">步行</option>
				<option value="自行车">自行车</option>
				<option value="汽车">汽车</option>
				<option value="火车">火车</option>
				<option value="飞机">飞机</option>
				<option value="轮船">轮船</option>
	
			</select>
			</td>
			<td></td>
		</tr>
		<tr>
			<td class="font">目的地：</td>
			<td><input type="text" id="place" name="place"></td>
			<td><label class="note" id="placeNote"></label></td>
		</tr>
		<tr>
			<td class="font">图片：</td>
			<td>
			<input type="button" name="upload" id="upPicture" value="上传图片" title="点击上传图片">
			<input type="file" accept="image/*" id="picture" name="picture" >
			</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3">
				<textarea rows="30" cols="80" name="postContent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="发表" id="posting_button">
			</td>
		</tr>
	</table>

</form>
</body>
</html>