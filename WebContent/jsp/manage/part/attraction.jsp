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
<script type="text/javascript">
	function addclick(num) {
		window.location.href = "jsp/manage/part/attraction.jsp?isadd=1";
	}
	function submitform() {
		document.getElementById("form1").submit();
	}
</script>
</head>
<body>
	<form id="form1" name="form1" enctype="multipart/form-data" action="AttractionServlet?sign_attraction=${param.item_id==null? 'query':'updata'}${param.isadd==null? null:'add'}" style="background-color: #EEEEEE; padding-top: 20px; width: 100%;" method="post">
		<div align="center">
			<h2>景点信息表</h2>
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
				<c:forEach items="${attractions}" var="attraction" varStatus="num">
					<c:if test="${param.item_id==attraction.id }">
						<tr>
							<td align="center" width="10%">
								<input type="text" width="80%" name="id" value="${attraction.id}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="name" value="${attraction.name}">
							</td>
							<td align="center" width="10%">
								<input type="file" width="80%" name="info" value="${attraction.describe}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="see_num" value="${attraction.seeNum}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="query_num" value="${attraction.queryNum}">
							</td>
							<td align="center" width="10%">
								<input type="file" width="80%" name="image" value="${attraction.imgFile[0]}">
								<br />
								<input type="file" width="80%" name="image1" value="${attraction.imgFile[1]}">
								<br />
								<input type="file" width="80%" name="image2" value="${attraction.imgFile[2]}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="ticket_prices" value="${attraction.ticketPrices}">
							</td>
							<td align="center" width="10%">
								<input type="text" width="80%" name="address" value="${attraction.address}">
							</td>
							<td align="center" width="40%">
								<a onclick="submitform()">提交</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${param.item_id!=attraction.id }">
						<c:choose>
							<c:when test="${num.index%2==0}">
								<tr align="center" class="item">
									<td>${attraction.id}</td>
									<td>${attraction.name}</td>
									<td>${attraction.describe}</td>
									<td>${attraction.seeNum}</td>
									<td>${attraction.queryNum}</td>
									<td>
										<img alt="景点图片" src="${attraction.imgFile[0]}" width="20px" height="20px">
										<img alt="景点图片" src="${attraction.imgFile[1]}" width="20px" height="20px">
										<img alt="景点图片" src="${attraction.imgFile[2]}" width="20px" height="20px">
									</td>
									<td>${attraction.ticketPrices }</td>
									<td>${attraction.address}</td>
									<td>
										<a href="jsp/manage/part/attraction.jsp?&item_id=${attraction.id}">修改</a>
										&nbsp;
										<a href="AttractionServlet?sign_attraction=delete&item_id=${attraction.id}">删除</a>
									</td>
								</tr>
							</c:when>
							<c:when test="${num.index%2!=0}">
								<tr align="center" class="item2">
									<td>${attraction.id}</td>
									<td>${attraction.name}</td>
									<td>${attraction.describe}</td>
									<td>${attraction.seeNum}</td>
									<td>${attraction.queryNum}</td>
									<td>
										<img alt="景点图片" src="${attraction.imgFile[0]}" width="20px" height="20px">
										<img alt="景点图片" src="${attraction.imgFile[1]}" width="20px" height="20px">
										<img alt="景点图片" src="${attraction.imgFile[2]}" width="20px" height="20px">
									</td>
									<td>${attraction.ticketPrices }</td>
									<td>${attraction.address}</td>
									<td>
										<a href="jsp/manage/part/attraction.jsp?&item_id=${attraction.id}">修改</a>
										&nbsp;
										<a href="AttractionServlet?sign_attraction=delete&item_id=${attraction.id}">删除</a>
									</td>
								</tr>
							</c:when>
						</c:choose>
					</c:if>
				</c:forEach>
				<c:if test="${param.isadd!=null}">
					<tr>
						<c:forEach items="${tableHead}" var="tablehead">
							<c:choose>
								<c:when test="${tablehead.equals('info')}">
									<td align="center" width="10%">
										<input type="file" width="80%" name="${tablehead}">
									</td>
								</c:when>
								<c:when test="${tablehead.equals('img_file')}">
									<td align="center" width="10%">
										<input type="file" width="80%" name="image">
										<br />
										<input type="file" width="80%" name="image1">
										<br />
										<input type="file" width="80%" name="image2">
									</td>
								</c:when>
								<c:when test="${!tablehead.equals('img_file')&&!tablehead.equals('info')}">
									<td align="center" width="10%">
										<input type="text" width="80%" name="${tablehead}">
									</td>
								</c:when>
							</c:choose>
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