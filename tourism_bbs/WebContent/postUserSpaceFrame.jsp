<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生旅游论坛</title>
</head>

<frameset rows="170px,*"  border="0px" >
<frame src="personal_head.jsp" noresize="noresize">
<frameset cols="18%,*" border="6px" bordercolor="#0066FF">
<frame src="http://localhost:8080/tourism_bbs/showPostUserSpaceGuide?postUserId=${postUserId}" noresize="noresize" name="spaceLeft" >
<frame src="http://localhost:8080/tourism_bbs/showCheckedPost?postId=${postId }" noresize="noresize" name="spaceRight" >
</frameset>
	
</frameset> 

</html>