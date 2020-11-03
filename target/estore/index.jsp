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
	<title>briup-电子商务-首页</title>
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
	<c:if test="${sessionScope.index_msg != null}">
	<div class="top">${sessionScope.index_msg }</div>
	</c:if>
	<c:remove var="index_msg" scope="session"/>
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
		<div class="col-md-2 column  type" >
			全部图书分类
		</div>
		<div class="col-md-10 column marquee">
			<marquee  scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
		</div>
	</div>
	<div class="body">
		<div class="row clearfix">
			<div class="col-md-2 column menu" >
				<ul>
				<c:forEach var="entry" items="${applicationScope.categoriesMap}">
					<li href="#collapse${entry.key.id}" data-toggle="collapse" ><span class="glyphicon glyphicon-tags"></span>${entry.key.name}</li>
					<div id="collapse${entry.key.id}" class="collapse on">
						<div class="collapse-body">
						<c:forEach var="inner_category" items="${entry.value}" varStatus="s">
							<a href="list?id=${inner_category.id }&name=${inner_category.name }">
								${inner_category.name }
							</a>
						</c:forEach>
						</div>
					</div>
				</c:forEach>
				</ul>
			</div>
			<div class="col-md-8 column banner">
				<div class="carousel slide" id="carousel-292430">
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="images/index/index1.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index2.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index3.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index4.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index5.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index6.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index7.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index8.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index9.jpg" />
						</div><div class="item">
							<img alt="" src="images/index/index10.jpg" />
						</div>
						<div class="item">
							<img alt="" src="images/index/index11.jpg" />
						</div>
						
					</div> <a class="left carousel-control" href="#carousel-292430" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-292430" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
			<div class="col-md-2 column message">
				<div class="row">
					<div class="col-md-4 column">
						<img src="images/userLogo.jpeg" class="img-circle">
					</div>
					<div class="col-md-8 column">
						<p>hi~,欢迎来逛网上书城</p>
						<p>
						<c:if test="${sessionScope.username == null}">
							<a href="login">登录</a> | <a href="register">注册</a>
						</c:if>
						<c:if test="${sessionScope.username != null}">
							<a >${sessionScope.username}</a> | 
							<a href="order">我的订单</a> | 
							<a href="login?exit=yes">退出</a>
						</c:if>
						</p>
					</div>
				</div>
				<div class="row inner-line">
					<div class="col-md-6 column ">
						<button class=" btn-newuser">新人福利</button>
					</div>
					<div class="col-md-6 column ">
						<button class=" btn-plus">PLUS会员</button>
					</div>
				</div>
				<div class="news"> 
					<ul>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
						<li>
							相信一切都是最好的安排 
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row miaosha">
			<div class="col-md-2 column img">
				<div class="se-cn">杰普秒杀</div>
				<div class="se-en"></div>
				<div class="se-info">距离结束还剩</div>
				<div class="se-count" style="text-align: center;">
					<div class="se-hour"><span class="se-txt">00</span></div>
					<div class="se-min"><span class="se-txt">00</span></div>
					<div class="se-sec"><span class="se-txt">00</span></div>
				</div>
			</div>
			<c:forEach var="book" items="${applicationScope.seckillBooks}">
			<div class="col-md-2 column book">
				<a href="viewBook?id=${book.id }&name=${book.name }">
					<img src="images/book_index/${book.image }">
				</a>
				<div class="price">
					<span class="price-one">${book.price }
					</span><span class="price-two">
					<fmt:formatNumber value="${book.price * 0.5 }" maxFractionDigits="2"/></span>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="find">
			<h3>发现好书</h3>
		</div>
		<div class="row book">
			<c:forEach var="book" items="${applicationScope.goodBooks}">
			<div class="col-md-3 onebook">
				<a href="viewBook?id=${book.id }">
					<img src="images/book_index/${book.image }" />
					<h4>
						${book.name }
					</h4>
					<p>￥${book.price }</p>
				</a>
				<div class="row">
					<a href="shopCar?id=${book.id }">
						<button class="btn btn-shopCar">加入书包</button>
					</a>
					<a href="confirm?id=${book.id }" class="btn btn-estore">立即购买</a>
				</div>
			</div>
			</c:forEach>
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
<script type="text/javascript">
	$(document).ready(function () {
		var oDate = new Date();
            var nowTime = oDate.getTime(); //现在的毫秒数
            oDate.setDate(oDate.getDate() + 1); // 设定截止时间为第二天
            var targetDate = new Date(oDate.toLocaleDateString());
            run(targetDate);
        });

	function run(enddate) {
		getDate(enddate);
		setInterval("getDate('" + enddate + "')", 500);
	}

	function getDate(enddate) {
            var oDate = new Date(); //获取日期对象

            var nowTime = oDate.getTime(); //现在的毫秒数
            var enddate = new Date(enddate);
            var targetTime = enddate.getTime(); // 截止时间的毫秒数
            var second = Math.floor((targetTime - nowTime) / 1000); //截止时间距离现在的秒数

            var day = Math.floor(second / 24 * 60 * 60); //整数部分代表的是天；一天有24*60*60=86400秒 ；
            second = second % 86400; //余数代表剩下的秒数；
            var hour = Math.floor(second / 3600); //整数部分代表小时；
            second %= 3600; //余数代表 剩下的秒数；
            var minute = Math.floor(second / 60);
            second %= 60;
            var spanH = $('.se-txt')[0];
            var spanM = $('.se-txt')[1];
            var spanS = $('.se-txt')[2];

            spanH.innerHTML = tow(hour);
            spanM.innerHTML = tow(minute);
            spanS.innerHTML = tow(second);
        }

        function tow(n) {
        	return n >= 0 && n < 10 ? '0' + n : '' + n;
        }
    </script>
</html>