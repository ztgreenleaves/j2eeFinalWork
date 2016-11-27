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
<title>登录窗口</title>

<script type="text/javascript">
	function refresh() {
		document.getElementById('checkImg').src = 'dologin!imgCode?timestamp='
				+ (new Date().getTime().toString(36));
	}
</script>
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image: url("./images/bg.jpg");
	background-repeat: no-repeat;
}

.login {
	width: 300px;
	margin: 100px auto;
}

span {
	display: inline-block;
	width: 70px;
}

label {
	font-size: 12px;
	color: gray;
}

img {
	display: inline-block;
	vertical-align: middle;
}

.btn {
	display: inline-block;
	margin-right: 25px;
	margin-left: 45px;
}

input {
	margin: 10px auto;
}
h3{
	padding-left: 70px;
}
</style>

</head>

<body>

	<%
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<div class="login">
	<h3>欢迎登录</h3>
		<form action="dologin">
			<span>账号:</span><input name="id" type="text"><br> <span>密码:</span><input
				name="password" type="password"><br> <span>验证码:</span><input
				name="code" type="text" size="4"> <img src="dologin!imgCode"
				id="checkImg" onClick="refresh();return false"> <label>点击刷新</label><br>
			<input class="btn" type="submit" value="提交"><input
				class="btn" type="reset" value="重置">
		</form>
	</div>
</body>
</html>
