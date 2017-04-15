<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>失败页面</title>
</head>
<body>
	<h2>${param.pagename}</h2>
	<hr/>
	<h4>${param.massage}请返回&nbsp;<font size="4" color="#0000ff" onclick="location.href='javascript:history.go(-1);'">点击这里</font></h4>
</body>
</html>