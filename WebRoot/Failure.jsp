<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录失败</title>
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image: url("./images/bg.jpg");
	background-repeat: no-repeat;
}

div {
	width: 100px;
	margin: 100px auto;
}
a{
	text-decoration: none;
	color: black;
}
a:hover{
	color:white;
}
</style>
</head>

<body>
	<%
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<div>
		<h3>登录失败</h3> <br><br> <a href="Login.jsp">返回</a>
	</div>
</body>
</html>
