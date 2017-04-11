<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	<font size="4" style="margin-left: 30px">目的地：</font>
	<select id="sex" name="sex" style="width: 300px; height: 30px; margin: 10px">
		<option value="">请选择目的地</option>
		<option value="男">大雁塔</option>
		<option value="女">翠华山</option>
	</select>
	<div>
		<form action="">
			<table style="border-collapse: separate; border-spacing: 0px 10px; width: 100%; float: left; padding: 50px; padding-top: 0">
				<tr>
					<td width="100%-200px" style="background-color: #eeeeee; padding: 20px; padding-right: 50px;">
						<font size="5">大雁塔五人座观光车</font>
						<br />
						<font size="3">价钱：￥100元</font>
						<br />
						<font size="3">联系人：胡先生</font>
						<br />
						<font size="3">联系电话：18334847395</font>
						<input class="btn btn-lg btn-primary" type="button" value="预定" style="float: right; width: 100px" />
					</td>
					<td width="100px">
						<img alt="景点图片" src="resources/翠华山/image.jpg" width="160px" height="160px">
					</td>
				</tr>
				<tr>
					<td width="100%-200px" style="background-color: #eeeeee; padding: 20px; padding-right: 50px;">
						<font size="5">大雁塔五人座观光车</font>
						<br />
						<font size="3">价钱：￥100元</font>
						<br />
						<font size="3">联系人：胡先生</font>
						<br />
						<font size="3">联系电话：18334847395</font>
						<input class="btn btn-lg btn-primary" type="button" value="预定" style="float: right; width: 100px" />
					</td>
					<td width="100px">
						<img alt="景点图片" src="resources/翠华山/image.jpg" width="160px" height="160px">
					</td>
				</tr>
				<tr>
					<td width="100%-200px" style="background-color: #eeeeee; padding: 20px; padding-right: 50px;">
						<font size="5">大雁塔五人座观光车</font>
						<br />
						<font size="3">价钱：￥100元</font>
						<br />
						<font size="3">联系人：胡先生</font>
						<br />
						<font size="3">联系电话：18334847395</font>
						<input class="btn btn-lg btn-primary" type="button" value="预定" style="float: right; width: 100px" />
					</td>
					<td width="100px">
						<img alt="景点图片" src="resources/翠华山/image.jpg" width="160px" height="160px">
					</td>
				</tr>
				<tr>
					<td width="100%-200px" style="background-color: #eeeeee; padding: 20px; padding-right: 50px;">
						<font size="5">大雁塔五人座观光车</font>
						<br />
						<font size="3">价钱：￥100元</font>
						<br />
						<font size="3">联系人：胡先生</font>
						<br />
						<font size="3">联系电话：18334847395</font>
						<input class="btn btn-lg btn-primary" type="button" value="预定" style="float: right; width: 100px" />
					</td>
					<td width="100px">
						<img alt="景点图片" src="resources/翠华山/image.jpg" width="160px" height="160px">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>