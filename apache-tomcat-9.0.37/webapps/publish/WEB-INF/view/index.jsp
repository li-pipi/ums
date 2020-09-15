<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="static/css/AdminLTE.min.css">
		<script type="application/javascript" src="static/js/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="static/js/bootstrap.min.js"></script>
		<script type="application/javascript">
			function openFrame(url) {
				var iframe = "<iframe src='" + url + "' style='width: 100%; height: 600px; border: 0px;'></iframe>";
				$("#myFrame").html(iframe);
			}
			
			function openModal(title, url, width, height) {
				// 设定模态框的标题
				$("#myModalLabel").html(title);
				// 修改宽度
				$("#modalContent").css("width", width);
				$("#modalBody").css("height", height);
				// 向主体嵌入页面
				var iframe = "<iframe src='" + url + "' style='width: 100%; height: 100%; border: 0px;'></iframe>";
				$("#modalBody").html(iframe);
				// 打开模态框
				$("#myModal").modal({
					keyboard: false
				});
			}
			
			function closeModal() {
				$("#myModal").modal("hide");
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">此处是 LOGO 广告位招租，招租电话：19991327983</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-default" role="navigation">
					    <div class="container-fluid">
						    <div class="navbar-header">
						        <a class="navbar-brand" href="#">
						        	<i class="fa fa-bullhorn"></i>&nbsp;
						        	小道消息
						        </a>
						    </div>
						    <div>
						        <!--向左对齐-->
						        <ul class="nav navbar-nav navbar-left">
						            <li class="dropdown">
						                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
											<i class="fa fa-bookmark"></i>&nbsp;
											信息管理        
											<b class="caret"></b>       
						                </a>
						                <ul class="dropdown-menu">
						                	<li>
						                		<a href="javascript:openFrame('category/index')">
						                			<i class="fa fa-lightbulb-o"></i>&nbsp;
						                			消息类别
						                		</a>
						                	</li>
						                	<li>
						                		<a href="javascript:openFrame('info/index')">
						                			<i class="fa fa-bookmark"></i>&nbsp;
						                			消息管理
						                		</a>
						                	</li>
						                </ul>
						            </li>
						        </ul>
						        <!--向右对齐-->
						        <ul class="nav navbar-nav navbar-right">
						            <li>
						                <a href="#">
						                    <mark>
						                    	<i class="fa fa-user"></i>&nbsp;
						                    	${sessionScope.user.name }
						                    </mark>
						                </a>
						            </li>
						            <li>
						                <a href="#">
						                    <i class="fa fa-sign-out"></i>&nbsp;
											退出
						                </a>
						            </li>
						        </ul>
						    </div>
						</div>
					</nav>
				</div>
			</div>
			<div class="row">
				<div id="myFrame" class="col-md-12"></div>
			</div>
		</div>
		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content" id="modalContent">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel"></h4>
		            </div>
		            <div class="modal-body" id="modalBody"></div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
	</body>
</html>