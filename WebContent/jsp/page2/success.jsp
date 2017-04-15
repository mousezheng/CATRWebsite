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
<title>成功</title>
</head>
<body>
	<h2>${param.pagename}</h2>
	<hr />
	<font>${param.massage}<a href="jsp/page2/login.jsp">登陆</a>&nbsp;
		<a href="index.jsp">首页</a>
	</font>
</body>
</html>