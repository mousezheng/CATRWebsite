<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>七日游</title>
<style type="text/css">
.div {
	width: 10px;
	height: 10px;
	/* 	background-color: #111111; */
	float: left;
	margin: 10px
}

.item {
	font-size: 20px;
	color: #2345FF;
	padding: 30px
}

.box {
	width: 100px;
	height: 100px;
	margin: 0 auto;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	-o-border-radius: 50px;
	border-radius: 50px;
	background-color: #ff4523
}
</style>
<script src="jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
</script>
</head>
<body style="background-color: #e0e0e0">
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100%; background-color: #e0e0e0" align="center">
		<div colspan="5" align="center" style="padding-top: 30px">
			<strong id="strong" style="font-size: 50px; color: #cc8822">❤</strong>
			<strong style="font-size: 50px; color: #cc8822">多日游 活动</strong>
			<hr />
		</div>
		<div style="width: 80%;">
			<table>
				<tr>
					<td style="font-size: 30px; padding-left: 20px" width="250px">活动天数分类：</td>
					<td class="item">三日游</td>
					<td class="item">四日游</td>
					<td class="item">五日游</td>
					<td class="item">六日游</td>
					<td class="item">七日游
				</tr>
				<tr>
					<td colspan="6">
						<hr />
					</td>
				</tr>
				<c:forEach items="${activityList}" var="activity">

					<tr>
						<td width="300px" align="center">
							<img alt="景点图片" src="${activity.imageFile}/image.jpg" width="200px" height="200px" class="item_image" style="border-radius: 10px">
						</td>
						<td colspan="5">
							<div>
								<font size="5">${activity.name}</font>
								<font style="float: right; padding-right: 20px">
									单人票活动价：
									<strong>${activity.prices}元</strong>
								</font>
								<br />
								<font size="5">旅游路线：</font>
								<font size="4">
									<strong style="color: #ff0000">火车站</strong>
									<c:forEach items="${activity.places}" var="places">
								&nbsp;&gt;&nbsp;${places}
								</c:forEach>
									<br />
									<font size="5">详情：</font>
									<font size="3">
										本次活动是属于：
										<font size="5" color="#FF0000">${activity.number}日游活动</font>
										${activity.info}
									</font>
									<div style="width: 100%" align="right">
										<a href="./jsp/page/detailed_info_page.jsp">
											<button class="btn btn-lg btn-primary" style="padding: 5px">参与活动</button>
										</a>
									</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<hr />
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>