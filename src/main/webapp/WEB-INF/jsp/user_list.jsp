<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/common/setting.jsp" %>
	<%@ include file="/common/meta.jsp" %>
	<%@ include file="/common/include.jsp" %>	
	<script type="text/javascript">
	$(function(){
		$(".btn_edit").click(function(){
			var id=$(this).data("id");
			window.open('${ctx}/user_edit?id='+id,'_self');
		})
		$(".btn_changestate").click(function(){
			var id=$(this).data("id");
			var state=$(this).data("state");
			if(state=="on"){
				state="off";
			}else{
				state="on";
			}
			
			$('<form/>',{action:'${ctx}/user_changestate?id='+id,method:'post'})
    		.append($('<input/>',{type:'hidden',name:'state',value:state}))
			.appendTo($("body"))
			.submit();
		})
		$(".btn_password").click(function(){
			var id=$(this).data("id");
			window.open('${ctx}/user_password?id='+id,'_self');
		})
	})
	</script>
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
			<input data-id="${user.fyid}" data-state="${user.state}" class="btn_changestate" type="button" value="启用/禁用">
			<input data-id="${user.fyid}" class="btn_edit" type="button" value="修改用户信息">
			<input data-id="${user.fyid}" class="btn_password" type="button" value="重置密码">
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
<a href="<spring:url value="/user_create" />">新增</a>
<%@ include file="/common/message.jsp" %>	
</body>
</html>