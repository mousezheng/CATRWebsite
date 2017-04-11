<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>旅游景点</title>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		for (var i = 0; i < 100; i++) {
			$("#strong").fadeOut();
			$("#strong").fadeIn();
		}
	});
</script>
<style type="text/css">
.item_image {
	border-radius: 20px;
}

.item_font {
	border-radius: 20px;
	background-color: #eeeeee;
	padding: 20px;
}
</style>
</head>
<body>
	<div style="height: 10%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div style="padding: 20px; padding-bottom: 100px" align="center">
		<table style="border-collapse: separate; border-spacing: 0px 10px; width: 79%; float: left;">
			<thead>
				<tr>
					<td colspan="2" align="center">
						<strong style="font-size: 30px">景点信息</strong>
						<hr />
					</td>
				</tr>
			</thead>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">翠华山</font>
					<font size="3">&nbsp;(西安南)</font>
					<font style="float: right; padding-right: 20px">
						单人票价：
						<strong>100元</strong>
					</font>
					<br />
					<font size="2">翠华山原名太乙山，景区由碧山湖景区、天池景区和山崩石海景区3部分组成。传说有太乙真人在此修炼过，由此得名。 翠华山旅游景区位于西安城南20公里处秦岭北麓，景区面积32平方公里。1992年被国家林业部评为“终南山国家森林公园”；1993年被评为“省级名胜风景区”；1997年被评为“西安旅游十大景”；2001年被国土资源部评为“陕西翠华山山崩景观国家地质公园”；2002年被国家旅游局评为“AAAA级旅游景区”；2009年被联合国教科文组织评为“秦岭终南山世界地质公园”；[1] 同年被评为“陕西省平安景区”；2010年被评为“陕西省平安示范景区”[2] 2012年荣获国家级水利风景区。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/翠华山/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">大雁塔</font>
					<br />
					<font size="2">大雁塔位于唐长安城晋昌坊（今陕西省西安市南）的大慈恩寺内，又名“慈恩寺塔”。唐永徽三年（652年），玄奘为保存由天竺经丝绸之路带回长安的经卷佛像主持修建了大雁塔，最初五层，后加盖至九层，再后层数和高度又有数次变更，最后固定为今天所看到的七层塔身，通高64.517米，底层边长25.5米。 大雁塔作为现存最早、规模最大的唐代四方楼阁式砖塔，是佛塔这种古印度佛寺的建筑形式随佛教传入中原地区，并融入华夏文化的典型物证，是凝聚了中国古代劳动人民智慧结晶的标志性建筑。 1961年3月4日，国务院公布大雁塔为第一批全国重点文物保护单位[1] 。2014年6月22日，在卡塔尔多哈召开的联合国教科文组织第38届世界遗产委员会会议上，大雁塔作为中国、哈萨克斯坦和吉尔吉斯斯坦三国联合申遗的“丝绸之路：长安-天山廊道的路网”中的一处遗址点成功列入《世界遗产名录》。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/大雁塔/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td width="100%-200px" class="item_font">
					<font size="5">壶口瀑布</font>
					<br />
					<font size="2">壶口瀑布，国家级风景名胜区，国家AAAA级旅游景区，国家地质公园。[1] 东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口乡，为两省共有旅游景区。北距山西太原387千米；南距陕西西安350千米。[2] 壶口瀑布是中国第二大瀑布，世界上最大的黄色瀑布。在水量大的夏季，壶口瀑布气势恢宏；而到了冬季，整个水面全部冰冻，结出罕见的巨大冰瀑。 2014年12月6日前后，由于受持续降温天气影响，黄河壶口瀑布出现流凌、冰挂景观。[3] 2015年7月30日，受壶口瀑布上游陕西境内云岩河流域强降雨影响，黄河壶口瀑布出现西边浊浪翻滚东边白浪滔滔的奇特景观。</font>
				</td>
				<td width="100px">
					<img alt="景点图片" src="resources/壶口瀑布/image.jpg" width="160px" height="160px" class="item_image">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="padding-bottom: 100px">
					<font size="4">
						<a>上一页</a>
						&nbsp 第1页/共10页
						<a>下一页</a>
						&nbsp
					</font>
				</td>
			</tr>
		</table>
		<div style="width: 20%; height: 480px; background-color: #EEEEEE; float: right; padding-top: 0px" align="center">
			<form action="" style="background-color: #FFFFFF; padding-top: 10px">
				<input type="text" width="70%" height="50px" placeholder="输入景点名称/相关位置" id="input_text">
				<a href="https://www.baidu.com/">
					<img alt="图标" src="resources/query.png" width="20%" height="50px" />
				</a>
			</form>
			<font size="5" style="font-style: normal;">
				<strong>景点热搜排行榜</strong>
			</font>
			<br />
			······
			<br />
			<hr width="5px" />
			<a href="">
				<font size="6">top 1 : 大雁塔</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="">
				<font size="5">top 2 : 翠华山</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="">
				<font size="4">top 3 : 南五台</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
			<a href="">
				<font size="4">top 4 : 小雁塔</font>
			</a>
			<hr style="height: 5px; border: none; border-top: 5px ridge green;" />
		</div>
	</div>
</body>
</html>