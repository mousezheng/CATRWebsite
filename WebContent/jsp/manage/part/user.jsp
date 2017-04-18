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
	function addclick(num){
		window.location.href = "jsp/manage/part/user.jsp?isadd=1";
	}
	function submitform() {
		document.getElementById("form1").submit();  
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="UserServlet" style="background-color: #EEEEEE; padding-top: 20px; width: 100%;" method="post">
		<div align="center">
			<h2>用户表</h2>
			<div align="right">
				<input style="color: #000000" type="text" width="70%" height="50px" name="sign">
				<input type="button" name="query" id="query" value="搜索" style="margin: 10px">
				<input type="button" name="add" id="add" value="增加" style="margin: 10px" onclick="addclick(1)">
			</div>
			<table border="1px">
				<thead>
					<tr>
						<c:forEach items="${tableHead}" var="tablehead">
							<td align="center" width="10%">${tablehead}</td>
						</c:forEach>
						<td align="center" width="20%">操作</td>
					</tr>
				</thead>
				<c:forEach items="${users}" var="user" varStatus="num">
					<c:choose>
						<c:when test="${num.index%2==0}">
							<tr align="center" class="item">
								<td>${user.id}</td>
								<td>${user.userName}</td>
								<td>${user.password}</td>
								<td>${user.phone}</td>
								<td>
									<a href="#">修改</a>
									&nbsp;
									<a href="#">删除</a>
								</td>
							</tr>
						</c:when>
						<c:when test="${num.index%2!=0}">
							<tr align="center" class="item2">
								<td>${user.id}</td>
								<td>${user.userName}</td>
								<td>${user.password}</td>
								<td>${user.phone}</td>
								<td>
									<a href="#">修改</a>
									&nbsp;
									<a href="#">删除</a>
								</td>
							</tr>
						</c:when>
					</c:choose>
				</c:forEach>
				<c:if test="${param.isadd!=null}">
					<tr>
						<c:forEach items="${tableHead}" var="tablehead">
							<td align="center" width="10%">
								<input type="text" width="80%" name="${tablehead}">
							</td>
						</c:forEach>
						<td align="center" width="20%"><a onclick="submitform()">提交</a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</form>
</body>
</html>