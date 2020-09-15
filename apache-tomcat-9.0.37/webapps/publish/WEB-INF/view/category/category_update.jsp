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
			function save() {
				//采用异步保存表单信息
				//获得表单中所填写的数据
				var name = $("#name").val();
				var id = $("#id").val();
				//进行数据的异步发送
				$.ajax({
					//异步提交URL
					url: "update",
					//HTTP请求方式
					type: "post",
					//请求时，所携带的请求参数
					data: {
						"id":id,
						"name": name
					},
					//服务端返回数据格式
					dataType: "text",
					//请求成功之后的回调函数
					success: function(data) {
						if(data == "true") {
							alert("修改成功");
							//关闭模态框
							parent.closeModal();
							//页面跳转到列表页面
							//子页面需要调用父页面方法
							parent.openFrame('category/index');
						}else{
							alert("修改失败！");
						}
					}
				})
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form id="saveForm" role="form">
	
						<table style="border-collapse:separate; border-spacing: 5px;">
							<tr>
								<td>
									<i class=""></i>&nbsp;
									信息类别名称:
								</td>
								<td>
									<input type="text" id="name" name="name" value="${category.name }" class="form-control" style="width: 300px;"/>
									<!-- 对于修改来说，和添加的最大区别在于 此时已经存在主键 -->
									<input type="hidden" id="id" name="id" value="${category.id }"/>
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