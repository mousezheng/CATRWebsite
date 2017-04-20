<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>个人信息</title>
<script src="jquery/jquery.min.js"></script>
<!-- <script src="jsp/page/js/set_image_preview.js"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});

	//正则表达式方法获取get
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}

	function topone() {
		var now = parseInt(GetQueryString("now"));
		var sum = parseInt(GetQueryString("sum"));
		if (now > 0) {
			now = now - 1;
			window.location.href = "jsp/page/tourist_attractions.jsp?sum="
					+ sum + "&now=" + now;
		} else {
			alert("已经是首页无法跳转上一页！");
		}
	}
	function underone() {
		var now = parseInt(GetQueryString("now"));
		var sum = parseInt(GetQueryString("sum"));
		if (sum > now) {
			now = now + 1;
			window.location.href = "jsp/page/tourist_attractions.jsp?sum="
					+ sum + "&now=" + now;
		} else {
			alert("已经是首页无法跳转上一页！");
		}
	}

	function submit_form() {
		document.getElementById("form1").submit();
	}
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
		<form id="form1" method="post" action="ChageUserInfo" enctype="multipart/form-data">
			<table width="80%" style="margin-top: 30px; font-size: 20px">
				<tr>
					<td rowspan="4" align="center" style="padding: 20px" width="100px">
						<img alt="头像" src="resources/user_head_img/head_${user.id}.jpg" width="200px" ;height="200px" class="box">
						<br />
						<input type="file" id="headfile" name="headfile" style="width: 200px; border-radius: 10px" value="修改头像" />
					</td>
					<td colspan="3" style="font-size: 30px">
						<strong>${user.userName}</strong>
						<a href="jsp/page2/repassword.jsp" style="font-size: 18px">修改密码</a>
						<a href="jsp/page/chage_info.jsp">
							<img alt="编辑按钮" src="resources/editimg.gif" style="float: right;" width="40px" height="40px">
						</a>
						<img alt="保存按钮" src="resources/save.gif" style="float: right; margin-right: 20px" width="40px" height="40px" onclick="submit_form();">
					</td>
				</tr>
				<tr>
					<td>真实姓名：${user.name}</td>
					<td>性别：${user.sex}</td>
					<td>年龄：${user.age}</td>
				</tr>
				<tr>
					<td>住址：${user.address }</td>
					<td>联系电话：${user.phone }</td>
					<td>出生年月：${user.birthday}</td>
				</tr>
				<tr>
					<td>Email地址：${user.email}</td>
					<td colspan="2">个性签名：${user.describe}</td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center">
		<table width="80%" style="margin-top: 30px; font-size: 20px">
			<tr>
				<td>
					<a href="MessageServlet">
						<button class="btn btn-lg btn-primary" style="width: 100%; height: 50px;">
							<font color="#000000">我要留言</font>
						</button>
					</a>
				</td>
				<!-- 				<td> -->
				<!-- 					<button class="btn btn-lg btn-primary" style="width: 100%; height: 50px">我的足迹</button> -->
				<!-- 				</td> -->
			</tr>

		</table>
		<table width="80%" style="margin-top: 20px; font-size: 20px; margin-bottom: 100px" border="2px">
			<tr align="center" style="font-size: 30px">
				<td>时间</td>
				<td>几楼</td>
				<td>内容</td>
				<td>赞同/不赞同</td>
			</tr>
			<c:forEach items="${messageList}" var="message" varStatus="num">
				<c:choose>
					<c:when test="${num.index%2==0}">
						<tr align="center" class="item">
							<td>${message.time}</td>
							<td>${message.id}</td>
							<td>${message.content}</td>
							<td>${message.agreeNum}/${message.disagreeNum}</td>
						</tr>
					</c:when>
					<c:when test="${num.index%2!=0}">
						<tr align="center" class="item2">
							<td>${message.time}</td>
							<td>${message.id}</td>
							<td>${message.content}</td>
							<td>${message.agreeNum}/${message.disagreeNum}</td>
						</tr>
					</c:when>
				</c:choose>

			</c:forEach>
			<!-- 			<tr> -->
			<!-- 				<td colspan="4" align="center" style="padding-bottom: 100px; font-size: 20px; padding: 20px"> -->
			<!-- 					<font size="4"> -->
			<!-- 						<a>上一页</a> -->
			<!-- 						&nbsp 第1页/共10页 -->
			<!-- 						<a>下一页</a> -->
			<!-- 						&nbsp -->
			<!-- 					</font> -->
			<!-- 				</td> -->
			<!-- 			</tr> -->
		</table>
	</div>
</body>
</html>