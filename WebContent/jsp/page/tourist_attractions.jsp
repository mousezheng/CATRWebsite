<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>旅游景点</title>
<script src="jquery/jquery.min.js"></script>
<script type="text/javascript">
 	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});

 	//正则表达式方法获取get
 	function GetQueryString(name)
 	{
 	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
 	     var r = window.location.search.substr(1).match(reg);
 	     if(r!=null)return  unescape(r[2]); return null;
 	}
 	
 	function topone(){
		var now = parseInt(GetQueryString("now"));
		var sum = parseInt(GetQueryString("sum"));
 		if( now > 0){
 			now = now - 1;
 			window.location.href="jsp/page/tourist_attractions.jsp?sum="+sum+"&now="+now;
 		}else{
 			alert("已经是首页无法跳转上一页！");
 		}
 	}
 	function underone(){
 		var now = parseInt(GetQueryString("now"));
		var sum = parseInt(GetQueryString("sum"));
 		if( sum > now){
 			now = now + 1;
 			window.location.href="jsp/page/tourist_attractions.jsp?sum="+sum+"&now="+now;
 		}else{
 			alert("已经是首页无法跳转上一页！");
 		}
 	}
 	

</script>
<style type="text/css">
.item_image {
	border-radius: 20px;
}

.box {
	display: block;
	position: fixed;
	right: 0;
	top: 10%;
	padding: 5px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
	background: #3B9DD6;
	color: #E8E8E8;
	width: 20%;
	height: 250px;
}

.item_font {
	border-radius: 20px;
	background-color: #eeeeee;
	padding: 20px;
}
</style>
</head>
<body>

	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="padding: 20px; padding-bottom: 100px" align="center">
		<table style="border-collapse: separate; border-spacing: 0px 10px; width: 79%; float: left;">
			<thead>
				<tr>
					<td colspan="2" align="center">
						<strong style="font-size: 30px">景点信息</strong>
						<hr />
					</td>
				</tr>
			</thead>
			<c:forEach items="${attractionList}" var="attraction" begin="${param.now*5}" end="${param.now*5+4}">
				<tr>
					<td width="100%-200px" class="item_font">
						<font size="5">${attraction.name}</font>
						<font size="3">&nbsp;${attraction.address}</font>
						<font style="float: right; padding-right: 20px">
							单人票价：
							<strong>${attraction.ticketPrices}元</strong>
						</font>
						<br />
						<font size="2">${attraction.describe}</font>
						<br />
						<div style="width: 100%" align="right">
							<a href="DetaiInfoServlet?id=${attraction.name}">
								<button class="btn btn-lg btn-primary" style="padding: 5px">查看详情</button>
							</a>
							<a onclick="#">
								<button class="btn btn-lg btn-primary" style="padding: 5px">预定门票</button>
							</a>
						</div>
					</td>
					<td width="100px">
						<img alt="景点图片" src="${attraction.imgFile[0]}" width="160px" height="160px" class="item_image">
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="center" style="padding-bottom: 100px">
					<font size="4">
						<a onclick="topone()">上一页</a>
						&nbsp 第${param.now}页/共${param.sum}页
						<a onclick="underone()">下一页</a>
						&nbsp
					</font>
				</td>
			</tr>
		</table>
		<div class="box" style="width: 20%; height: 480px; background-color: #EEEEEE; padding-top: 20px" align="center">
			<form id="form1" name="form1" action="QueryAttraction" style="background-color: #EEEEEE; padding-top: 20px; width: 100%" method="post">
				<input style="color: #000000" type="text" width="70%" height="50px" placeholder="输入景点名称/相关位置" name="sign">
				<input class="btn btn-lg btn-primary" type="submit" name="submit" id="submit" value="搜索">
			</form>
			<font size="5" color="#000000">
				<strong>
					景点热搜排行榜
					<br />
					······
					<br />
				</strong>
			</font>


			<a href="DetaiInfoServlet?id=${nameStr[0]}">
				<font size="6">top 1 : ${nameStr[0]}</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="DetaiInfoServlet?id=${nameStr[1]}">
				<font size="5">top 2 :${nameStr[1]}</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="DetaiInfoServlet?id=${nameStr[2]}">
				<font size="4">top 3 :${nameStr[2]}</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="DetaiInfoServlet?id=${nameStr[3]}">
				<font size="4">top 4 : ${nameStr[3]}</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
		</div>
	</div>
</body>
</html>