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

<title>更新用户信息</title>

<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image: url("./images/bg.jpg");
	background-repeat: no-repeat;
}

div {
	width: 300px;
	margin: 100px auto;
}
.btn{
display: inline-block;
	margin-left: 20px;
	margin-right: 20px;
}
input{
	display: inline-block;
	margin-bottom: 20px;
	margin-left: 15px;
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
	<div>
		学号:${id} <br><br>
		<form action="dologin!updateInfo">
			<input name="id" type="hidden" value="${id}"> 姓名:<input
				name="name" type="text" value="${name}"><br> 班级:<input
				name="iclass" type="text" value="${iclass}"><br> 性别:<input
				name="sex" type="text" value="${sex}"><br> 住址:<input
				name="iadd" type="text" value="${iadd}"><br> <input
				type="submit" class="btn" value="更新"><input type="reset"
				class="btn" value="重置"> <a href="dologin!toSuccessPage"
				class="back">返回</a>
		</form>
	</div>
</body>
</html>
