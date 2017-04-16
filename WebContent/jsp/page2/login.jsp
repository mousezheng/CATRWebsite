<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
<script type="text/javascript" language="javascript" src="./js/check.js">
	
</script>

</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<!-- 	用户登录 -->
	<!-- 	position:absolute;悬浮 -->
	<div style="z-index: 2; width: 100%; height: 600px; background-color: 282828;" align="center">
		<form name="form1" id="form1" action="LoginServlet" method="post" style="padding-top: 40px;">
			<table align="center" style="font-size: 25px; color: EEEEEE; border-collapse: separate; border-spacing: 13px">
				<tr>
					<td class="glyphicon glyphicon-user">用户ID</td>
					<td>
				</tr>
				<tr>
					<td>
						<input style="height: 30px; color: 000000;" id="name" type="text" name="name">
					</td>
					<td>
						<a href="jsp/page2/registered.jsp">用户注册</a>
					</td>
				</tr>
				<tr>
					<td class="glyphicon glyphicon-asterisk">密码</td>
					<td></td>
				</tr>
				<tr>
					<td>
						<input style="height: 30px; color: 000000;" id="password" type="password" name="password">
					</td>
					<td></td>
				</tr>
				<tr>
					<td style="font-size: 30px">
						<input style="width: 20px; height: 20px" type="radio" value="user" name="position" checked="true">
						用户 &nbsp;
						<input style="width: 20px; height: 20px" type="radio" value="manager" name="position">
						管理员
					</td>
					<td></td>
				</tr>
				<tr>
					<td>
						<input class="btn btn-lg btn-primary" style="font-size: 25px" type="button" value="提交" onclick="login_check()" />
						&nbsp
						<input class="btn-lg btn-warning" style="font-size: 25px" type="reset" value="重置" />
					</td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
	<div style="height: 10%">
		<jsp:include page="../part/tail.jsp"></jsp:include>
	</div>
</body>
</html>