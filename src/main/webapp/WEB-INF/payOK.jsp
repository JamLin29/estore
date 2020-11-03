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
				<h2 class="column col-md-10">您的订单已经支付成功，我们将在24小时内为您安排发货！！</h2>
				<a class="col-md-2 column" style="padding: 30px ;color: var(--color) !important" href="index">
					<span class=" glyphicon glyphicon-chevron-right "></span>继续购物
				</a>
			</div>
			<div class="box-lottery">
				<div class="lottery-wrap" style="transform: rotate(-45deg);">
					<span class="lottery-span1" data-id="8">
						<i>杰普卡<br>10元</i><img src="images/lottery_01.png" alt="杰普卡10">
					</span>
					<span class="lottery-span2" data-id="7">
						<i>杰普卡<br>20元</i><img src="images/lottery_02.png" alt="杰普卡20">
					</span>
					<span class="lottery-span3" data-id="6">
						<i>杰普卡<br>50元</i><img src="images/lottery_03.png" alt="杰普卡50">
					</span>
					<span class="lottery-span4" data-id="5">
						<i>杰普卡<br>100元</i><img src="images/lottery_04.png" alt="杰普卡100">
					</span>
					<span class="lottery-span5" data-id="1">
						<i>谢谢参与</i><img src="images/lottery_05.png" alt="谢谢参与">
					</span>
					<span class="lottery-span6" data-id="4">
						<i>杰普卡<br>200元</i><img src="images/lottery_06.png" alt="杰普卡200">
					</span>
					<span class="lottery-span7" data-id="3">
						<i>杰普卡<br>500元</i><img src="images/lottery_07.png" alt="杰普卡500">
					</span>
					<span class="lottery-span8" data-id="2">
						<i>iQOO Pro<br>手机</i><img src="images/lottery_08.png" alt="iQOO Pro">
					</span>
				</div>
				<a class="lottery-btn" href="javascript:void(0);"><i></i>立即抽奖</a>
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