<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生旅游论坛</title>
<script src="jquery-3.3.1.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){	
		
		
	
		
		
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
	                    imgURL = file.getAsDataURL();
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
	//用户名校验
	function checkUserName(){
		var userName=$("#register_username").val();
		var name='<%=(String)session.getAttribute("username")%>';
		if(name==userName){
			userName="不可能重复的名字";
		}
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
	}
	
	function isUpdateValidate(form){
		 document.charset="utf-8";
		 userName=form.register_username.value;
		 school=form.school.value;
		 telephone=form.phone.value;
		 QQ=form.QQ.value;
		 introduce=form.introduce.value;
		 var  errorphone= document.getElementById("errorphone").innerText;
		 var  errorQQ= document.getElementById("errorQQ").innerText;
		 var file=document.getElementById("addphoto").value;
		 var errorUserName=document.getElementById("errorUserName").innerText;
		 if(userName.trim()==""){
			 alert("用户名不能为空！");
			 form.register_username.focus();
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
			 alert("该用户名已经注册,请更换用户名");
			 form.register_username.focus();
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
		 if(file==""){
			 alert("请上传个性图像！");
			 form.photoUpload.focus();
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

<form name="updateform" action="updateUser" method="post" enctype="multipart/form-data" onsubmit="return isUpdateValidate(updateform)" accept-charset="UTF-8">
<div id="line" >
|&nbsp;个&nbsp;人&nbsp;信&nbsp;息&nbsp;修&nbsp;改&nbsp;|
</div>
	<table id="register_table">
		<tr>
			<td class="word">用户名：</td>
			<td><input type="text" name="register_username" class="in" value="${personalInfo.userName}" id="register_username" onblur="checkUserName()">
			<br>
			</td>
			<td><label id="errorUserName"></label></td>
			
		</tr>
		
		<tr>
			<td class="word">性别：</td>
			<td colspan="2">
			<input type="radio" name="sex" value="boy" 
			<c:if test="${ personalInfo.sex == \"boy\"}">checked</c:if>>男
			<input type="radio" name="sex" value="girl"
			<c:if test="${ personalInfo.sex == \"girl\"}">checked</c:if>>女
			<br>
			</td>
			
		</tr>
		<tr>
			<td class="word">年龄：</td>
			<td>
				<select name="age" class="in">
					<option value="15"
					<c:if test="${ personalInfo.age == \"15\"}">selected</c:if>>15</option>
					<option value="16"
					<c:if test="${ personalInfo.age == \"16\"}">selected</c:if>>16</option>
					<option value="17"
					<c:if test="${ personalInfo.age == \"17\"}">selected</c:if>>17</option>
					<option value="18"
					<c:if test="${ personalInfo.age == \"18\"}">selected</c:if>>18</option>
					<option value="19"
					<c:if test="${ personalInfo.age == \"19\"}">selected</c:if>>19</option>
					<option value="20" 
					<c:if test="${ personalInfo.age == \"20\"}">selected</c:if>>20</option>
					<option value="21"
					<c:if test="${ personalInfo.age == \"21\"}">selected</c:if>>21</option>
					<option value="22"
					<c:if test="${ personalInfo.age == \"22\"}">selected</c:if>>22</option>
					<option value="23"
					<c:if test="${ personalInfo.age == \"23\"}">selected</c:if>>23</option>
					<option value="24"
					<c:if test="${ personalInfo.age == \"24\"}">selected</c:if>>24</option>
					<option value="25"
					<c:if test="${ personalInfo.age == \"25\"}">selected</c:if>>25</option>
					<option value="26"
					<c:if test="${ personalInfo.age == \"26\"}">selected</c:if>>26</option>
					<option value="27"
					<c:if test="${ personalInfo.age == \"27\"}">selected</c:if>>27</option>
					<option value="28"
					<c:if test="${ personalInfo.age == \"28\"}">selected</c:if>>28</option>
					<option value="29"
					<c:if test="${ personalInfo.age == \"29\"}">selected</c:if>>29</option>
					<option value="30"
					<c:if test="${ personalInfo.age == \"30\"}">selected</c:if>>30</option>
					
					
					
				</select>
			<br>
			</td>
			
				<td rowspan="3" ><img alt="addphoto" src="userphoto/${personalInfo.photo}" title="点击上传个性头像" id="addphoto"  >
			<input type="file" accept="image/*" id="file" name="photoUpload"  style="display: none;">
			
			</td>
		
			
		</tr>
		<tr>
			<td class="word">籍贯：</td>
			<td>
				<select name="hometown" class="in">
					<option value="Beijing" 
					<c:if test="${ personalInfo.hometown == \"Beijing\"}">selected</c:if>>北京</option>
					<option value="Shanghai"
					<c:if test="${ personalInfo.hometown == \"Shanghai\"}">selected</c:if>>上海</option>
					<option value="Tianjin"
					<c:if test="${ personalInfo.hometown == \"Tianjin\"}">selected</c:if>>天津</option>
					<option value="Chongqing"
					<c:if test="${ personalInfo.hometown == \"Chongqing\"}">selected</c:if>>重庆</option>
					
					<option value="Hebei"
					<c:if test="${ personalInfo.hometown == \"Heibei\"}">selected</c:if>>河北</option>
					<option value="Shanxi1"
					<c:if test="${ personalInfo.hometown == \"Shanxi1\"}">selected</c:if>>山西</option>
					<option value="Neimenggu"
					<c:if test="${ personalInfo.hometown == \"Neimenggu\"}">selected</c:if>>内蒙古</option>
					<option value="Liaoning"
					<c:if test="${ personalInfo.hometown == \"Liaoning\"}">selected</c:if>>辽宁</option>
					<option value="Jilin"
					<c:if test="${ personalInfo.hometown == \"JiLin\"}">selected</c:if>>吉林</option>
					<option value="Heilongjiang"
					<c:if test="${ personalInfo.hometown == \"HeiLongjiang\"}">selected</c:if>>黑龙江</option>
					<option value="Jiangsu"
					<c:if test="${ personalInfo.hometown == \"Jiangsu\"}">selected</c:if>>江苏</option>
					<option value="Zhejiang"
					<c:if test="${ personalInfo.hometown == \"Zhejiang\"}">selected</c:if>>浙江</option>
					<option value="Anhui"
					<c:if test="${ personalInfo.hometown == \"Anhui\"}">selected</c:if>>安徽</option>
					<option value="Fujian"
					<c:if test="${ personalInfo.hometown == \"Fujian\"}">selected</c:if>>福建</option>
					<option value="Jiangxi"
					<c:if test="${ personalInfo.hometown == \"Jiangxi\"}">selected</c:if>>江西</option>
					<option value="Shandong"
					<c:if test="${ personalInfo.hometown == \"Shandong\"}">selected</c:if>>山东</option>
					<option value="Henan"
					<c:if test="${ personalInfo.hometown == \"Henan\"}">selected</c:if>>河南</option>
					<option value="Hubei"
					<c:if test="${ personalInfo.hometown == \"Hubei\"}">selected</c:if>>湖北</option>
					<option value="Hunan"
					<c:if test="${ personalInfo.hometown == \"Hunan\"}">selected</c:if>>湖南</option>
					<option value="Guangdong"
					<c:if test="${ personalInfo.hometown == \"Guangdong\"}">selected</c:if>>广东</option>
					<option value="Guangxi"
					<c:if test="${ personalInfo.hometown == \"Guangxi\"}">selected</c:if>>广西</option>
					<option value="Hainan"
					<c:if test="${ personalInfo.hometown == \"Hainan\"}">selected</c:if>>海南</option>
					<option value="Sichuan"
					<c:if test="${ personalInfo.hometown == \"Sichuan\"}">selected</c:if>>四川</option>
					<option value="Guizhou"
					<c:if test="${ personalInfo.hometown == \"Guizhou\"}">selected</c:if>>贵州</option>
					<option value="Yunnan"
					<c:if test="${ personalInfo.hometown == \"Yunnan\"}">selected</c:if>>云南</option>
					<option value="Xizang"
					<c:if test="${ personalInfo.hometown == \"Xizang\"}">selected</c:if>>西藏</option>
					<option value="Shanxi2"
					<c:if test="${ personalInfo.hometown == \"Shanxi2\"}">selected</c:if>>陕西</option>
					<option value="Gansu"
					<c:if test="${ personalInfo.hometown == \"Gansu\"}">selected</c:if>>甘肃</option>
					<option value="Ningxia"
					<c:if test="${ personalInfo.hometown == \"Ningxia\"}">selected</c:if>>宁夏</option>
					<option value="Qinghai"
					<c:if test="${ personalInfo.hometown == \"Qinghai\"}">selected</c:if>>青海</option>
					<option value="Xinjiang"
					<c:if test="${ personalInfo.hometown == \"Xinjiang\"}">selected</c:if>>新疆</option>
					<option value="Hongkang"
					<c:if test="${ personalInfo.hometown == \"Hongkang\"}">selected</c:if>>香港</option>
					<option value="Aomen"
					<c:if test="${ personalInfo.hometown == \"Aomen\"}">selected</c:if>>澳门</option>
					<option value="Taiwan"
					<c:if test="${ personalInfo.hometown == \"Taiwan\"}">selected</c:if>>台湾</option>
				</select>
			<br>
			</td>
			<td></td>
			
		</tr>
		<tr>	
			
			<td class="word">学校</td>
			<td><input type="text" name="school" class="in" value="${personalInfo.school}">
			<br>
			</td>
			
		</tr>
		<tr>
			
			<td class="word">手机：</td>
			<td><input type="text" name="phone" class="in" id="phone" value="${personalInfo.telephone }">
			<br>
			</td>
			<td><label id="errorphone"></label></td>
			
		</tr>
		<tr>
			
			<td class="word">QQ：</td>
			<td><input type="text" name="QQ" class="in" id="QQ" value="${personalInfo.QQ }">
			<br>
			</td>
			<td><label id="errorQQ"></label></td>
			
		</tr>
		<tr>
			<td class="word" valign="top">自我介绍：</td>
			<td><textarea rows="10" cols="40" name="introduce" title="初印象很重要哦！">${personalInfo.introduce}</textarea>
			<br>
			</td>
			<td></td>
			
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="提交" id="register_button"></td>
			<td></td>
			
		</tr>

	</table>
	
</form>

</body>
</html>