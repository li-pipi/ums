<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<a href="save">添加用户</a>
<table>
	<caption>用户信息表</caption>
	<thead>
	<tr>
		<th>主键</th>
		<th>姓名</th>
		<th>手机号码</th>
	</tr>
	</thead>
	<tbody>
	<!-- 循环列表 -->
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.cellphone}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
