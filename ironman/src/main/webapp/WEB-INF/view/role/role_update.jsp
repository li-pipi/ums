<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Title</title>
		<link rel="stylesheet" type="text/css" href="../../static/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../../static/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="../../static/adminlte/css/AdminLTE.min.css">
		<script type="application/javascript" src="../../static/jquery/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="../../static/bootstrap/js/bootstrap.min.js"></script>
		<script type="application/javascript" src="../../static/jquery-validation/jquery.validate.min.js"></script>
		<script type="application/javascript">
		// 阻止 submit 同步提交事件
		$.validator.setDefaults({
			submitHandler: function() {
				// 进行表单异步提交
				var formData = $("#myForm").serialize();
				$.ajax({
					url: "../update",
					type: "post",
					data: formData,
					dataType: "json",
					success: function (data) {
						// 产生提示信息
						alert(data.data);
						if (data.result) {
							// 提交成功
							// 进行表格刷新
							parent.openFrame("role/index");
						}
						// 关闭模态框
						parent.closeModal();
					}
				});
			}
		});

		$(function () {
			// 异步获取修改对象信息
			var id = location.href.substring(location.href.lastIndexOf("/") + 1, location.href.length);
			// 根据角色 id 获得角色信息：http://localhost:8080/role/update/id
			$.ajax({
				// http://localhost:8080/role/id
				url: "../" + id,
				type: "get",
				dataType: "json",
				success: function (data) {
					// 获得角色对象
					var role = data.data;
					// 进行信息回填
					$("#id").val(role.id);
					$("#name").val(role.name);
				}
			});

			$("#myForm").validate({
				// 校验规则
				rules: {
					// 使用表单元素的 name 属性值确定对应的表单元素
					name: {
						// 设定相应的校验规则
						// 必填
						required: true,
						rangelength: [2, 6],
						remote: {
							url: "../validate/name",
							type: "post",
							data: {
								"id": function () {
									return $("#id").val();
								},
								"name": function () {
									return $("#name").val();
								}
							},
							dataType: "json"
						}
					}
				},
				// 校验错误信息
				messages: {
					name: {
						required: "请填写角色名称！",
						rangelength: "角色名称为 2 ~ 6 个汉字！",
						remote: "该角色名称已占用！"
					}
				}
			});
		});
	</script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<form id="myForm" role="form">
				<table style="border-collapse: separate; border-spacing: 5px;">
					<tr>
						<td style="text-align: right;">
							<i class="fa fa-id-card-o"></i>&nbsp;
							角色名称：
						</td>
						<td>
							<input type="text" id="name" name="name" class="form-control" style="width: 300px;" placeholder="请填写角色名称">
							<input type="hidden" id="id" name="id"/>
						</td>
						<td>
							<span style="padding: 0px 5px; color: red;">*</span>
						</td>
						<td>
							<label class="error" for="name" style="color: red;"></label>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: right;">
							<button type="submit" class="btn btn-success">
								<i class="fa fa-save"></i>&nbsp;
								保存
							</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>
