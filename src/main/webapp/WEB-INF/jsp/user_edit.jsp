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
<h1>用户修改</h1>
<form action="${ctx}/user_edit/${user.fyid}" method="post">
用户名：
<input type="text" name="uname" value="${user.uname}" ><br/>
邮箱：
<input type="text" name="uemail" value="${user.uemail}" ><br/>
电话：
<input type="text" name="uphone" value="${user.uphone}"  ><br/>
姓名：
<input type="text" name="realname" value="${user.realname}"  ><br/>


<input type="submit" value="保存"  id="btn_save">
</form>
</body>
</html>
