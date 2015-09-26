<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/common/setting.jsp" %>
	<%@ include file="/common/meta.jsp" %>
	<%@ include file="/common/include.jsp" %>	
</head>

<body>
<h1>用户列表</h1>

<table border="1">
<thead>
	<tr>
		<th>用户名</th><th>邮箱</th><th>电话</th><th>姓名</th><th>状态</th><th>操作</th>
	</tr>
</thead>
<tbody>

	<c:forEach var="user" items="${users}">
	<tr>
		<td>${user.uname}</td>
		<td>${user.uemail}</td>
		<td>${user.uphone}</td>
		<td>${user.realname}</td>
		<td>
		<c:if test="${user.state=='on'}">启用</c:if>
		<c:if test="${user.state=='off'}">禁用</c:if>
		</td>
		<td>
			<input data-id="${user.fyid}" class="btn_edit" type="button" value="修改">
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
<a href="<spring:url value="/user_create" />">新增</a>
</body>
</html>