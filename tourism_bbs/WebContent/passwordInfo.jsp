<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="jquery-3.3.1.js">
</script>
<script type="text/javascript">
$(document).ready(function(){
		<%-- alert("<%=request.getAttribute("answer1")%>"); --%>
	});

</script>
<style type="text/css">
	.pdiv{
		font-weight: bold;
		margin-bottom: 5px;
		width: 300px;
		background-color:#CCCCCC;
		height: 30px;
		color: #8B6914;
	}
	#ppdiv{
		font-weight: bolder;
		margin-bottom: 5px;
		width: 300px;
		background-color: #C5C1AA;
		height: 35px;
		text-align: center;
		padding-bottom: 10px;
		color: #8B6914;
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
	#con{
		padding-left: 30%;
		padding-top: 30px;
	}
</style>
</head>
<body>
	<div>
	<jsp:include page="home_head.jsp"></jsp:include>
    </div>
    <div id="line" >
|&nbsp;密&nbsp;码&nbsp;找&nbsp;回&nbsp;|
</div>
<div id="con">
	<div id="ppdiv">
	<div style="height: 10px;"></div>
		您的用户名和密码信息如下：
	</div >
	<div class="pdiv">
		用户名：&nbsp;&nbsp; ${userName}
	</div>
	<div class="pdiv">
		密码：&nbsp;&nbsp; ${password}
	</div>
</div>
</body>
</html>