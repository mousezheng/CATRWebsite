<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

</head>

<body>
	<!-- background-color: #15b5e9; -->
	<div
		style="width: 100%; background-color: #000000; height: 100px; padding: 10px; padding-bottom: 30px"
		align="center">
		<div style="width: 250px; margin-top: 30;" align="center">
			<font color="#FFFFFF">作者：牟春杰<br /> QQ：1586012918<br /> 地址：西安工业大学未央区
			</font>
		</div>
	</div>
</body>
</html>
