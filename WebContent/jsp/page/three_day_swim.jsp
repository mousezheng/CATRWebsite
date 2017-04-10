<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>三日游</title>
<script src="./js/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			$("#div1").fadeOut();
			$("#div2").fadeOut("slow");
			$("#div3").fadeOut(3000);
		});
	});
</script>
<script type="text/javascript">
	function myclick() {
		for (var i = 0; i < 20; i++) {
			$("#div1").fadeOut(50);
			$("#div2").fadeOut(1000);
			$("#div3").fadeOut(2000);
			$("#div1").fadeIn(2000);
			$("#div2").fadeIn(1000);
			$("#div3").fadeIn(20);
		}
	}
</script>
<style type="text/css">
.div {
	width: 10px;
	height: 10px;
	background-color: #111111;
	float: left;
	margin: 35px
}
</style>
</head>
<body onload="myclick()">
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100px; height: 100px; background-color: #000000" id="div" onclick="myclick()"></div>
	<button>点击这里，使三个矩形淡入</button>
	<div style="width: 100%; height: 150px; background-color: #eeeeee" align="center">
		<table>
			<tr>
				<td style="padding: 20px">
					<font size="6">大雁塔</font>
				</td>
				<td style="padding: 20px" width="300px">
					<div id="div1" class="div"></div>
					<div id="div2" class="div"></div>
					<div id="div3" class="div"></div>
				</td>
				<td style="padding: 20px">
					<font size="6">翠华山</font>
				</td>
				<td style="padding: 20px" width="300px" align="center">
					<div align="center">
						<div id="div4" class="div"></div>
						<div id="div5" class="div"></div>
						<div id="div6" class="div"></div>
					</div>
				</td>
				<td style="padding: 20px">
					<font size="6">壶口瀑布</font>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>