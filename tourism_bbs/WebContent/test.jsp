<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生旅游论坛</title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
	.box {
  background: orange;
  height: 100px;
  line-height: 100px;
  text-align: center;
  color: #fff;
  font-size: 3em;
  margin: 5px 15px 5px 0;
}
/* .box:nth-child(even){
  background: green;
} */

.wrapper {
  width: 560px;
  border: 1px solid orange;
  padding: 15px;
  margin: 20px auto;
  
  display: grid;
  grid-template-columns: repeat(5, 115px);
  grid-template-rows: auto;
}
	
</style>
</head>
<body>
	<div class="wrapper">
  <div class="box a">A</div>
  <div class="box b">B</div>
  <div class="box c">C</div>
  <div class="box d">D</div>
  <div class="box e">E</div>
  <div class="box f">F</div>
  <div class="box h">H</div>
  <div class="box i">I</div>
  <div class="box j">J</div>
  <div class="box k">K</div>
  <div class="box l">L</div>
  <div class="box m">M</div>
  <div class="box n">N</div>
  <div class="box o">O</div>
</div>
</body>
</html>