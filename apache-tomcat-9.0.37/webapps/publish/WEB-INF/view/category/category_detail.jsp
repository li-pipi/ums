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
									<input type="text" value="${category.name }" class="form-control" style="width: 300px;" disabled/>
								</td>
							</tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									创建人:
								</td>
								<td>
									<input type="text" value="${category.createUser.name }" class="form-control" style="width: 300px;" disabled/>
								</td>
							</tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									创建时间:
								</td>
								<td>
									<input type="text" value="${category.createTime }" class="form-control" style="width: 300px;" disabled/>
								</td>
							</tr>
							<tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									修改人:
								</td>
								<td>
									<input type="text" value="${category.updateUser.name }" class="form-control" style="width: 300px;" disabled/>
								</td>
							</tr>
							<tr>
								<td>
									<i class=""></i>&nbsp;
									修改时间:
								</td>
								<td>
									<input type="text" value="${category.updateTime }" class="form-control" style="width: 300px;" disabled/>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="right">
									<a href="javascript:parent.closeModal();" class="btn btn-success btn-sm">
										<i class="fa fa-disk"></i>&nbsp;
										返回
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