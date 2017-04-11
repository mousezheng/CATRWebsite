<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./bootstrap3.3.7/css/bootstrap.min.css">
<script src="jquery/jquery.min.js"></script>
<script src="./bootstrap3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function lodckick() {
		$('#myCarousel').carousel({
			interval : 1000
		});//每隔2秒自动轮播 
	}
</script>
<style type="text/css">
#scroll {
	color: red;
	font-family: "微软雅黑";
	font-size: 20px;
}
</style>
<title>长安旅游资源网站首页</title>
</head>

<body onload="lodckick()">
	<div style="height: 10%; width: 100%">
		<jsp:include page="./jsp/part/head.jsp"></jsp:include>
	</div>
	<marquee direction="left" scrollamount="5" scrolldelay="5" id="scroll" style="background-color: #222222">

		<p class="txt" style="font-size: 4; color: #FFFFFF">
			<font class="txt" style="font-size: 4; color: #FF5fcc">公告◄)：</font>
			近日，大雁塔有大型活动，前往旅游的游客，可参与活动，领取精美礼品&nbsp;&nbsp;
		</p>
	</marquee>

	<div style="height: 70%; width: 100%">
		<div id="myCarousel" class="carousel slide" style="height: 70%; width: 100%">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img style="width: 100%; height: 100%" src="./img_index/image1.jpg" alt="First slide">
				</div>
				<div class="item">
					<img style="width: 100%; height: 100%" src="./img_index/image2.jpg" alt="Second slide">
				</div>
				<div class="item">
					<img style="width: 100%; height: 100%" src="./img_index/image3.jpg" alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>

	<!-- 	<div style="position: relative;">   div属性position: fixed;-->
	<div style="height: 10%">
		<jsp:include page="./jsp/part/tail.jsp"></jsp:include>
	</div>
</body>
</html>