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
	<title>briup-电子商务-清单</title>
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
		<div id="box">
			<dl>
				<dt>价格：</dt>
				<dd>0-10</dd>
				<dd>10-20</dd>
				<dd>20-30</dd>
				<dd>30-40</dd>
				<dd>40-50</dd>
				<dd>50-60</dd>
				<dd>60以上</dd>
			</dl>
			<dl style="border: none">
				<dt>出版社：</dt>
				<dd>清华大学出版社</dd>
				<dd>上海人民出版社</dd>
				<dd>重庆出版社</dd>
				<dd>长江出版社</dd>
				<dd>南海出版公司</dd>
				<dd>北京联合出版有限责任公司</dd>
			</dl>
			<dl class="select" style="border-bottom-width: 0px;">
				<dt>已选条件：</dt>
			</dl>
		</div>
		<div class="row clearfix">
			<ul class="breadcrumb">
				<li>
					<a href="index">首页</a>
				</li>
				<li class="active">
					筛选结果
				</li>
			</ul>
		</div>
		<div class="row book">
		<c:if test="${empty sessionScope.bookList }"><h3>这里还没有商品，掌柜已经去补货啦~</h3></c:if>
		<c:forEach var="book" items="${sessionScope.bookList}">
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
</html>
<script>

	var dls = document.querySelectorAll('dl:not(.select)');
	var selected=document.querySelector('.select');

	for (var i = 0; i < dls.length; i++) {
			dls[i].mark=false;	//给每一行的dl标签添加一条属性，用于对应下面的dd标签。我们约定如果这个属性的值为true表示对应的标签没有创建。如果值为false表示对应的标签已经创建了
			select(i);
		}

		function select(n) {
			var dds = dls[n].querySelectorAll('dd');
			var prev=null;
			var dd=null;	//每一行都需要创建一个dd标签，放到这里是为了如果标签已经被创建了，通过这个变量能够找到这个标签

			for (var i = 0; i < dds.length; i++) {
				dds[i].onclick = function () {
					//给当前点击的添加一个高亮
					//prev && (prev.className = '');

					if(prev){
						prev.className = ''
					}

					this.className = 'active';

					prev = this;


					//创建dd标签
					var parent=this.parentNode;
					if(!parent.mark){	//这个条件满足说明对应的dd标签还没有创建
						dd=document.createElement('dd');
						dd.innerHTML=this.innerHTML;
						selected.appendChild(dd);

						parent.mark=true;
						
					}else{
						//走这里的时候说明对应的标签已经创建了，只需要把内容修改了就可以了
						dd.innerHTML=this.innerHTML;
					}
					
					var span=document.createElement('span');
					var This=this;
					span.innerHTML='X';
					span.onclick=function(){
						//alert(1);
						/*
							点击关闭后要做的事情
								1、移除掉dd
								2、把上面点击的那个class去掉
								3、父级身上的mark属性要更新
								*/
								selected.removeChild(dd);
								This.className='';
								parent.mark=false;
							};
							dd.appendChild(span);
						};
					}
				}
			</script>
			<style>

				dl,
				dd {
					margin: 0;
				}

				#box {
					background: rgba(255, 255, 255, 0.8);
					box-shadow: 0 0 10px rgba(73,66,66,.1);
					border: 1px solid #E5E5E5;
				}

				#box dl {
					height: 50px;
					line-height: 50px;
					border-bottom: 1px dashed #dadada;
					margin: 0 20px;
					display: block;
				}

				#box dt {
					display: inline-block;
					vertical-align: middle;
					color: #8a8a8a;
				}

				#box dd {
					display: inline-block;
					vertical-align: middle;
					color: #252525;
					margin: 0 10px;
					font-size: 14px;
					cursor: pointer;
				}

				#box dd.active {
					color: var(--color);
					font-weight: bold;
				}

				#box dl.select {
					background: #efefef;
					margin: 0;
					padding: 0 20px;
				}

				#box dl.select dd{
					border: 1px solid var(--color);
					height: 25px;
					line-height: 25px;
					margin-top: 13px;
					padding: 0 2px 0 10px;
					border-radius: 3px;background-color: #fff;
				}
				#box dl.select dd span{
					width: 20px;
					height: 20px;
					display: inline-block;
					text-align: center;
					line-height: 20px;
					background: #c4284d;
					color: #fff;
					margin-left: 10px;
					cursor: pointer;border-radius: 5px;
				}
			</style>