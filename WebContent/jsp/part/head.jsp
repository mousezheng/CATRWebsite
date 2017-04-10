<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!-- Bootstrap core CSS -->
<link href="./bootstrap3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="../bootstrap3.3.7/css/bootstrap-theme.min.css"
	rel="stylesheet">
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="./bootstrap3.3.7/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<script src="./bootstrap3.3.7/js/ie-emulation-modes-warning.js"></script>

</head>

<body>
	<div class="container"
		style="background-color: #222222; width: 100%; padding-left: 5%"
		align="left">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">网站首页</a>
		</div>
		<div id="navbar" style="width: 60%">
			<ul class="nav navbar-nav">
				<li class="active"><a href="jsp/page/tourist_attractions.jsp">旅游景点</a></li>
				<li><a href="jsp/page/car_rental_service.jsp">租车服务</a></li>
				<li><a href="jsp/page/hotel_reservation.jsp">酒店预订</a></li>
				<li><a href="jsp/page/three_day_swim.jsp">❤三日游</a></li>
				<li><a href="jsp/page/message_board.jsp">留言板</a></li>
				<c:if test="${!empty(session.username)}">
					<li><a href="jsp/page/personal_information.jsp">个人信息</a></li>
				</c:if>
			</ul>
		</div>
		<div id="navbar" style="width: 10%; float: right;" align="center">
			<c:choose>
				<c:when test="${empty(session.username)}">

					<ul class="nav navbar-nav">
						<li><a href="jsp/page2/login.jsp">登陆</a></li>
						<li><a href="jsp/page2/registered.jsp">注册</a></li>
					</ul>

				</c:when>
				<c:when test="${!empty(session.username)}">
					<ul class="nav navbar-nav">
						<li><a href="">deng陆</a></li>
						<li><a href="">注册</a></li>
					</ul>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>
