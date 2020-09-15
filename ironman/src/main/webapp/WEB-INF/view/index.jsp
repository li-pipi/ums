<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="static/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="static/adminlte/css/AdminLTE.min.css">
	<link rel="stylesheet" type="text/css" href="static/adminlte/css/ionicons.min.css">
	<link rel="stylesheet" type="text/css" href="static/adminlte/css/skins/_all-skins.min.css">
	<script type="application/javascript" src="static/jquery/jquery-3.5.1.min.js"></script>
	<script type="application/javascript" src="static/jquery-ui/jquery-ui.min.js"></script>
	<script type="application/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
	<script type="application/javascript" src="static/adminlte/js/adminlte.min.js"></script>
	<script type="application/javascript">
		// 打开功能页面
		function openFrame(url) {
			// 获得对应元素位置高度
			var height = $("#contentWrapper").height() - $("#contentHeader").outerHeight(true) - 30;
			var iframe = "<iframe src='" + url + "' style='width: 100%; height: " + height + "; border: 0px;'></iframe>";
			// 将对应的 iframe html 增加到对应的位置
			$("#content").html(iframe);
		}

		// 打开模态框
		function openModal(title, url, width, height) {
			// 设定模态框标题
			$("#myModalHeader").html(title);
			// 设定模态框宽度
			$("#myModalContent").css("width", width);
			// 设定模态框高度
			$("#myModalBody").css("height", height);
			// 设定模态框连接页面
			var iframe = "<iframe src='" + url + "' style='width: 100%; height: 100%; border: 0px;'></iframe>";
			$("#myModalBody").html(iframe);
			$("#myModal").modal({
				keyboard: false
			});
		}

		// 关闭模态框
		function closeModal() {
			$("#myModal").modal("hide");
		}
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<header class="main-header">
		<a href="index2.html" class="logo">
			<span class="logo-mini"><b>招租</b></span>
			<span class="logo-lg"><b>玛丽快递</b></span>
		</a>
		<nav class="navbar navbar-static-top">
			<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
				<span class="sr-only">Toggle navigation</span>
			</a>
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li class="dropdown messages-menu">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="fa fa-user"></i>&nbsp;
							${sessionScope.user.name}
						</a>
					</li>
					<li>
						<a href="user/logout">
							<i class="fa fa-sign-out"></i>&nbsp;
							退出系统
						</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<aside class="main-sidebar">
		<section class="sidebar">
			<div class="user-panel">
				<div class="pull-left image"></div>
				<div class="pull-left info"></div>
			</div>
			<ul class="sidebar-menu" data-widget="tree">
				<li class="header">MAIN NAVIGATION</li>
				<c:forEach var="parent" items="${menuList}">
					<li class="treeview">
						<a href="${parent.url}">
							<i class="${parent.icon}"></i>&nbsp;
							<span>${parent.text}</span>
							<span class="pull-right-container">
		                                <i class="fa fa-angle-left pull-right"></i>
		                            </span>
						</a>
						<ul class="treeview-menu">
							<c:forEach var="child" items="${parent.childList}">
								<li>
									<a href="javascript:openFrame('${child.url}');">
										<i class="${child.icon}"></i>&nbsp;
											${child.text}
									</a>
								</li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</section>
	</aside>
	<div class="content-wrapper" id="contentWrapper">
		<section class="content-header" id="contentHeader">
			<h1>
				广告位招租：19991327983
				<small>Control panel</small>
			</h1>
		</section>
		<section class="content" id="content"></section>
	</div>
	<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.0
		</div>
		<strong>Copyright &copy; 2020-2025 <a href="http://localhost:8080/ironman/index">广告位招租</a>.</strong> All rights
		reserved.
	</footer>
	<div class="control-sidebar-bg"></div>
</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" id="myModalDialog">
			<div class="modal-content" id="myModalContent">
				<div class="modal-header" id="myModalHeader">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body" id="myModalBody"></div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
</body>
</html>
