<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>briup-电子商务-登录</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/estore.js"></script>
</head>
<body>
	<div class="login_top">
		<img src="images/logo.png">
		<h2 class="title">欢迎登陆</h2>
	</div>
	<div class="login_tip"><span class=" glyphicon glyphicon-info-sign">&nbsp;</span>依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版《杰普隐私政策》已上线，将更有利于保护您的个人隐私。</div>
	<div class="login_bg row">
		<div class="login_body col-md-7 column">
			<img src="images/bg_login.png">
		</div>
		<div class="login_box col-md-3 column">
			<h1>账号登录</h1>
			<h2>
				<c:if test="${sessionScope.login_msg == null}">
					公共场所请不要泄露您的密码，以防止账号丢失
				</c:if>${sessionScope.login_msg}
			</h2>
			<c:remove var="login_msg" scope="session"/>
			<form action="login" class="form-horizontal" role="from" method="post">
				
				<div class=" form-group">
					<div class="input-group ">
						<span class="input-group-addon glyphicon glyphicon-user"></span> <input type="text" name="name"
						placeholder="邮箱/用户名/已验证手机号" class="form-control" />
					</div>
				</div>

				<div class="form-group ">
					<div class="input-group ">
						<span class="input-group-addon  	glyphicon glyphicon-lock"></span> <input type="password"
						name="password" placeholder="请输入密码" class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<input type="submit" value="登录" class="btn btn-success btn-login" />

					</div>
				</div>
				<div class="treg">

					<a  href="register">&nbsp;立即注册</a>
					<span class=" 	glyphicon glyphicon-hand-right"></span>
				</div>
			</form>
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