<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>重置密码</title>
<script type="text/javascript">
	function passworld_check() {
		new_password
		if (document.form1.password.value == ""
				|| document.form1.new_password.value == "") {
			window.alert("密码不能为空");
			return;
		}
		if (document.form1.password.value.length < 6
				|| document.form1.new_password.value == "") {
			window.alert("密码不能少于6位");
			return;
		}
		if (document.form1.new_password.value != document.form1.confirmPassword.value) {
			window.alert("确认密码与新密码不一致");
			return;
		}
		document.form1.submit();
	}
</script>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100%; padding-bottom: 15%" align="center">
		<form name="form1" action="Register" method="post">
			<table style="border-collapse: separate; border-spacing: 40px; font-size: 20px;">
				<tr>
					<td>原始密码</td>
					<td>
						<input type="text" id="password" name="password" />
					</td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td>
						<input type="text" name="new_password" id="new_password" />
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
					<input class="btn btn-lg btn-primary" type="button" value="提交" onclick="passworld_check()" />
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