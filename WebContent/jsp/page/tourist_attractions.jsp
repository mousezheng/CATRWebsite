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
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
 	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
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
<body onload="load_attraction(0)">

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
			<c:forEach items="${attractionList}" var="attraction">
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
							<a href="./jsp/page/detailed_info_page.jsp?id=${attraction.id}">
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
						<a>上一页</a>
						&nbsp 第1页/共10页
						<a>下一页</a>
						&nbsp
					</font>
				</td>
			</tr>
		</table>
		<div class="box" style="width: 20%; height: 480px; background-color: #EEEEEE; padding-top: 20px" align="center">
			<form action="" style="background-color: #EEEEEE; padding-top: 20px; width: 100%">
				<input type="text" width="70%" height="50px" placeholder="输入景点名称/相关位置" id="input_text">
				<a href="https://www.baidu.com/">
					<img alt="图标" src="resources/query.png" width="20%" height="50px" style="background-color: #EEEEEE;" />
				</a>
			</form>
			<font size="5" color="#000000">
				<strong>
					景点热搜排行榜
					<br />
					······
					<br />
				</strong>
			</font>


			<a href="">
				<font size="6">top 1 : 大雁塔</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="">
				<font size="5">top 2 : 翠华山</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="">
				<font size="4">top 3 : 南五台</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="">
				<font size="4">top 4 : 小雁塔</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
		</div>
	</div>
</body>
</html>