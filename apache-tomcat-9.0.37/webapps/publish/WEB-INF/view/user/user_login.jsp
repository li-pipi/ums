
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../static/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="../static/css/AdminLTE.min.css">
		<script type="application/javascript" src="../static/js/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="../static/js/bootstrap.min.js"></script>
		<script type="application/javascript">
			$(function () {
				//获得此时地址栏的URL地址
				var url = location.href;
				var flag = url.contains("flag");
				if(flagIndex > -1){
					//此时的URL时登录失败之后重定向而来的
					//获得此时的失败的标记值，也就是flag的值
					var errorCode = url.substring(url.lastIndexOf("=") + 1, url.length);
					if(errorCode == 0){
						//用户未提交手机号码或者是密码
						$("#error").html("请填写有效的手机号码和登陆密码");
					}else if (errorCode == 1){
						$("#error").html("手机号码或者是密码错误！如仍无法登录，请联系管理员！")
					}
				}else{
					$("#error").html("")
				}
			});
		</script>
	</head>
	<body class="hold-transition login-page">
			<div class="login-box">
		  	<div class="login-logo">
		    	<a href="#"><b>皮皮信息发布系统</b></a>
		  	</div>
			<div class="login-box-body">
				<p class="login-box-msg">Sign in to start your session</p>
		    	<form action="login" method="post">
		      		<div class="form-group has-feedback">
		        		<input type="text" name="cellphone" class="form-control" placeholder="请输入您的手机号码">
		        		<span class="glyphicon glyphicon-phone form-control-feedback"></span>
		      		</div>
		      		<div class="form-group has-feedback">
		        		<input type="password" name="password" class="form-control" placeholder="请输入您的登录密码">
		        		<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		      		</div>
		      		<div class="row">
		        		<div class="col-xs-8">
		          			<div class="checkbox icheck"></div>
		        		</div>
		        		<div class="col-xs-4">
		          			<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
		        		</div>
		      		</div>
		    	</form>
		
		    	<div class="social-auth-links text-center">
		      		<p>
		      			<span id="error" style="color: red;"></span>
		      			<span>系统管理员联系电话：19991327983</span>
		      		</p>
		    	</div>
		
		    	<a href="#">忘记密码...</a><br>
		    	<a href="user_register_form.jsp" class="text-center">没有账号？注册新用户...</a>
		  	</div>
		</div>
	</body>
</html>