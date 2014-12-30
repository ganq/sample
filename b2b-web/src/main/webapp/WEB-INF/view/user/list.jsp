<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
table {
	width: 90%;
	border-collapse: collapse;
}

table,th,td {
	border: 1px solid blue;
}

th {
	background-color: #00ff00;
}

body * {
	font-size: 12px;
}
</style>
<table>
	<thead>
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>手机号</th>
			<th>地址</th>
			<th>公司ID</th>
			<th>公司名</th>
			<th>公司地址</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.mobile}</td>
				<td>${user.address}</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
