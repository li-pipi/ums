<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Title</title>
		<link rel="stylesheet" href="../static/css/reset.css" />
		<link rel="stylesheet" href="../static/css/common.css" />
		<link rel="stylesheet" href="../static/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../static/dataTables/css/jquery.dataTables.min.css" />
		<script type="text/javascript" src="../static/js/jquery.min.js" ></script>
		<script type="text/javascript" src="../static/js/common.js" ></script>
		<script type="text/javascript" src="../static/dataTables/js/jquery.dataTables.min.js" ></script>
		<script type="application/javascript">
		$(function () {
			$("#myTable").DataTable({
				searching: false,
				sort: false,
				language: {
					url: "../static/dataTables/i18n/Chinese.json"
				},
				serverSide:true,
				ajax:({
					// 请求地址
					url: "page",
					// 请求方式
					type: "post",
					// 设定在请求列表的时候，所需要携带的请求参数
					data: function(d) {
						// 获得对应的设置信息
						var tableSetings = $("#myTable").dataTable().fnSettings();
						// 删除多余请求参数
						for(var key in d) {
							if(key.indexOf("columns")==0||key.indexOf("order")==0||key.indexOf("search")==0){
								//以columns开头的参数删除
								delete d[key];
							}
						}
						// 扩展请求时候的数据，重点在于pageNum和pageSize
						var params = {
							// 获得表格对象后，
							// 系统当前页码_iDisplayStart，默认从0开始
							"pageNum": tableSetings._iDisplayStart + 1,
							// 每页显示数量
							"pageSize": tableSetings._iDisplayLength
						}
						// 将新增的查询数据扩展到请求参数上
						$.extend(d, params); //给d扩展参数
					},
					// 设定回传的数据格式为JSON
					dataType: "json",
					// 过滤数据
					dataFilter: function(data) {
						data = JSON.parse(data);
						var returnData = {};
						returnData.draw = data.data.draw;
						returnData.recordsTotal = data.data.totalPage;
						returnData.recordsFiltered = data.data.totalPage;
						returnData.data = data.data.list;
						return JSON.stringify(returnData);
					}
				}),
				// 为表格的每一个字段设定具体的值
				columnDefs: [
					{
						targets: 0,
						data: function (row, type, val, meta) {
							// 在序号位置
							var tableSetings = $("#myTable").dataTable().fnSettings();
							var begin = tableSetings._iDisplayStart;
							var size = tableSetings._iDisplayLength;
							return begin * size + begin + 1;
						}
					}, {
						targets: 1,
						data: function (row, type, val, meta) {
							// 对于参数 row，就是列表中的每一个具体的元素
							return row.name;
						}
					}, {
						targets: 2,
						data: function (row, type, val, meta) {
							// 对于参数 row，就是列表中的每一个具体的元素
							var cellphone = row.cellphone;
							return cellphone;
						}
					}, {
						targets: 3,
						data: function (row, type, val, meta) {
							// 对于参数 row，就是列表中的每一个具体的元素
							var role = row.role.name;
							return role;
						}
					}, {
						targets: 4,
						data: function (row, type, val, meta) {
							// 获得此时的状态
							var status = row.status;
							if (status == 0) {
								// 禁用
								return "<i class='fa fa-toggle-off'></i>&nbsp;&nbsp;禁用";
							} else {
								// 启用
								return "<i class='fa fa-toggle-on'></i>&nbsp;&nbsp;启用";
							}
						}
					}, {
						targets: 5,
						data: function (row, type, val, meta) {
							// 修改按钮
							var updateBtn = "<a href='#' class='btn btn-warning btn-xs'><i class='fa fa-wrench'></i>&nbsp;修改</a>";
							// 状态按钮
							var statusBtn = "";
							if (row.status == 0) {
								// 此时用户为禁用，则按钮为启用
								statusBtn = "<a href='javascript:changeStatus(\"" + row.id + "\", \"" + 1 + "\", \"" + row.name + "\");' class='btn btn-success btn-xs'><i class='fa fa-toggle-on'></i>&nbsp;启用</a>";
							} else {
								// 此时用户为启用，则按钮为禁用
								statusBtn = "<a href='javascript:changeStatus(\"" + row.id + "\", \"" + 0 + "\", \"" + row.name + "\");' class='btn btn-danger btn-xs'><i class='fa fa-toggle-off'></i>&nbsp;禁用</a>";
							}
							// 授权
							var detailBtn = "<a href='#' class='btn btn-primary btn-xs'><i class='fa fa-s15'></i>&nbsp;详情</a>";

							//判断用户信息
							//获得当前登录用户角色信息
							var role = ${sessionScope.user.role.id};
							if (role == 1 && role == row.role.id) {
								//此时列表中为该超级管理员自己
								return updateBtn + "&nbsp;&nbsp;" + detailBtn;
							}else if (role == 1 && role != row.role.id) {
								return updateBtn + "&nbsp;&nbsp;" + statusBtn + "&nbsp;&nbsp;" + detailBtn;
							}else if (role != 1 && role == row.role.id) {
								return updateBtn + "&nbsp;&nbsp;" + detailBtn;
							} else if (role != 1 && role != row.role.id && row.role.id == 1) {
								return detailBtn;
							}
							return updateBtn + "&nbsp;&nbsp;" + statusBtn + "&nbsp;&nbsp;" + detailBtn;
						}
					}
				]
			});
		});

		// 改变角色状态
		function changeStatus(id, status, name) {
			var flag = "";
			if (status == 1) {
				// 启用
				flag = confirm("您是否确认要启用用户：" + name + "？");
			} else {
				// 禁用
				flag = confirm("您是否确认要禁用用户：" + name + "？");
			}
			// 判断用户选择
			if (flag) {
				// 进行异步修改
				$.ajax({
					url: "update",
					type: "post",
					data: {
						"id": id,
						"status": status,
					},
					dataType: "json",
					success: function (data) {
						alert(data.data);
						// 刷新表格
						$("#myTable").dataTable().fnDraw();
					}
				});
			}
		}

		// 打开保存模态框
		function openSaveModal() {
			var title = "<h1><i class='fa fa-id-card-o'></i>&nbsp;新增角色信息</h1>";
			var url = "role/save";
			var width = "750px";
			var height = "200px";
			parent.openModal(title, url, width, height);
		}

		// 打开修改模态框
		function openUpdateModal(id) {
			var title = "<h1><i class='fa fa-id-card-o'></i>&nbsp;修改角色信息</h1>";
			var url = "role/update/" + id;
			var width = "750px";
			var height = "200px";
			parent.openModal(title, url, width, height);
		}
	</script>

</head>
<body>
<div class="container" style="margin: 5px;">
	<div class="row" style="margin: 5px 0px;">
		<div class="col-md-12">
			<h1>
				<i class="fa fa-users"></i>&nbsp;
				用户信息
			</h1>
		</div>
	</div>
	<div class="row" style="margin: 5px 0px;">
		<div class="col-md-12">
			<a href="javascript:openSaveModal();" class="btn btn-success btn-sm">
				<i class="fa fa-user-plus"></i>&nbsp;
				新增用户信息
			</a>
		</div>
	</div>
	<div class="row" style="margin: 5px 0px;">
		<div class="col-md-12">
			<table id="myTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>
							<i class="fa fa-list-ol"></i>&nbsp;
							序号
						</th>
						<th>
							<i class="fa fa-user"></i>&nbsp;
							用户姓名
						</th>
						<th>
							<i class="fa fa-tablet"></i>&nbsp;
							手机号码
						</th>
						<th>
							<i class="fa fa-grav"></i>&nbsp;
							用户角色
						</th>
						<th>
							<i class="fa fa-heartbeat"></i>&nbsp;
							状态
						</th>
						<th>
							<i class="fa fa-gamepad"></i>&nbsp;
							操作
						</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
</body>
</html>
