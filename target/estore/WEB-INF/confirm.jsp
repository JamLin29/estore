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
				<img src="images/play_02.png" alt="">
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="col-md-2 column  type" >
			<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;&nbsp;订单确认</div>

			<div class="col-md-10 column marquee">
				<marquee  scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
			</div>
		</div>
		<div class="body">
			<div class=" receiver">
				<div class=" receiver-header">
					填写并核对您的订单信息
				</div>
				<div class="row">
					<form class="form-horizontal col-md-7 column" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-4 control-label">收货人姓名：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" disabled="disabled"  value="${requestScope.customerInf.username }" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-4 control-label">收货地址：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" disabled="disabled"  value="${requestScope.customerInf.address }" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-4 control-label">收货人电话：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" disabled="disabled"  value="${requestScope.customerInf.phone }" />
							</div>
						</div>
					</form>
				</div>
				<div class="row sendlist">
					送货清单
					<a href="shopCar" style="display: inline-block;float: right;margin-right: 50px;  font-size: 14px;color:blue !important;">返回修改购物车</a> 
				</div>
				<c:forEach var="entry" items="${sessionScope.shopCar}" varStatus="s">
				<div class="bigDiv">
					<div class="twoDiv row">
						<p style="padding: 10px 20px">商家：briup自营</p>
						<!--遍历显示book  -->
						<div class="col-md-3 column pic">
							<a href="viewBook?id=${entry.value.id }" target="_blank"><img 
							src="images/book_shopCart/${entry.value.image }" ></a>
						</div>
						<div class="col-md-9  column order-message">
							<div class="row"> 
								<font class="col-md-3  column"  color="red" size="3">${entry.value.name }</font>
								<font class="col-md-3  column">¥ ${entry.value.price }</font>
								<font class="col-md-3  column">×${entry.key.num }</font>
								<font class="col-md-3  column" color="red">有货</font>
							</div>
							<div class="row"> 
								<img src="images/sureLogo_14.png" alt=""><span>七天无理由退换货</span>
							</div>
							<div class="row">【赠品】  高级定制干花书签  随机  ×${entry.key.num }</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="allButtom">
				<p class="caozuo">
					<a href="pay${requestScope.payString }">前往支付</a>
				</p>
				<span>共<font id="book-num" style="color: #b11e22;"><c:out value="${fn:length(sessionScope.shopCar) }"></c:out></font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;应付：¥<font
					id="price-num" style="color: #b11e22;"> ${sessionScope.sumValue }</font>元
				</span>
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