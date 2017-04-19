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
	function addclick(num) {
		window.location.href = "jsp/manage/part/activity.jsp?isadd=1";
	}
	function submitform() {
		document.getElementById("form1").submit();
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="ActivitysServlet${param.item_id==null? null:'?sign_activity=updata'}" style="background-color: #EEEEEE; padding-top: 20px; width: 100%;" method="post">
		<div align="center">
			<h2>用户表</h2>
			<div align="right">
				<input style="color: #000000" type="text" width="70%" height="50px" name="query" id="query">
				<input type="submit" value="搜索" style="margin: 10px">
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
				<c:forEach items="${activitys}" var="activity" varStatus="num">
					<c:if test="${param.item_id==activity.id }">
						<tr>
							<td align="center" width="10%">
								<input type="text" width="80%" name="id" value="${activity.id}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="name" value="${activity.name}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="number" value="${activity.number}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="prices" value="${activity.prices}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="info" value="${activity.info}">
							</td>
							<%-- 							<c:forEach items="${activity.places}" var="place"> --%>
							<%-- 								<input type="text" width="80%" name="one" value="${place}"> --%>
							<%-- 							</c:forEach> --%>
							<td align="center" width="10%">
								<input type="text" width="80%" name="one" value="${activity.one}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="two" value="${activity.two}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="three" value="${activity.three}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="four" value="${activity.four}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="five" value="${activity.five}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="six" value="${activity.six}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="seven" value="${activity.seven}">
							</td>
							<td align="center" width="40%">
								<a onclick="submitform()">提交</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${param.item_id!=activity.id }">
						<c:choose>
							<c:when test="${num.index%2==0}">
								<tr align="center" class="item">
									<td>${activity.id}</td>
									<td>${activity.name}</td>
									<td>${activity.number}</td>
									<td>${activity.prices}</td>
									<td>${activity.info}</td>
									<c:forEach items="${activity.places}" var="place">
										<td>${place}</td>
									</c:forEach>
									<%-- 									<td>${activity.one}</td> --%>
									<%-- 									<td>${activity.two}</td> --%>
									<%-- 									<td>${activity.three}</td> --%>
									<%-- 									<td>${activity.four}</td> --%>
									<%-- 									<td>${activity.five}</td> --%>
									<%-- 									<td>${activity.six}</td> --%>
									<%-- 									<td>${activity.seven}</td> --%>
									<td width="200px">
										<a href="jsp/manage/part/activity.jsp?&item_id=${activity.id}">修改</a>
										&nbsp;
										<a href="ActivitysServlet?sign_activity=delete&item_id=${activity.id}">删除</a>
									</td>
								</tr>
							</c:when>
							<c:when test="${num.index%2!=0}">
								<tr align="center" class="item2">
									<td>${activity.id}</td>
									<td>${activity.name}</td>
									<td>${activity.number}</td>
									<td>${activity.prices}</td>
									<td>${activity.info}</td>
									<c:forEach items="${activity.places}" var="place">
										<td>${place}</td>
									</c:forEach>
									<td width="100px">
										<a href="jsp/manage/part/activity.jsp?&item_id=${activity.id}">修改</a>
										&nbsp;
										<a href="ActivitysServlet?sign_activity=delete&item_id=${activity.id}">删除</a>
									</td>
								</tr>
							</c:when>
						</c:choose>
					</c:if>
				</c:forEach>
				<c:if test="${param.isadd!=null}">
					<tr>
						<c:forEach items="${tableHead}" var="tablehead">
							<td align="center" width="10%">
								<input type="text" width="80%" name="${tablehead}">
							</td>
						</c:forEach>
						<td align="center" width="20%">
							<a onclick="submitform()">提交</a>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
	</form>
</body>
</html>