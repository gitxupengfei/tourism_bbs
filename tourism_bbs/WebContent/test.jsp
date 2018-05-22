<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎注册</title>
<script src="jquery-3.3.1.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#confirm_password").blur(function() {
			var login_password=$("#login_password").val();
			var confirm_password=$("#confirm_password").val();
			if(login_password!=confirm_password){
				$("#difpassword").text("×前后密码输入不一致！");
			}
			else
				$("#difpassword").text("");
			
		});
		
		
		$("#phone").blur(function() {
			var regexphone="^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
			var phone=$("#phone").val();
			if(phone=="" || phone.match(regexphone)){ 
				$("#errorphone").text("");
				
				
			}
			else{
				$("#errorphone").text("×请输入正确的手机号！");
			}
			
		});
		
		$("#QQ").blur(function () {
			var regexQQ="[1-9][0-9]{4,14}";
			var QQ=$("#QQ").val();
			if(QQ=="" ||QQ.match(regexQQ)){
				$("#errorQQ").text("");
			}
			else{
				$("#errorQQ").text("×请输入正确的QQ号！");
			}
			
		});
	});

</script>
<style type="text/css">
	.word{
		font-weight: bolder;
	}
	#line{
		font-weight: 400;
		font-size:x-large;
		color: gray;
		background-image: url("images/line.PNG");
		height: 50px;
		padding-left: 10%;
		padding-top: 10px;
	}
	#register_table{
		margin-left: 20%;
		text-align: left;
		color: gray;
	}
	.in {
		height: 20px;
		width:200px;
}

	#register_button{
		font-weight: bolder;
		font-size: x-large;
		color:white;
		background-color:#0066FF;
		height: 40px;
		width: 200px;
		margin-bottom: 20px;
	
	}
	
	#difpassword,#errorphone,#errorQQ{
		font-size: small;
		color:red;
		
	}
	#photo_span{
		width: 100px;
		height: 100px;
		margin-left: 50px;
		margin-top: 50px;
	}
</style>
</head>
<body>
<form action="register_table">
<div>
	<jsp:include page="home_head.jsp"></jsp:include>
	

</div>
<div id="line" >
|&nbsp;注&nbsp;册&nbsp;论&nbsp;坛&nbsp;账&nbsp;号&nbsp;|
</div>
	<table id="register_table">
		<tr>
			<td class="word">用户名：</td>
			<td><input type="text" name="login_username" class="in">
			<br>
			</td>
			<td></td>
		</tr>
		<tr>
			<td class="word">登录密码</td>
			<td><input type="password" name="login_password" class="in" id="login_password"><br></td>
			<td></td>
		</tr>
		<tr>
			<td class="word">确认密码</td>
			<td><input type="password" class="in" name="confirm_password" id="confirm_password"><br></td>
			<td><label id="difpassword"></label></td>
		</tr>
		<tr>
			<td class="word">密保问题1：</td>
			<td><input type="text" name="question1" class="in"><br></td>
			<td></td>
		</tr>
		<tr>
			<td class="word">密保1答案：</td>
			<td><input type="text" name="answer1" class="in"><br></td>
			<td></td>
		</tr>
		<tr>
			<td class="word">密保问题2：</td>
			<td><input type="text" name="question2" class="in"><br></td>
			<td></td>
		</tr>
		<tr>
			<td class="word">密保2答案：</td>
			<td><input type="text" name="answer2" class="in"><br></td>
			<td></td>
		</tr>
		<tr>
			<td class="word">性别：</td>
			<td colspan="2">
			<input type="radio" name="sex" value="boy" checked="checked">男
			<input type="radio" name="sex" value="girl">女
			<br>
			</td>
			
		</tr>
		<tr>
			<td class="word">年龄：</td>
			<td>
				<select name="age" class="in">
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20" selected="selected">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					
					
					
				</select>
			<br>
			</td>
			<td></td>
		</tr>
		<tr>
			<td class="word">籍贯：</td>
			<td>
				<select name="hometown" class="in">
					<option value="Beijing" selected="selected" >北京</option>
					<option value="Shanghai">上海</option>
					<option value="Tianjin">天津</option>
					<option value="Chongqing">重庆</option>
					<option value="Beijing">北京</option>
					<option value="Hebei">河北</option>
					<option value="Shanxi1">山西</option>
					<option value="Neimenggu">内蒙古</option>
					<option value="Liaoning">辽宁</option>
					<option value="Jilin">吉林</option>
					<option value="Heilongjiang">黑龙江</option>
					<option value="Jiangsu">江苏</option>
					<option value="Zhejiang">浙江</option>
					<option value="Anhui">安徽</option>
					<option value="Fujian">福建</option>
					<option value="Jiangxi">江西</option>
					<option value="Shandong">山东</option>
					<option value="Henan">河南</option>
					<option value="Hubei">湖北</option>
					<option value="Hunan">湖南</option>
					<option value="Guangdong">广东</option>
					<option value="Guangxi">广西</option>
					<option value="Hainan">海南</option>
					<option value="Sichuan">四川</option>
					<option value="Guizhou">贵州</option>
					<option value="Yunnan">云南</option>
					<option value="Xizang">西藏</option>
					<option value="Shanxi2">陕西</option>
					<option value="Gansu">甘肃</option>
					<option value="Ningxia">宁夏</option>
					<option value="Qinghai">青海</option>
					<option value="Xinjiang">新疆</option>
					<option value="Hongkang">香港</option>
					<option value="Aomen">澳门</option>
					<option value="Taiwan">台湾</option>
				</select>
			<br>
			</td>
			<td></td>
		</tr>
		<tr>
			<td class="word">学校</td>
			<td><input type="text" name="school" class="in">
			<br>
			</td>
		</tr>
		<tr>
			<td class="word">手机：</td>
			<td><input type="text" name="phone" class="in" id="phone">
			<br>
			</td>
			<td><label id="errorphone"></label></td>
		</tr>
		<tr>
			<td class="word">QQ：</td>
			<td><input type="text" name="QQ" class="in" id="QQ">
			<br>
			</td>
			<td><label id="errorQQ"></label></td>
		</tr>
		<tr>
			<td class="word" valign="top">自我介绍：</td>
			<td><textarea rows="10" cols="40" name="introduce" title="初印象很重要哦！"></textarea>
			<br>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="注册" id="register_button"></td>
			<td></td>
		</tr>

	</table>
	<span id="photo_span">
	<img alt="addphoto" src="images/addphoto.jpg" title="点击上传个性头像">
	</span>
</form>

</body>
</html>