<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>个人信息</title>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
</script>
<style type="text/css">
.item {
	height: 50px;
	background-color: #87CEEB;
}
.item2 {
	height: 50px;
	background-color: #76EE00;
}
</style>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>

	<div align="center">
		<table width="80%" style="margin-top: 30px; font-size: 20px">
			<tr>
				<td rowspan="4" align="center" style="padding: 20px" width="100px">
					<img alt="头像" src="resources/秦始皇兵马俑/image.jpg" width="200px" ;height="200px" class="box">
					<br />
				</td>
				<td colspan="2" style="font-size: 30px">
					<strong>小鼠标</strong>
				</td>
			</tr>
			<tr>
				<td>真实姓名：XXX（可见可选）</td>
				<td>性别：男</td>
				<td>年龄：21</td>
			</tr>
			<tr>
				<td>住址：西安工业大学</td>
				<td>联系电话：1327758374</td>
				<td>出生年月：1996-8-7</td>
			</tr>
			<tr>
				<td>Email地址：14335543@qq.com</td>
				<td colspan="2">个性签名：这个人很懒什么也没写。</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<table width="80%" style="margin-top: 30px; font-size: 20px">
			<tr>
				<td>
					<button class="btn btn-lg btn-primary" style="width: 100%; height: 50px">预订的门票</button>
				</td>
				<td>
					<button class="btn btn-lg btn-primary" style="width: 100%; height: 50px">预定的酒店</button>
				</td>
				<td>
					<button class="btn btn-lg btn-primary" style="width: 100%; height: 50px">预定的租车</button>
				</td>
			</tr>

		</table>
		<table width="80%" style="margin-top: 20px; font-size: 20px; margin-bottom: 100px" border="2px">
			<tr align="center" style="font-size: 30px">
				<td>名称</td>
				<td>数量</td>
				<td>单价/总价</td>
				<td>时间/是否过期</td>
			</tr>
			<tr align="center" class="item">
				<td>大雁塔参观门票</td>
				<td>2</td>
				<td>￥50&nbsp;￥100</td>
				<td>2017/12/13(未过期)</td>
			</tr>
			<tr align="center" class="item2">
				<td>大雁塔参观门票</td>
				<td>1</td>
				<td>￥50&nbsp;￥50</td>
				<td>2017/2/13(已过期)</td>
			</tr>
			<tr align="center" class="item">
				<td>大雁塔参观门票</td>
				<td>2</td>
				<td>￥50&nbsp;￥100</td>
				<td>2017/12/13(未过期)</td>
			</tr>
			<tr align="center" class="item2">
				<td>大雁塔参观门票</td>
				<td>1</td>
				<td>￥50&nbsp;￥50</td>
				<td>2017/2/13(已过期)</td>
			</tr>
			<tr align="center" class="item">
				<td>大雁塔参观门票</td>
				<td>2</td>
				<td>￥50&nbsp;￥100</td>
				<td>2017/12/13(未过期)</td>
			</tr>
			<tr align="center" class="item2">
				<td>大雁塔参观门票</td>
				<td>1</td>
				<td>￥50&nbsp;￥50</td>
				<td>2017/2/13(已过期)</td>
			</tr>
			<tr>
				<td colspan="4" align="center" style="padding-bottom: 100px; font-size: 20px; padding: 20px">
					<font size="4">
						<a>上一页</a>
						&nbsp 第1页/共10页
						<a>下一页</a>
						&nbsp
					</font>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>