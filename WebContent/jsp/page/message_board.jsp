<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>留言板</title>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
			document.form1.massage.value = "";
		}
	});
</script>
<style type="text/css">
.box {
	width: 100px;
	height: 100px;
	margin: 0 auto;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	-o-border-radius: 50px;
	border-radius: 50px;
}

#url_info {
	display: block;
	position: fixed;
	right: 0;
	top: 20%;
	padding: 5px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
	background: #3B9DD6;
	color: #E8E8E8;
	width: 20%;
	height: 250px;
}
</style>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100%; padding: 20px; padding-bottom: 100px" align="left">
		<div style="width: 80%;" align="center">
			<strong style="font-size: 30px;">留言板</strong>
		</div>
		<hr />
		<table style="width: 80%; padding: 20px; margin-bottom: 20px" border="2px" bordercolor="20b2aa">
			<tr>
				<td rowspan="3" align="center" style="padding: 20px" width="100px">
					<img alt="头像" src="resources/秦始皇兵马俑/image.jpg" width="100px" ;height="100px" class="box">
					<hr style="padding: 5px; margin: 5px" />
					<font size="4" color="8a2be2">用户名</font>
				</td>
				<td height="20px" style="padding-left: 20px">
					<font size="3">
						<strong>1楼&nbsp;发表时间：</strong>
					</font>
					<font size="3">2017年4月11日18:12:12</font>
				</td>
			</tr>
			<tr>
				<td height="100px" style="padding: 0px; margin: 0px; padding-left: 10px;">
					<div style="padding: 0px; margin: 0px; padding-left: 10px; font-size: 20px;">
						<strong>留言内容：</strong>
						<hr />
					</div>
					<font size="3">今天去壶口瀑布游玩了，景色十分壮观</font>
				</td>
			</tr>
			<tr height="20px" align="right">
				<td>
					<!-- <a href="gg" style="width: 40px; padding: 5px">回复(0)</a> -->
					<a href="gg" style="width: 40px; padding: 5px">赞同(0)</a>
					<a href="gg" style="width: 40px; padding: 5px">不赞同(0)</a>
				</td>
			</tr>
		</table>
		<table style="width: 80%; padding: 20px;margin-bottom: 20px" border="2px" bordercolor="20b2aa">
			<tr>
				<td rowspan="3" align="center" style="padding: 20px" width="100px">
					<img alt="头像" src="resources/秦始皇兵马俑/image.jpg" width="100px" ;height="100px" class="box">
					<hr style="padding: 5px; margin: 5px" />
					<font size="4" color="8a2be2">用户名</font>
				</td>
				<td height="20px" style="padding-left: 20px">
					<font size="3">
						<strong>2楼&nbsp;发表时间：</strong>
					</font>
					<font size="3">2017年4月11日18:12:12</font>
				</td>
			</tr>
			<tr>
				<td height="100px" style="padding: 0px; margin: 0px; padding-left: 10px;">
					<div style="padding: 0px; margin: 0px; padding-left: 10px; font-size: 20px;">
						<strong>留言内容：</strong>
						<hr />
					</div>
					<font size="3">今天去壶口瀑布游玩了，景色十分壮观</font>
				</td>
			</tr>
			<tr height="20px" align="right">
				<td>
					<a href="gg" style="width: 40px; padding: 5px">回复(0)</a>
					<a href="gg" style="width: 40px; padding: 5px">赞同(0)</a>
					<a href="gg" style="width: 40px; padding: 5px">不赞同(0)</a>
				</td>
			</tr>
		</table>
		<table style="width: 80%; padding: 20px;margin-bottom: 20px" border="2px" bordercolor="20b2aa">
			<tr>
				<td rowspan="3" align="center" style="padding: 20px" width="100px">
					<img alt="头像" src="resources/秦始皇兵马俑/image.jpg" width="100px" ;height="100px" class="box">
					<hr style="padding: 5px; margin: 5px" />
					<font size="4" color="8a2be2">用户名</font>
				</td>
				<td height="20px" style="padding-left: 20px">
					<font size="3">
						<strong>3楼&nbsp;发表时间：</strong>
					</font>
					<font size="3">2017年4月11日18:12:12</font>
				</td>
			</tr>
			<tr>
				<td height="100px" style="padding: 0px; margin: 0px; padding-left: 10px;">
					<div style="padding: 0px; margin: 0px; padding-left: 10px; font-size: 20px;">
						<strong>4楼&nbsp;留言内容：</strong>
						<hr />
					</div>
					<font size="3">今天去壶口瀑布游玩了，景色十分壮观</font>
				</td>
			</tr>
			<tr height="20px" align="right">
				<td>
					<a href="gg" style="width: 40px; padding: 5px">回复(0)</a>
					<a href="gg" style="width: 40px; padding: 5px">赞同(0)</a>
					<a href="gg" style="width: 40px; padding: 5px">不赞同(0)</a>
				</td>
			</tr>
		</table>
		<table style="width: 80%; padding: 20px;" border="2px" bordercolor="20b2aa">
			<tr>
				<td colspan="2" align="center" height="100px">
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

	<form id="form1" action="">
		<div id=url_info align="center">
			<table>
				<thead>
					<tr>
						<td colspan="2" align="center" width="100%">
							<div style="padding: 0px; margin: 0px; padding-left: 10px; font-size: 20px;" align="left">
								<strong>留言</strong>
								<hr />
							</div>
						</td>
					</tr>
				</thead>
				<tr>
					<td colspan="2">
						<textarea id="massage" name="message" style="width: 100%; height: 100px; color: #000000" placeholder="输入留言"></textarea>
					</td>
				</tr>
				<tr align="center">
					<td style="padding: 10px">

						<input class="btn btn-lg btn-primary" type="submit" value="留言">
					</td>
					<td style="padding: 10px">
						<input class="btn-lg btn-warning" type="reset" value="重置">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>