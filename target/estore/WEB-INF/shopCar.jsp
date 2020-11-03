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
	<title>briup-电子商务-购物车</title>
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
				<img src="images/play_01.png" alt="">
			</div>
		</div>
	</div>
	<div class="nav">
		<a href="shopCar">
			<button class="btn btn-estore">
				<span class="glyphicon glyphicon-briefcase"></span>&nbsp;我的书包
			</button>
		</a>

			<div class="col-md-10 column marquee">
				<marquee  scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span></marquee>
			</div>
		</div>
		<div class="body">
			<div class="table-shopCar">
				<div class="table_head row ">
					<span class="col-md-4 column">商品</span>
					<span class="col-md-2 column">单价(元)</span>
					<span class="col-md-3 column">数量</span>
					<span class="col-md-2 column">小计(元)</span>
					<span class="col-md-1 column">操作</span>
				</div>
				<div class="table_body ">
				<c:if test="${empty sessionScope.shopCar }"><h3>书包里还没有商品哦，快去买点东西试试吧~</h3></c:if>
				<c:forEach var="entry" items="${sessionScope.shopCar}" varStatus="s">
					<div class="row" id="row${s.index }">
						<div class="col-md-4 column">
							<a href="viewBook?id=${entry.value.id }" target="_blank"><img class="col-md-4 img-thumbnail" src="images/book_shopCart/${entry.value.image }"></a>
							<p class="col-md-8 bookname">${entry.value.name }</p>
						</div>
						<div class="col-md-2 column price">${entry.value.price }</div>
						<div class="col-md-3 column booknum" onclick="giveAId(${entry.key.id })">
							<button class="btn btn-primary btn-sm add">
								<span class="glyphicon glyphicon-plus"></span>
							</button>
							<span class="btn value">${entry.key.num }</span>
							<button class="btn btn-primary btn-sm sub">
								<span class="glyphicon glyphicon-minus"></span>
							</button>
						</div>
						<div class="col-md-2 column price_sum">${entry.value.price * entry.key.num }</div>
						<div class="col-md-1 column">
							<button class="btn btn-danger" onclick="deleteShopCarBook(${entry.key.id }, ${s.index }, ${entry.value.price * entry.key.num })"><span class="glyphicon glyphicon-trash"></span></button>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>
			<div class="allButtom">
				<p class="caozuo">
					<a href="confirm">去结算</a>
				</p>
				<span>已选择<font id="book-num" style="color: #b11e22;"><c:out value="${fn:length(sessionScope.shopCar) }"></c:out></font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：¥<font
					id="price-num" style="color: #b11e22;">${sessionScope.sumValue }</font>元
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
<script type="text/javascript">
function deleteShopCarBook(id, index, price) {
	$.ajax({
		url: "ajax/deleteShopCarBook",
		type: "POST",
		data: {
			method: "deleteShopCarBook",
			id: id
		},
		success: function(data, state) {
			if(data == "YES") {
				$('#row' + index).remove()
				// 修改件数、总价
				var book_num = $('#book-num').html()
				$('#book-num').html(book_num - 1)
				var price_num = $('#price-num').html()
				$('#price-num').html(price_num - price)
			}
		},
		error: function(data) {
			// $("form div:last-child").html('<font color="red">服务器出错</font>')
		}
	})
}

</script>
</html>