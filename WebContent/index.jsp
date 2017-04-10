<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./bootstrap3.3.7/css/bootstrap.min.css">
<script src="jquery/jquery.min.js"></script>
<script src="./bootstrap3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$('#myCarousel').carousel({
			interval : 2000
		});//每隔2秒自动轮播 
	});
</script>

<title>长安旅游资源网站首页</title>
</head>

<body>
	<div style="height: 10%">
		<jsp:include page="./jsp/part/head.jsp"></jsp:include>
	</div>


	<div style="height: 70%;width: 100%">
		<div id="myCarousel" class="carousel slide" style="height: 70%;width: 100%">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img style="width: 100%; height: 100%" src="./img_index/image1.jpg"
						alt="First slide">
				</div>
				<div class="item">
					<img style="width: 100%; height: 100%" src="./img_index/image2.jpg"
						alt="Second slide">
				</div>
				<div class="item">
					<img style="width: 100%; height: 100%" src="./img_index/image3.jpg"
						alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
	</div>

	<!-- 	<div style="position: relative;">   div属性position: fixed;-->
	<div style="height: 10%">
		<jsp:include page="./jsp/part/tail.jsp"></jsp:include>
	</div>
</body>
</html>