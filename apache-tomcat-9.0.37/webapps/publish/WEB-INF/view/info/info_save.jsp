<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../static/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="../static/css/AdminLTE.min.css">
		<link rel="stylesheet" type="text/css" href="../static/bootstrap-fileinput/css/fileinput.min.css">
		<script type="application/javascript" src="../static/js/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="../static/js/bootstrap.min.js"></script>
		<script type="application/javascript" src="../static/wangeditor/wangEditor.min.js"></script>
		<script type="application/javascript" src="../static/bootstrap-fileinput/js/fileinput.min.js"></script>
		<script type="application/javascript" src="../static/bootstrap-fileinput/js/locales/zh.js"></script>
		<script type="application/javascript">
			$(function() {
				var E = window.wangEditor
		        editor = new E('#editor')
		        // 或者 var editor = new E( document.getElementById('editor') )
				// 配置服务器端地址
			    editor.customConfig.uploadImgServer = "/file/upload";
			    editor.customConfig.uploadFileName = 'uploadFile';
			    editor.create();
			});
			
			$(function() {
				$("#upload").fileinput({
					uploadUrl: '/publish/file/upload',
			        allowedFileExtensions: ['jpg', 'png', 'gif']
				}).on('fileuploaded', function (event, data) {
					// 将获得的图片路径设定到对应的隐藏域
					$("#subImage").val(data.response);
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form id="saveForm" role="form">
						<table style="border-collapse: separate; border-spacing: 5px;">
							<tr>
								<td>
									<i class=""></i>&nbsp;
									信息类别：
								</td>
								<td>
									<select id="categoryId" name="categoryId" class="form-control" style="width: 300px;">
										<!-- 循环转发的 categoryList 形成 option -->
										<c:forEach var="category" items="${categoryList }">
											<option value="${category.id }">${category.name }</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									信息标题：
								</td>
								<td>
									<input type="text" id="title" name="title" class="form-control" style="width: 300px;" placeholder="请填写信息标题"/>
								</td>
							</tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									信息图片：
								</td>
								<td>
									<input type="file" id="upload" name="upload" class="form-control" style="width: 300px;" placeholder=""/>
									<input type="hidden" id="subImage" name="subImage"/>
								</td>
							</tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									消息内容：
								</td>
								<td>
									<div id="editor"></div>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="right">
									<a href="javascript:save();" class="btn btn-success btn-sm">
										<i class="fa fa-disk"></i>&nbsp;
										保存
									</a>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>