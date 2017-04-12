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
<body style="background-color: #e0e0e0">
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100%; background-color: #e0e0e0" align="left">
		<div colspan="5" align="center" style="padding-top: 30px">
			<strong id="strong" style="font-size: 50px; color: #cc8822">❤</strong>
			<strong style="font-size: 50px; color: #cc8822">七日游 活动</strong>
			<hr />
		</div>
		<hr style="height: 5px; border: none; border-top: 5px ridge #4389ff;" />
		<table style="margin-bottom: 30px; width: 99%">
			<tr style="font-size: 20px; padding-left: 40px">
				<td colspan="6">七日游活动&nbsp;套餐1</td>
			</tr>
			<tr>
				<td width="100px" style="padding-left: 20px">
					<font style="font-size:15px;background-color: #00cccc; padding: 10px; border-radius: 20px;">大雁塔</font>
				</td>
				<td style="" width="100px">
					<img alt="箭头" src="resources/point.gif" width="100px">
				</td>
				<td width="100px">
					<font style="font-size:15px;background-color: #cccc00; padding: 10px; border-radius: 20px;">翠华山</font>
				</td>
				<td style="" width="100px" align="center">
					<img alt="箭头" src="resources/point.gif" width="100px">
				</td>
				<td width="100px">
					<font style="font-size:15px;background-color: #cc00cc; padding: 10px; border-radius: 20px;">壶口瀑布</font>
				</td>
				<td style="" width="100px" align="center">
					<img alt="箭头" src="resources/point.gif" width="100px">
				</td>
				<td width="100px">
					<font style="font-size:15px;background-color: #cc00cc; padding: 10px; border-radius: 20px;">壶口瀑布</font>
				</td>
				<td style="" width="100px" align="center">
					<img alt="箭头" src="resources/point.gif" width="100px">
				</td>
				<td width="100px">
					<font style="font-size:15px;background-color: #cc00cc; padding: 10px; border-radius: 20px;">壶口瀑布</font>
				</td>
				<td style="" width="100px" align="center">
					<img alt="箭头" src="resources/point.gif" width="100px">
				</td>
				<td width="100px">
					<font style="font-size:15px;background-color: #cc00cc; padding: 10px; border-radius: 20px;">壶口瀑布</font>
				</td>
				<td style="" width="100px" align="center">
					<img alt="箭头" src="resources/point.gif" width="100px">
				</td>
				<td width="100px">
					<font style="font-size:15px;background-color: #cc00cc; padding: 10px; border-radius: 20px;">壶口瀑布</font>
				</td>
				<td align="right" style="padding-right: 40px">
					<button class="box">
						报名
						<br />
						参加
					</button>
				</td>
			</tr>
		</table>
		<hr style="height: 5px; border: none; border-top: 5px ridge #4389ff;" />
	</div>
</body>
</html>