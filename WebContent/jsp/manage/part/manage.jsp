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
<title>管理员页面</title>
<script type="text/javascript">
	function submitform() {
		document.getElementById("form1").submit();
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="ManagesServlet?sign_manage=update" style="background-color: #EEEEEE; padding-top: 20px; width: 100%;" method="post">
		<div align="center">
			<h2>管理员表</h2>
			<table border="1px">
				<thead>
					<tr>
						<c:forEach items="${tableHead}" var="tablehead">
							<td align="center" width="10%">${tablehead}</td>
						</c:forEach>
						<td align="center" width="20%">操作</td>
					</tr>
				</thead>
				<c:forEach items="${manages}" var="manage" varStatus="num">
					<c:if test="${param.item_id==manage.id }">
						<tr>
							<td align="center" width="10%">
								<input type="text" width="80%" name="id" value="${manage.id}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="name" value="${manage.name}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="password" value="${manage.password}">
							</td>
							<td align="center" width="40%">
								<a onclick="submitform()">提交</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${param.item_id!=manage.id }">
						<tr align="center" class="item">
							<td>${manage.id}</td>
							<td>${manage.name}</td>
							<td>${manage.password}</td>
							<td>
								<a href="jsp/manage/part/manage.jsp?&item_id=${manage.id}">修改</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>