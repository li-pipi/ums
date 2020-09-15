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
		<script type="application/javascript" src="../static/js/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="../static/js/bootstrap.min.js"></script>
		<script type="application/javascript">
			function createNew() {
				var url = "info/save";
				parent.openFrame(url);
			}
			
			function showDetail(id) {
				var title = "<i class='fa fa-lightbulb-o'></i>&nbsp;消息类别详情";
				var url = "category/detail?id=" + id;
				parent.openModal(title, url, "500px");
			}
			
			function showUpdate(id) {
				var title = "<i class='fa fa-lightbulb-o'></i>&nbsp;修改消息类别";
				var url = "category/update?id=" + id;
				parent.openModal(title, url, "500px");
			}
			
			function deleteById(id, name) {
				// 产生确认信息
				var flag = confirm("您是否确认删除 " + name + " ？");
				if (flag) {
					// 删除
					$.ajax({
						url: "category/delete",
						type: "post",
						data: {
							"id": id
						},
						dataType: "text",
						success: function (data) {
							if (data == "true") {
								alert("删除成功！");
								// 关闭模态框
								parent.closeModal();
								// 页面跳转到列表页面
								// 子页面需要调用父页面方法
								parent.openFrame('category/index');
							} else {
								alert("删除失败！");
							}
						}
					});
				}
			}
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>
						<i class="fa fa-bookmark"></i>&nbsp;
						信息列表
					</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<a href="javascript:createNew();" class="btn btn-success btn-sm">
						<i class="fa fa-plus"></i>&nbsp;
						发布信息
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-border table-hover">
						<thead>
							<tr>
								<th>序号</th>
								<th>信息类别</th>
								<th>信息标题</th>
								<th>发布人</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<!-- 循环转发的信息列表 -->
							<c:forEach var="info" items="${page.list }" varStatus="s">
								<tr>
									<td>
										${(page.pageNum - 1) * page.pageSize + (s.index + 1) }
									</td>
									<td>${info.category.name }</td>
									<td>${info.title }</td>
									<td>${info.createUser.name }</td>
									<td>${info.createTime }</td>
									<td>
										<a href="javascript:showDetail('${info.id }');" class="btn btn-info btn-xs">
											<i class=""></i>&nbsp;
											详情
										</a>
										<a href="javascript:showUpdate('${info.id }');" class="btn btn-warning btn-xs">
											<i class=""></i>&nbsp;
											修改
										</a>
										<a href="javascript:deleteById('${info.id }', '${info.name }');" class="btn btn-danger btn-xs">
											<i class=""></i>&nbsp;
											删除
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5" align="center">
									<ul class="pagination">
									    <li><a href="index?num=1">&laquo;首页</a></li>
									    <li>
									    	<c:choose>
									    		<c:when test="${page.pageNum == 1 }">
									    			<a href="#">上一页</a>
									    		</c:when>
									    		<c:otherwise>
									    			<a href="index?num=${page.pageNum - 1 }">上一页</a>
									    		</c:otherwise>
									    	</c:choose>
								    	</li>
									    <li>
									    	<a href="#">
										    	当前共查询获得&nbsp;${page.totalCount }&nbsp;条数据，
										    	每页显示&nbsp;${page.pageSize }&nbsp;条，
										    	分为&nbsp;${page.totalPage }&nbsp;页显示，
										    	当前是第&nbsp;${page.pageNum }&nbsp;页
									    	</a>
								    	</li>
									    <li>
									    	<c:choose>
									    		<c:when test="${page.pageNum == page.totalPage }">
									    			<a href="#">下一页</a>
									    		</c:when>
									    		<c:otherwise>
									    			<a href="index?num=${page.pageNum + 1 }">下一页</a>
									    		</c:otherwise>
									    	</c:choose>
								    	</li>
									    <li><a href="user_index.jsp?num=${page.totalPage }">尾页&raquo;</a></li>
									</ul>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>