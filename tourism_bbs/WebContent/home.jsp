<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生旅游论坛</title>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//READ MORE跳转！
	
	$("#read_a").click(function(){
	 	window.location.href='post.jsp';
	});
});
</script>
<style type="text/css">
	#order{
		background-image: url("images/line.PNG");
		height: 50px;
		padding-left: 3%;
		padding-top: 15px;
		
	}


	.select{
		height: 30px;
	}
	
	#select_span{
		width: 400px;
		height: 35px
	
	}
	
	#search_text{
		width:150px;
		height:25px;
		border: 1px solid gray;
		margin-bottom:5px;
		position: absolute;
		right: 120px;
	}
	#search_btn{
		width: 30px;
		height: 25px;
		position:absolute;
		right: 50px;
	
	}
	
	#content{
		width:80%;
		height:200px;
		margin-left: 10%;
		margin-top: 0px;
		margin-right: 10%;
		border-bottom: 1px solid gray;
		
		
	}
	
	#person_photo{
		height: 40px;
		width: 40px;
		
		
	
		
	}
	#grade{
		font-size: large;
		font-weight: bolder;
		color: yellow;
	
	}
	#collectnum,#commentnum,#timenum{
		color: gray;
		font-size: small;
		margin-top: 0px;
	}
	#viewimg{
		margin-left:20px;
		height: 180px;
	}

	#postdiv1{
		width:700px;
		height: 50px;
		text-align:center;
		margin-top:10px;
		padding-left:10px;
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	#postdiv2{
		width:700px;
		height: 50px;
		text-align:center;
		
		padding-left:10px;
		white-space:nowrap;
		
		overflow:hidden;
		text-overflow:ellipsis;
	}
	#posthead{
		font-size: large;
		font-weight: bold;
	}
	#postbody{
		
	
	}
	#readmore{
		
		font-size: small;
		
	}
	
	
	
	a.a2:link{
		  color:red;
		  text-decoration:none; 
  }
  a.a2:hover{
  		  color:orange;
  }
  a.a2:visited{
		  color:gray;
  }
  
  a.a3:link{
		  color:#0066FF;
		  text-decoration:none; 
  }
  a.a3:hover{
  		  color:orange;
  }
  
	#zxj1{
		font-size: small;
		text-decoration: none;
		margin-left: 20px;
		
	}
	#zxj2{
		font-size: small;
		text-decoration: none;
		margin-left:150px;
	}
	
	
	
</style>
</head>
<body>
	<div>
	<jsp:include page="home_head.jsp"></jsp:include>
    </div>
	<div id="order" >
	
	<span id="select_span">
	排序方式：<select name="order" class="select">
				<option value="no" selected="selected">无排序</option>
				<option value="hot">热度</option>
				<option value="great">好评</option>
				<option value="famous">名家</option>
		</select>
	&nbsp;&nbsp;&nbsp;&nbsp;
	出行方式：<select name="style" class="select">
				<option value="any" selected="selected">任何方式</option>
				<option value="foot">步行</option>
				<option value="bike">自行车</option>
				<option value="bus">汽车</option>
				<option value="train">火车</option>
				<option value="plane">飞机</option>
				<option value="boat">轮船</option>
	
			</select>
</span>
			<input type="text" name="search_text" id="search_text">
			<img alt="button" src="images/search.jpg" title="点击搜索" id="search_btn">
