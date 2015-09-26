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
<h1>用户新增</h1>
<form action="${ctx}/user_create" method="post">
用户名：
<input type="text" name="uname" ><br/>
邮箱：
<input type="text" name="uemail" ><br/>
电话：
<input type="text" name="uphone" ><br/>
姓名：
<input type="text" name="realname" ><br/>
初始密码：
<input type="text" name="password" ><br/>

<input type="submit" value="保存"  id="btn_save">
</form>
</body>
</html>
