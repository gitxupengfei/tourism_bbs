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
		//用户名校验
		$("#register_username").blur(function () {
			var userName=$("#register_username").val();
			
			$.ajax({
    			type: "get",
    			url: "checkUserName;charset=UTF-8 ",
    			data: {userName: userName},
    			success: function(html_data){
    				
    				if(html_data=="Error"){
    					$("#errorUserName").text("×该用户名已注册！请更换！");
    					
    				}
    				else
    					$("#errorUserName").text("");
    			}
    		}); 
			
		});
		
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
		//QQ号校验
		$("#QQ").blur(function () {
			var regexQQ="[1-9][0-9]{4,14}";
			var QQ=$("#QQ").val();
			if(QQ=="" || QQ.match(regexQQ)){
				$("#errorQQ").text("");
			}
			else{
				$("#errorQQ").text("×请输入正确的QQ号！");
			}
			
		});
		//图片上传及显示
		$("#addphoto").click(function (){
			
			$("#file").click();
			
		});
		
		 var obj = document.getElementById("file");//input file对象 必须用document.get

//获取图片的绝对路径
	        function getObjectURL(node) {
	            var imgURL = "";
	            try {
	                var file = null;
	                if (node.files && node.files[0]) {
	                    file = node.files[0];
	                } else if (node.files && node.files.item(0)) {
	                    file = node.files.item(0);
	                }
	                //Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
	                try {
	                    //Firefox7.0
	                    imgURL = file.getAsDataURL();//转为base64编码
	                    //alert("//Firefox7.0"+imgRUL);
	                } catch (e) {
	                    //Firefox8.0以上
	                    imgURL = window.URL.createObjectURL(file);
	                    //alert("//Firefox8.0以上"+imgRUL);
	                }
	            } catch (e) {     
	                //支持html5的浏览器,比如高版本的firefox、chrome、ie10
	                if (node.files && node.files[0]) {
	                    var reader = new FileReader();
	                    reader.onload = function (e) {
	                        imgURL = e.target.result;
	                    };
	                    reader.readAsDataURL(node.files[0]);
	                }
	            }
	            
	            return imgURL;
	           
	        }
	      
	
		 
	        

	
		 $("#file").change(function () {
			 var filePath=getObjectURL(obj);
			$("#photoPath").val(filePath);
			
			
	            $("#addphoto").attr("src", filePath);//将图片的src变为获取到的路径
	        	
		 });
	
	});
	
	function isRegisterValidate(form){
		 document.charset="utf-8";
		 userName=form.register_username.value;
		 password=form.register_password.value;
		 question1=form.question1.value;
		 answer1=form.answer1.value;
		 question2=form.question2.value;
		 answer2=form.answer2.value;
		 school=form.school.value;
		 telephone=form.phone.value;
		 QQ=form.QQ.value;
		 introduce=form.introduce.value;
		 var  difpassword= document.getElementById("difpassword").innerText;
		 var  errorphone= document.getElementById("errorphone").innerText;
		 var  errorQQ= document.getElementById("errorQQ").innerText;
		 var errorUserName=document.getElementById("errorUserName").innerText;
		 var file=document.getElementById("file").value;
		 if(userName.trim()==""){
			 alert("用户名不能为空！");
			 form.register_username.focus();
			 return false;
		 }
		 if(password.trim()==""){
			 alert("密码不能为空！");
			 form.register_password.focus();
			 return false;
		 }
		 if(question1.trim()==""){
			 alert("密保问题不能为空！");
			 form.question1.focus();
			 return false;
		 }
		 if(answer1.trim()==""){
			 alert("密保答案不能为空！");
			 form.answer1.focus();
			 return false;
		 }
		 if(answer2.trim()==""){
			 alert("密保答案不能为空！");
			 form.answer2.focus();
			 return false;
		 }
		 if(question1.trim()==""){
			 alert("密保问题不能为空！");
			 form.question1.focus();
			 return false;
		 }
		 if(school.trim()==""){
			 alert("学校不能为空！");
			 form.school.focus();
			 return false;
		 }
		 if(telephone.trim()==""){
			 alert("手机号码不能为空！");
			 form.phone.focus();
			 return false;
		 }
		 
		 if(QQ.trim()==""){
			 alert("QQ不能为空！");
			 form.QQ.focus();
			 return false;
		 }
		 if(introduce.trim()==""){
			 alert("自我介绍不能为空！");
			 form.introduce.focus();
			 return false;
		 }
		 if(errorUserName.trim()!=""){
			 alert("该用户名已注册，请更换用户名！");
			 form.register_username.focus();
			 return false;
		 }
		 if(difpassword.trim()!=""){
			 alert("前后密码不一致！");
			 form.register_password.focus();
			 return false;
		 }
		 if(errorphone.trim()!=""){
			 alert("请输入正确的手机号码！");
			 form.phone.focus();
			 return false;
		 }
		 if(errorQQ.trim()!=""){
			 alert("请输入正确的QQ！");
			 form.QQ.focus();
			 return false;
		 }
		 if(file.trim()==""){
			 alert("请上传个性图像！");
			 form.QQ.focus();
			 return false;
		 }
		 return true;
	
	}
	

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
	
	#difpassword,#errorphone,#errorQQ,#errorUserName{
		font-size: small;
		color:red;
		
	}
	#addphoto{
		width:100px;
		height: 100px;
		
	}
	
</style>
</head>
<body>

<div>
	<jsp:include page="home_head.jsp"></jsp:include>
	

</div>
<form name="registerform" action="addUser" method="post" enctype="multipart/form-data" onsubmit="return isRegisterValidate(registerform)" accept-charset="UTF-8">
<div id="line" >
|&nbsp;注&nbsp;册&nbsp;论&nbsp;坛&nbsp;账&nbsp;号&nbsp;|
</div>
	<table id="register_table">
		<tr>
			<td class="word">用户名：</td>
			<td><input type="text" name="register_username" class="in" id="register_username">
			<br>
			</td>
			<td><label id="errorUserName"></label></td>
			
		</tr>
		<tr>
			<td class="word">登录密码：</td>
			<td><input type="password" name="register_password" class="in" id="login_password"><br></td>
			<td></td>
			
		</tr>
		<tr>
			<td class="word">确认密码：</td>
			<td><input type="password" class="in" name="confirm_password" id="confirm_password"><br></td>
			<td><label id="difpassword" ></label></td>
		</tr>
		<tr>
			<td class="word">密保问题1：</td>
			<td><input type="text" name="question1" class="in"><br></td>
			<td rowspan="3" ><img alt="addphoto" src="images/addphoto.jpg" title="点击上传个性头像" id="addphoto" >
			<input type="file" accept="image/*" id="file" name="photoUpload"  style="display: none;">
			
			</td>
		</tr>
		<tr>
		
			<td class="word">密保1答案：</td>
			<td><input type="text" name="answer1" class="in"><br></td>
			
		</tr>
		<tr>
			<td class="word">密保问题2：</td>
			<td><input type="text" name="question2" class="in"><br></td>
			
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
	
</form>

</body>
</html>