<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
	
	#d{
		width:500px;
		word-break: break-all;
		word-wrap: break-word;'
         
		
	}
</style>
</head>
<body>
<img alt="go" src="picture/<%=(String)request.getAttribute("picture")%> " />  
<br>
<div id="d">

<%=(String)request.getAttribute("postContent")%>

</div>
</body>
</html>