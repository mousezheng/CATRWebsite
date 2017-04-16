<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>个人信息编辑页面</title>
<style type="text/css">
.item {
	padding: 10px;
	font-size: 15px;
}
</style>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="width: 100" align="center">
		<form action="ChangeInfo" method="post">
			<table style="margin: 50px">
				<tr>
					<td class="item">真实姓名:</td>
					<td class="item">
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td class="item">性别:</td>
					<td class="item">
						<input type="radio" name="sex" value="男" checked="checked">男
						&nbsp;&nbsp;
						<input type="radio" name="sex" value="女">女
					</td>
				</tr>
				<tr>
					<td class="item">年龄:</td>
					<td class="item">
						<input type="text" name="age" style="width: 50px">&nbsp;岁
					</td>
				</tr>
				<tr>
					<td class="item">住址:</td>
					<td class="item">
						<input type="text" name="address">
					</td>
				</tr>
				<tr>
					<td class="item">联系电话:</td>
					<td class="item">
						<input type="text" name="phone">
					</td>
				</tr>
				<tr>
					<td class="item">出生年月:</td>
					<td class="item">
						<input type="text" name="year" style="width: 80px">
						年&nbsp;
						<input type="text" name="month" style="width: 40px">
						月
					</td>
				</tr>
				<tr>
					<td class="item">Email地址:</td>
					<td class="item">
						<input type="text" name="email">
						<select class="selector" name="selector">
							<option value="@qq.com">@qq.com</option>
							<option value="@162.com">@163.com</option>
							<option value="@139.com">@126.com</option>
							<option value="@126.com">@139.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="item">个性签名:</td>
					<td class="item">
						<textarea  name="info" style="width: 100%; height: 100px; color: #000000" placeholder="输入个性签名"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="color: #ff0000" align="center">注：由于个人信息可不填写，所以无输入验证，填写错误可随时修改！</td>
				</tr>
				<tr>
					<td align="center" colspan="2" style="padding-top: 10px">
						<input class="btn btn-lg btn-primary" style="font-size: 25px" type="submit" value="提交"/>
						&nbsp;
						<input class="btn-lg btn-warning" style="font-size: 25px" type="reset" value="重置" />
					</td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>