</div>
	<table id="content" >
		<tr height="50px"  id="tabhead">
			<td width="35%"  align="left">
				<img alt="person_photo" src="images/menu.jpg" id="person_photo">
				&nbsp;
				<label id="author">name</label>
				&nbsp;&nbsp;
				<label id="grade">V1</label>
			</td>
			<td align="right" width="35%">
				<img alt="like" src="images/collect.jpg" title="收藏人数" height="20px" width="20px">
			    <label id="collectnum">101</label>
			    &nbsp;&nbsp;
			    <img alt="comment" src="images/comment.jpg" title="评论的人数" height="20px" width="20px">
			    <label id="commentnum">20</label>
			    &nbsp;&nbsp;
			    <img alt="time" src="images/time.jpg" title="发帖时间" height="20px" width="20px" >
			    <label id="timenum">2018-01-01 9:20</label>
			</td>
			<td rowspan="4" >
				<img alt="view" src="images/viewtest.jpg" title="大学生旅游" id="viewimg">
			</td>
		</tr>
		<tr height="50px">
			<td colspan="2" rowspan="2">
			<div id="postdiv1">
				<label id="posthead">醉美黄山之行！</label>
			</div>
			<div id="postdiv2">
				<label id="postbody">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄山：世界文化与自然双重遗产，世界地质公园，国家AAAAA级旅游景区，国家级风景名胜区，全国文明风景旅游区示范点，中华十大名山，天下第一奇山。
黄山位于安徽省南部黄山市境内，有72峰，主峰莲花峰海拔1864米，与光明顶、天都峰并称三大黄山主峰，为36大峰之一。黄山是安徽旅游的标志，是中国十大风景名胜唯一的山岳风光。
黄山原名“黟山”，因峰岩青黑，遥望苍黛而名。后因传说轩辕黄帝曾在此炼丹，故改名为“黄山”。黄山代表景观有“四绝三瀑”，四绝：奇松、怪石、云海、温泉；三瀑：人字瀑、百丈泉、九龙瀑。黄山迎客松是安徽人民热情友好的象征，承载着拥抱世界的东方礼仪文化。
				</label>
			</div>
			</td>
		</tr>
		<tr height="50px"></tr>
		<tr >
			<td ><div id="readmore"><a href="javascript:;" id="read_a" class="a2" title="点击查看详细内容">>>READ &nbsp;&nbsp;MORE</a></div></td>
			<td>
			<span id="zxj1">
			<a href="javascript:;" id="style_a" class="a3"><label id="style_label" title="点击查看更多同方式帖子">自行车</label></a>
			</span>
			<span id="zxj2">
			<a href="javascript:;" id="place_a" class="a3"><label id="place_label" title="点击查看更多该景区帖子">黄山</label></a>
			</span>
			</td>
		</tr>
	</table>
	
	<!-- 添加的table测试 -->
	<table id="content" >
		<tr height="50px"  id="tabhead">
			<td width="35%"  align="left">
				<img alt="person_photo" src="images/menu.jpg" id="person_photo">
				&nbsp;
				<label id="author">name</label>
				&nbsp;&nbsp;
				<label id="grade">V1</label>
			</td>
			<td align="right" width="35%">
				<img alt="like" src="images/collect.jpg" title="收藏人数" height="20px" width="20px">
			    <label id="collectnum">101</label>
			    &nbsp;&nbsp;
			    <img alt="comment" src="images/comment.jpg" title="评论的人数" height="20px" width="20px">
			    <label id="commentnum">20</label>
			    &nbsp;&nbsp;
			    <img alt="time" src="images/time.jpg" title="发帖时间" height="20px" width="20px" >
			    <label id="timenum">2018-01-01 9:20</label>
			</td>
			<td rowspan="4" >
				<img alt="view" src="images/viewtest.jpg" title="大学生旅游" id="viewimg">
			</td>
		</tr>
		<tr height="50px">
			<td colspan="2" rowspan="2">
			<div id="postdiv1">
				<label id="posthead">醉美黄山之行！</label>
			</div>
			<div id="postdiv2">
				<label id="postbody">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄山：世界文化与自然双重遗产，世界地质公园，国家AAAAA级旅游景区，国家级风景名胜区，全国文明风景旅游区示范点，中华十大名山，天下第一奇山。
