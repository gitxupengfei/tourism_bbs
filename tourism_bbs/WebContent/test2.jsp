<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable th {
	background:#b5cfd2 url('images/cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	background:#dcddc0 url('images/cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
#b{
	width: 60px;
	height: 30px;
}
td{
	text-align: center;
}
table{
	width: 600px;
}
.c{
	width:20px;
	height: 20px;
	margin-bottom: 5px;
}
</style>
</head>

 <body>
 <input type="button" id="b" value="删除">
 <br>
 <br>
 <br>
 <br>
 
    <table class="imagetable" align="center">
<tr>
	<th> <input type="radio"></th><th>用户ID</th><th>用户名</th><th>手机</th><th>QQ</th><th>等级</th><th>Status</th><th></th>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>21</td><td>张三</td><td>17853270001</td><td>1000001</td><td>V1</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>22</td><td>李四</td><td>17853270002</td><td>1000002</td><td>V1</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>24</td><td>王五</td><td>17853270004</td><td>1000004</td><td>V3</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>24</td><td>路飞</td><td>17853290909</td><td>100034201</td><td>V1</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>26</td><td>张飞</td><td>15653270001</td><td>29817001</td><td>V2</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>30</td><td>刘星</td><td>15698302831</td><td>105555501</td><td>V1</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
<tr>
	<td align="center"> <input type="radio"></td>
	<td>31</td><td>吴用</td><td>17853470001</td><td>13330001</td><td>V1</td><td>3</td><td><input type="button" value="+" class="c"><br><input type="button" value="-" class="c"></td>
</tr>
</table>
   </body>
</html>


