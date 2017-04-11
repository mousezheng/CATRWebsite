<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
<script type="text/javascript" language="javascript" src="./js/check.js">
	
</script>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<!-- 注册信息 -->
	<div align="center" style="padding-bottom: 15%">
		<form name="form1" action="Register" method="post">
			<table style="border-collapse: separate; border-spacing: 40px; font-size: 20px;">
				<tr>
					<td>姓名:</td>
					<td>
						<input type="text" name="username" id="username" />
					</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td>
						<input type="text" name="phone" id="phone" />
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td>
						<input type="password" name="password" id="password" />
					</td>
				</tr>
				<tr>
					<td>确认密码:&nbsp</td>
					<td>
						<input type="password" name="confirmPassword" id="confirmPAssword" />
					</td>
				</tr>
				<ty>
				<td></td>
				<td>
					<input class="btn btn-lg btn-primary" type="button" value="提交" onclick="judge()" />
					&nbsp
					<input class="btn-lg btn-warning" type="reset" value="重置" />
				</td>
				</ty>
			</table>
		</form>
	</div>
	<div style="height: 10%">
		<jsp:include page="../part/tail.jsp"></jsp:include>
	</div>
</body>
</html>