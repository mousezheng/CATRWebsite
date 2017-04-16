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
<title>景点信息</title>
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
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>

	<div align="center">
		<table width="80%" style="margin-top: 30px; font-size: 20px">
			<tr>
				<td rowspan="2" align="center" style="padding: 20px">
					<img alt="头像" src="resources/${attraction.name}/image.jpg" width="200px" ;height="200px">
					<br />
					<hr />
					<font size="2">浏览次数:${attraction.seeNum}</font>
					&nbsp
					<font size="2">搜索次数:${attraction.queryNum}</font>
				</td>
				<td colspan="2">
					<strong style="font-size: 30px">${attraction.name}</strong>
					<font> (${attraction.address}) </font>
					<font style="float: right; padding-right: 20px; padding-top: 10px">
						单人票价：
						<strong>
							${attraction.ticketPrices}元&nbsp;
							<a href="./jsp/page/detailed_info_page.jsp">
								<button class="btn btn-lg btn-primary" style="padding: 5px">预定门票</button>
							</a>
						</strong>
					</font>
					<hr />
				</td>
			</tr>
			<tr>
				<td>${attraction.describe}</td>
			</tr>
		</table>
		<div style="padding: 20px; margin-top: 30px; margin-bottom: 30px; border: 1px solid #00f; border-color: #0055ff; width: 80%; background-color: #cccccc;" align="left">
			<font size="5" style="padding: 20px">
				<strong>景点图片</strong>
			</font>
			<hr />
			<img alt="图片" src="resources/${attraction.name}/image.jpg" width="100%" ;height="100%" class="box">
			<div style="width: 100%; padding: 5px" align="center">
				<font size="3" style="padding: 20px">
					<strong>图片（1）</strong>
				</font>
			</div>
			<hr />
			<img alt="图片" src="resources/${attraction.name}/image1.jpg" width="100%" ;height="100%" class="box">
			<div style="width: 100%" align="center">
				<font size="3" style="padding: 20px">
					<strong>图片（2）</strong>
				</font>
			</div>
			<hr />
			<img alt="图片" src="resources/${attraction.name}/image2.jpg" width="100%" ;height="100%" class="box">
			<div style="width: 100%" align="center">
				<font size="3" style="padding: 20px">
					<strong>图片（3）</strong>
				</font>
			</div>
			<hr />
		</div>
	</div>


</body>
</html>