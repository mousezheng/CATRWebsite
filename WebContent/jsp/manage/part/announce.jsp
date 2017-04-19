<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>公告管理页面</title>
</head>
<body>
	<div style="width: 100%; padding: 50px" align="center">
		<form action="AnnounceServlet">
			<table>
<%-- 				<c:forEach items="${announces}" var="announce"> --%>
					<td>题目：</td>
					<td>
						<input type="text" name="title" value="${announce.title}">
					</td>
					</tr>
					<tr>
						<td>时间：</td>
						<td>
							<input type="text" name="time" value="${announce.time}">
						</td>
					</tr>
					<tr>
						<td>内容：</td>
						<td>
							<textarea id="massage" name="content" style="width: 100%; height: 100px; color: #000000" placeholder="输入留言">${announce.content}</textarea>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="提交">
						</td>
						<td>
							<input type="reset" value="重置">
						</td>
					</tr>
<%-- 				</c:forEach> --%>
			</table>
		</form>
	</div>
</body>
</html>