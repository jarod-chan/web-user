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
<h1>密码重置</h1>
<form action="${ctx}/user_password/${user.fyid}" method="post">
用户名：
${user.uname}<br/>
密码重置：
<input type="password" name="password"><br/>

<input type="submit" value="保存"  id="btn_save">
</form>
</body>
</html>