黄山位于安徽省南部黄山市境内，有72峰，主峰莲花峰海拔1864米，与光明顶、天都峰并称三大黄山主峰，为36大峰之一。黄山是安徽旅游的标志，是中国十大风景名胜唯一的山岳风光。
黄山原名“黟山”，因峰岩青黑，遥望苍黛而名。后因传说轩辕黄帝曾在此炼丹，故改名为“黄山”。黄山代表景观有“四绝三瀑”，四绝：奇松、怪石、云海、温泉；三瀑：人字瀑、百丈泉、九龙瀑。黄山迎客松是安徽人民热情友好的象征，承载着拥抱世界的东方礼仪文化。
				</label>
			</div>
			</td>
		</tr>
		<tr height="50px"></tr>
		<tr >
			<td ><div id="readmore"><a href="post.jsp" id="read_a" class="a2" title="点击查看详细内容">>>READ &nbsp;&nbsp;MORE</a></div></td>
			<td>
			<span id="zxj1">
			<a href="javascript:;" id="style_a" class="a3"><label id="style_label" title="点击查看更多同方式帖子">自行车</label></a>
			</span>
			<span id="zxj2">
			<a href="javascript:;" id="place_a" class="a3"><label id="place_label" title="点击查看更多该景区帖子">黄山</label></a>
			</span>
			</td>
		</tr>
	</table>
<table id="content" >
		<tr height="50px"  id="tabhead">
			<td width="35%"  align="left">
				<img alt="person_photo" src="images/menu.jpg" id="person_photo">
				&nbsp;
				<label id="author">name</label>
				&nbsp;&nbsp;
				<label id="grade">V1</label>
			</td>
			<td align="right" width="35%">
				<img alt="like" src="images/collect.jpg" title="收藏人数" height="20px" width="20px">
			    <label id="collectnum">101</label>
			    &nbsp;&nbsp;
			    <img alt="comment" src="images/comment.jpg" title="评论的人数" height="20px" width="20px">
			    <label id="commentnum">20</label>
			    &nbsp;&nbsp;
			    <img alt="time" src="images/time.jpg" title="发帖时间" height="20px" width="20px" >
			    <label id="timenum">2018-01-01 9:20</label>
			</td>
			<td rowspan="4" >
				<img alt="view" src="images/viewtest.jpg" title="大学生旅游" id="viewimg">
			</td>
		</tr>
		<tr height="50px">
			<td colspan="2" rowspan="2">
			<div id="postdiv1">
				<label id="posthead">醉美黄山之行！</label>
			</div>
			<div id="postdiv2">
				<label id="postbody">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄山：世界文化与自然双重遗产，世界地质公园，国家AAAAA级旅游景区，国家级风景名胜区，全国文明风景旅游区示范点，中华十大名山，天下第一奇山。
黄山位于安徽省南部黄山市境内，有72峰，主峰莲花峰海拔1864米，与光明顶、天都峰并称三大黄山主峰，为36大峰之一。黄山是安徽旅游的标志，是中国十大风景名胜唯一的山岳风光。
黄山原名“黟山”，因峰岩青黑，遥望苍黛而名。后因传说轩辕黄帝曾在此炼丹，故改名为“黄山”。黄山代表景观有“四绝三瀑”，四绝：奇松、怪石、云海、温泉；三瀑：人字瀑、百丈泉、九龙瀑。黄山迎客松是安徽人民热情友好的象征，承载着拥抱世界的东方礼仪文化。
				</label>
			</div>
			</td>
		</tr>
		<tr height="50px"></tr>
		<tr >
			<td ><div id="readmore"><a href="post.jsp" id="read_a" class="a2" title="点击查看详细内容">>>READ &nbsp;&nbsp;MORE</a></div></td>
			<td>
			<span id="zxj1">
			<a href="javascript:;" id="style_a" class="a3"><label id="style_label" title="点击查看更多同方式帖子">自行车</label></a>
			</span>
			<span id="zxj2">
			<a href="javascript:;" id="place_a" class="a3"><label id="place_label" title="点击查看更多该景区帖子">黄山</label></a>
			</span>
			</td>
		</tr>
	</table>
</body>
</html>