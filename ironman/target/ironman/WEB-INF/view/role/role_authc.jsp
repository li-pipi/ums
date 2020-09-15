<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Title</title>
		<link rel="stylesheet" type="text/css" href="../../static/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../../static/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="../../static/adminlte/css/AdminLTE.min.css">
		<link rel="stylesheet" type="text/css" href="../../static/ztree/css/zTreeStyle/zTreeStyle.css">
		<script type="application/javascript" src="../../static/jquery/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="../../static/bootstrap/js/bootstrap.min.js"></script>
		<script type="application/javascript" src="../../static/jquery-validation/jquery.validate.min.js"></script>
		<script type="application/javascript" src="../../static/ztree/js/jquery.ztree.all.min.js"></script>
		<script type="application/javascript">
			var setting = {
				view: {
					selectedMulti: false
				},
				check: {
					enable: true
				},
				data: {
					simpleData: {
						enable: true
					}
				},
				callback: {
					onCheck: onCheck
				}
			};

			var clearFlag = false;
			function onCheck(e, treeId, treeNode) {
				count();
				if (clearFlag) {
					clearCheckedOldNodes();
				}
			}
			function clearCheckedOldNodes() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
					nodes = zTree.getChangeCheckedNodes();
				for (var i=0, l=nodes.length; i<l; i++) {
					nodes[i].checkedOld = nodes[i].checked;
				}
			}
			function count() {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
					checkCount = zTree.getCheckedNodes(true).length,
					nocheckCount = zTree.getCheckedNodes(false).length,
					changeCount = zTree.getChangeCheckedNodes().length;
				$("#checkCount").text(checkCount);
				$("#nocheckCount").text(nocheckCount);
				$("#changeCount").text(changeCount);

			}
			$(function () {
				var id = location.href.substring(location.href.lastIndexOf("/") + 1, location.href.length);
				//通过异步方式获得菜单节点
				$.ajax({
					url: "../../menu/authc/" + id,
					type: "get",
					dataType: "json",
					success: function (data) {
						//获取Node 集合
						var zNodes = data.data;
						//加载创建 ztree
						$.fn.zTree.init($("#treeDemo"), setting, zNodes);
						count();
						clearFlag = $("#last").attr("checked");
					}
				});
			});

			//授权
			function authc() {
				var id = location.href.substring(location.href.lastIndexOf("/") + 1, location.href.length);
				//通过异步方式获得菜单节点
				//获得已经勾选的node
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				var nodes = zTree.getCheckedNodes(true);
				//循环节点获得 id
				var nodeIdStrs = "";
				for (var i = 0; i < nodes.length; i++ ) {
					var id = nodes[i].id;
					var nodeIdStrs = nodeIdStrs + id + "-";
				}
				//截取最后的分隔符
				nodeIdStrs = nodeIdStrs.substring(0, nodeIdStrs.length -1);
				//进行异步授权
				$.ajax({
					type: "post",
					data: {
						"nodeIdStrs": nodeIdStrs
					},
					dataType: "json",
					success: function (data) {
						alert(data.data);
						parent.closeModal();
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table>
						<tr>
							<td>
								<ul id="treeDemo" class="ztree"></ul>
							</td>
						</tr>
						<tr>
							<td style="text-align: right">
								<a href="javascript:authc();" class="btn btn-success btn-sm">
									<i class="fa fa-gavel"></i>&nbsp;
									授权
								</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
