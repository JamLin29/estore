<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<title>briup-电子商务-书籍详情</title>
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
			<c:if test="${sessionScope.username == null}">
				<span ><a href="login">登录</a></span>
				<span ><a href="register">注册</a></span>
			</c:if>
			<c:if test="${sessionScope.username != null}">
				<span >${sessionScope.username}</span>
				<span ><a href="order">我的订单</a></span>
				<span ><a href="login?exit=yes">退出</a></span>
			</c:if>
		</div>
	</div>
	
	<div class="head">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<img src="images/logo.png" class="logo">
			</div>
			<div class="col-md-6 column">
				<div class="input-group search">
					<input type="text" class="form-control" placeholder="请输入你要检索的书名"style="padding: 20px">
					<span class="input-group-btn">
						<button class="btn btn-estore" type="button"><span class="glyphicon glyphicon-search"></span></button>
					</span>
				</div>
			</div>
			<div class="col-md-3 column bag">
				<a href="shopCar">
					<button class="btn btn-estore">
						<span class="glyphicon glyphicon-briefcase"></span>&nbsp;我的书包
					</button>
				</a>
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="col-md-2 column  type" data-toggle="collapse" 
		href="#typeMenu">
		<span class="glyphicon glyphicon-th"></span>&nbsp;&nbsp;&nbsp;全部图书分类</div>
		
		<div class="col-md-10 column marquee">
			<marquee  scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
		</div>
	</div>
	<div class="body">
		<div class="type-box row clearfix collapse on " id="typeMenu" >
		<c:forEach var="entry" items="${applicationScope.categoriesMap}">
			<dl>
				<a href="list?id=${entry.key.id }&name=${entry.key.name }"><dt>${entry.key.name }：</dt></a>
				<c:forEach var="inner_category" items="${entry.value}" varStatus="s">
				<dd><a href="list?id=${inner_category.id }&name=${inner_category.name }">${inner_category.name }</a></dd>
				</c:forEach>
			</dl>
		</c:forEach>
		</div>
		<div class="row clearfix">
			<ul class="breadcrumb">
				<li>
					<a href="index">首页</a>
				</li>
				<li>
					书籍详情
				</li>
				<li class="active">
					${sessionScope.viewBookInf.name }
				</li>
			</ul>
		</div>
		<div class="viewbook row">
			
			<div class="col-md-5 column pic">
				<div class="big-image row">
					<img class="img-thumbnail" src="images/book_view/book${sessionScope.viewBookInf.id }.jpg">
				</div>
				<div class="row small-image">
					<div class="col-sm-6 col-md-3">
						<img class="img-thumbnail hover" src="images/book_view/book${sessionScope.viewBookInf.id }.jpg">

					</div>
					<div class="col-sm-6 col-md-3">
						<img class="img-thumbnail" src="images/book_view/book${sessionScope.viewBookInf.id }.jpg">

					</div>
					<div class="col-sm-6 col-md-3">
						<img class="img-thumbnail" src="images/book_view/book${sessionScope.viewBookInf.id }.jpg">

					</div>
					<div class="col-sm-6 col-md-3">
						<img class="img-thumbnail" src="images/book_view/book${sessionScope.viewBookInf.id }.jpg">

					</div>
				</div>
				
			</div>

			<div class="col-md-5 column book-message">
				<div class="row bookname">
					<label class="col-md-3 column">书名：</label>
					<span>${sessionScope.viewBookInf.name }</span>
				</div>
				<div class="row bg-warning book-price">
					<label class="col-md-3 column">briup价：</label>
					<span>${sessionScope.viewBookInf.price }</span>
				</div>
				<div class="row">
					<label class="col-md-3 column">服务：</label>
					<img src="images/icons/service_03.png">
					<small>分期付款</small>
					<img src="images/icons/service_05.png">
					<small>免运费</small>
					<img src="images/icons/service_07.png">
					<small>送货上门</small>
					<img src="images/icons/service_09.png">
					<small>7天无理由退换</small>
				</div>
				<hr>
				<div class="row">
					<div id="box" >
						<dl>
							<dt class="col-md-3 column">包装：</dt>
							<dd class="active">简单装</dd>
							<dd>升级装</dd>
							<dd>精品装</dd>
							<dd>至尊装</dd>
						</dl>
					</div>
				</div>
				<div class="row">
					<a href="shopCar?id=${sessionScope.viewBookInf.id }">
						<button class="col-md-5 column btn btn-estore">加入书包</button></a>
						<p class="col-md-2 column"></p>
						<a href="confirm?id=${sessionScope.viewBookInf.id }">
							<button class="col-md-5 column btn btn-shopCar">立即购买</button>
						</a>
					</div>
				</div>

			</div>
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