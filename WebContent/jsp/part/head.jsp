<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<!--  <script src="jquery/jquery.min.js"></script> -->
 <script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
</script>
<link href="bootstrap3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
<style type="text/css">
.wrapper {
	font-size: 1rem;
	color: #333;
	padding-top: 20px;
	margin-left: 50px;
	margin: 0 0.75rem;
	white-space: nowrap;
	overflow: hidden;
	width: 250px;
	float: right;
}

.inner {
	width: 10000px;
	overflow: hidden;
}

.inner p {
	display: inline-block;
}
</style>
</head>

<body>
	<div class="container" style="background-color: #222222; width: 100%; padding-left: 5%" align="left">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">网站首页</a>
		</div>
		<div id="navbar" style="width: 60%">
			<ul class="nav navbar-nav">
				<li class="active">
					<a href="jsp/page/tourist_attractions.jsp">旅游景点</a>
				</li>
				<li>
					<a href="jsp/page/car_rental_service.jsp">租车服务</a>
				</li>
				<li>
					<a href="jsp/page/hotel_reservation.jsp">酒店预订</a>
				</li>
				<li>
					<a href="jsp/page/three_day_swim.jsp">
						<strong id="strong"><font color="#ff2343">❤</font></strong>
						多日游
					</a>
				</li>
				<li>
					<a href="jsp/page/message_board.jsp">留言板</a>
				</li>
				<c:if test="${!empty(session.username)}">
					<li>
						<a href="jsp/page/personal_information.jsp">个人信息</a>
					</li>
				</c:if>
			</ul>
		</div>
		<div id="navbar" style="width: 200px; float: right;" align="center">
			<c:choose>
				<c:when test="${empty(session.username)}">

					<ul class="nav navbar-nav">
						<li>
							<a href="jsp/page2/login.jsp">登陆</a>
						</li>
						<li>
							<a href="jsp/page2/registered.jsp">注册</a>
						</li>
					</ul>

				</c:when>
				<c:when test="${!empty(session.username)}">
					<ul class="nav navbar-nav">
						<li>
							<a href="">deng陆</a>
						</li>
						<li>
							<a href="">注册</a>
						</li>
					</ul>
				</c:when>
			</c:choose>
		</div>
		<!-- 	<div id="wrapper" class="wrapper">
			<div class="inner">
				<font class="txt" style="font-size: 4; color: #FF5fcc">公告◄)：</font>
				<p class="txt" style="font-size: 4; color: #FFFFFF">近日，大雁塔有大型活动，前往旅游的游客，可参与活动，领取精美礼品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
			</div>
		</div>
		<script type="text/javascript">
			var wrapper = document.getElementById('wrapper');
			var inner = wrapper.getElementsByTagName('div')[0];
			var p = document.getElementsByTagName('p')[0];
			var p_w = p.offsetWidth;
			var wrapper_w = wrapper.offsetWidth;
			$(document).ready(function fun() {
				if (wrapper_w > p_w) {
					return false;
				}
				inner.innerHTML += inner.innerHTML;
				setTimeout("fun1()", 1000);
			});
			function fun1() {
				if (p_w > wrapper.scrollLeft) {
					wrapper.scrollLeft++;
					setTimeout("fun1()", 30);
				} else {
					setTimeout("fun2()", 2000);
				}
			}
			function fun2() {
				wrapper.scrollLeft = 0;
				fun1();
			}
		</script>
	</div> -->
</body>
</html>
