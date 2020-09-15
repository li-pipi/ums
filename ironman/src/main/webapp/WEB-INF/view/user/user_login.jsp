<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
	<meta charset="utf-8">
	<title>登录界面</title>
	<link rel="stylesheet" href="../static/css/reset.css" />
	<link rel="stylesheet" href="../static/css/common.css" />
	<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
	<script type="text/javascript" src="../static/js/jquery.min.js" ></script>
	<script type="text/javascript" src="../static/js/common.js" ></script>
</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
			<div class="logo"></div>
			<div class="login_box">
			<div class="login_form">
				<div class="login_title">
					<a href="#"><b>超级玛丽Skr</b></a>
				</div>
				<form action="login" method="post" id="loginForm">
					<div class="form_text_ipt">
						<input name="username" type="text" placeholder="请输入您的手机号">
					</div>
					<div class="ececk_warning"><span>手机号不能为空</span></div>
					<div class="form_text_ipt">
						<input name="password" type="password" placeholder="请输入您的密码">
					</div>
					<div class="ececk_warning"><span>密码不能为空</span></div>
					<div class="form_btn">
						<button type="submit" onclick="javascript:window.location.href='#'">登录</button>
						<div class="right check_right">
							<a href="#">忘记密码</a>
						</div>
					</div>
					<div class="form_reg_btn">
						<p id="result" style="color: red;text-align: center"></p>
					</div>
				</form>
				<div class="other_login">
					<div class="left other_left">

					</div>
					<div class="right other_right">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
			<div style="text-align:center;">
		</div>
	</body>
</html>
