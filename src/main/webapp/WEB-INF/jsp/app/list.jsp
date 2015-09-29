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
			window.open('${ctx}/app/'+id+'/edit','_self');
		})
		$(".btn_delete").click(function(){
			var id=$(this).data("id");
			$('<form/>',{action:'${ctx}/app/'+id+'/delete',method:'post'})
			.appendTo($("body"))
			.submit();
		})
		$(".btn_appuser").click(function(){
			var id=$(this).data("id");
			window.open('${ctx}/app/'+id+'/appuser','_self');
		})
	})
	</script>
</head>

<body>
<h1>应用列表</h1>
<%@ include file="/common/message.jsp" %>	
<table border="1">
<thead>
	<tr>
		<th>应用名</th><th>备注</th><th>url</th><th>操作</th><th>用户管理</th>
	</tr>
</thead>
<tbody>

	<c:forEach var="app" items="${apps}">
	<tr>
		<td>${app.name}</td>
		<td>${app.remark}</td>
		<td>${app.url}</td>
		<td>
			<input data-id="${app.id}" class="btn_edit" type="button" value="修改">
			<input data-id="${app.id}" class="btn_delete" type="button" value="删除">
		</td>
		<td>
			<input data-id="${app.id}" class="btn_appuser" type="button" value="应用用户">
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
<a href="<spring:url value="/app/create" />">新增</a>

</body>
</html>