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
<title>景点信息</title>
<script src="jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
</script>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>

	<div align="center">
		<table width="80%" style="margin-top: 30px; font-size: 20px">
			<tr>
				<td rowspan="2" align="center" style="padding: 20px">
					<img alt="头像" src="resources/秦始皇兵马俑/image.jpg" width="100%" ;height="100%">
					<br /><hr/>
					<font size="2">浏览次数:100</font>&nbsp
					<font size="2">搜索次数:100</font>
				</td>
				<td colspan="2">
					<strong style="font-size: 30px">秦始皇兵马俑</strong>
					<font> (临潼南) </font>
					<font style="float: right; padding-right: 20px; padding-top: 10px">
						单人票价：
						<strong>
							100元&nbsp;
							<a href="./jsp/page/detailed_info_page.jsp">
								<button class="btn btn-lg btn-primary" style="padding: 5px">预定门票</button>
							</a>
						</strong>
					</font>
					<hr />
				</td>
			</tr>
			<tr>
				<td>秦始皇陵是中国历史上第一位皇帝秦始皇帝的陵墓，其规模之大、陪葬坑之多、内涵之丰富，为历代帝王陵墓之冠。根据考古工作发现，秦陵的陵基为近覆斗方形，夯土筑成，陵基东西宽345米，南北长350米。围绕封土堆，在地面上还筑有两重南北向长方形城垣，内城和外城的四面均有城门，城的四角还筑有角楼。 兵马俑坑位于秦始皇陵封土以东约1.5公里处，它是秦始皇陵的一个组成部分。现已发现了三个坑，基本呈"品"字形排列，总面积达2万余平方米。兵马俑坑均为地下坑道式土木结构建筑，坑内埋藏有陶质兵马俑7000余件，木质战车100余辆。秦兵马俑皆仿真人、真马制成。其中，武士俑高约1.8米，面目各异，从服饰、甲胃和排列位置可以区分出它们的不同身份，出土武器多为经过铬处理的青铜制品，至今仍锋利如新。 意 义：秦始皇陵及兵马俑坑展现了秦始皇陵的结构布局、设计思想及秦代科技文化的成就，被誉为"世界第八奇迹"。</td>
			</tr>
		</table>
		<div style="padding: 20px; margin-top: 30px; margin-bottom: 30px; border: 1px solid #00f; border-color: #0055ff; width: 80%; background-color: #cccccc;" align="left">
			<font size="5" style="padding: 20px">
				<strong>景点图片</strong>
			</font>
			<hr />
			<img alt="图片" src="resources/秦始皇兵马俑/image.jpg" width="100%" ;height="100%" class="box">
			<div style="width: 100%; padding: 5px" align="center">
				<font size="3" style="padding: 20px">
					<strong>图片（1）</strong>
				</font>
			</div>
			<hr />
			<img alt="图片" src="resources/秦始皇兵马俑/image.jpg" width="100%" ;height="100%" class="box">
			<div style="width: 100%" align="center">
				<font size="3" style="padding: 20px">
					<strong>图片（1）</strong>
				</font>
			</div>
			<img alt="图片" src="resources/秦始皇兵马俑/image.jpg" width="100%" ;height="100%" class="box">
			<div style="width: 100%" align="center">
				<font size="3" style="padding: 20px">
					<strong>图片（1）</strong>
				</font>
			</div>
		</div>
	</div>


</body>
</html>