<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>租车服务</title>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
</script>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100%" align="center">
		<strong style="font-size: 30px">租车服务</strong>
		<hr />
	</div>
	<font size="4" style="margin-left: 30px">目的地：</font>
	<select id="sex" name="sex" style="width: 300px; height: 30px; margin: 10px">
		<option value="*">请选择目的地</option>
		<c:forEach items="${attractionList}" var="attraction">
			<option value="${attraction.name}">${attraction.name}</option>
		</c:forEach>
	</select>
	<div>
		<form action="">
			<table style="border-collapse: separate; border-spacing: 0px 10px; width: 100%; float: left; padding: 50px; padding-top: 0">
				<c:forEach items="${carList}" var="car">
					<tr>
						<td width="100%-200px" style="background-color: #eeeeee; padding: 20px; padding-right: 50px;">
							<font size="5">${car.name}</font>
							<br />
							<font size="3">价钱：￥${car.prices}元</font>
							<br />
							<font size="3">联系人：${car.contactName}</font>
							<br />
							<font size="3">联系电话：${car.contactPhone}</font>
							<input class="btn btn-lg btn-primary" type="button" value="预定" style="float: right; width: 100px" />
						</td>
						<td width="100px">
							<img alt="景点图片" src="resources/${car.address}/image.jpg" width="160px" height="160px">
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>