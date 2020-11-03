<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	StringBuilder builder = new StringBuilder();
	builder.append(request.getScheme()).append("://")
		   .append(request.getServerName()).append(":")
		   .append(request.getServerPort())
		   .append(request.getContextPath())
		   .append("/");
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=builder.toString()%>">
	<title>briup-电子商务-订单确认</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/estore.js"></script>
</head>
<body>
	<a href="#top" alt="回到顶部" class="toTop">
		<button class="btn btn-top"><span class="glyphicon glyphicon-chevron-up"></span></button>
	</a>
	<div class="top" id="top">
		<div class="herf">
			<span ><a href="index">首页</a></span>
			<span >${sessionScope.username}</span>
			<span ><a href="order">我的订单</a></span>
			<span ><a href="login?exit=yes">退出</a></span>
		</div>
	</div>
	
	<div class="head">
		<div class="row clearfix">
			<div class="col-md-6 column">
				<img src="images/logo.png" class="logo">
			</div>
			<div class="col-md-6 column">
				<img src="images/play_04.png" alt="">
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="col-md-2 column  type" >
			<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;&nbsp;订单完成</div>

			<div class="col-md-10 column marquee">
				<marquee  scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
			</div>
		</div>
		<div class="body">
			<div class="orderSure row">
				<h2 class="column col-md-10">您的订单还未支付完成，等待再次确认支付信息……</h2>
				<a class="col-md-2 column" style="padding: 30px ;color: var(--color) !important" href="index">
					<span class=" glyphicon glyphicon-chevron-right "></span>继续购物
				</a>
			</div>
			<div class="row">
				<a href="return?trade_no=${requestScope.trade_no }"><button class="col-md-5 column btn btn-estore">再次确认</button></a>
			</div>
		</div>

		<div class="footer"> 
			<div class="row clearfix icons">
				<div class="col-md-3 column">
					<img src="images/icons/icon_1_17.png">
					品目繁多 愉悦购物
				</div>
				<div class="col-md-3 column">
					<img src="images/icons/icon_1_20.png">
					正品保障 天天低价
				</div>
				<div class="col-md-3 column">
					<img src="images/icons/icon_1_23.png">
					极速物流 特色定制
				</div>
				<div class="col-md-3 column">
					<img src="images/icons/icon_1_25.png">
					优质服务 以客为尊
				</div>
			</div>
			<div class="links">
				<p>
					<span>关于我们</span>|
					<span>联系我们</span>|
					<span>加我我们</span>|
					<span>友情链接</span>
				</p>
				<p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司</p>
				<img src="images/police.png">
			</div>
		</div>
	</div>
</body>
</html>
<script src="js/lib/anime.min.js"></script>
<script src="js/app/lottery.js"></script>
<script>

	var Lottery = Turntable.create();
	$('.lottery-btn').on('click', function(){
		var num = Math.floor(Math.random() * 8);
		Lottery.start(num, function(index){
			alert($('.lottery-wrap span').eq(index).find('i').text());

			console.log($('span').eq(index).find('i').text());
		});
	});
</script>