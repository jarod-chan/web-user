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
		$(".btn_delete").click(function(){
			var id=$(this).data("id");
			$('<form/>',{action:'${ctx}/app/'+id+'/user//delete',method:'post'})
			.appendTo($("body"))
			.submit();
		})
	})
	</script>
</head>

<body>
<h1>应用用户列表</h1>
<%@ include file="/common/message.jsp" %>	
<table border="1">
<thead>
	<tr>
		<th>用户名</th><th>姓名</th><th>操作</th>
	</tr>
</thead>
<tbody>

	<c:forEach var="user" items="${users}">
	<tr>
		<td>${user.uname}</td>
		<td>${user.realname}</td>
		<td>
			<input data-id="${user.fyid}" class="btn_delete" type="button" value="删除">
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>

</body>
</html>