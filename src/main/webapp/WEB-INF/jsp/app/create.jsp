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
<h1>应用新增</h1>
<form action="${ctx}/app/create" method="post">
应用名：
<input type="text" name="name" ><br/>
备注：
<input type="text" name="remark" ><br/>
url：
<input type="text" name="url" value="http://" ><br/>

<input type="submit" value="保存"  id="btn_save">
</form>
</body>
</html>
