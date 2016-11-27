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

<title>介绍</title>
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image: url("./images/bg.jpg");
}
#box{
	margin-left: 100px;
}
span {
	font-size: 15px;
	color: white;
}

.tip {
	display:inline-block;
	margin-left:10px;
	font-size: 12px;
}
div div{
text-align:center;
	float:left;
	border: 3px solid;
	margin: 10 10 10 10;
}
div span{
	color: black;
}
img{
	display:inline-block;
	margin-top:10;
	text-align: center;
}
#infoDesign{
	margin-top:30;
}
.pic1,.pic2{
height: 220px;
margin-right: 50px;
}
.pic3{
	clear: both;
}
.pic4{
	clear:left;
}
.pic4,.pic5{
height: 120px;
float: left;
}
ul{
	list-style-type: none;
}
a{
	text-decoration: none;
	color: black;
}
a:hover{
color: green;
}
</style>
</head>

<body>
	<div id="box">
		<h3>J2EE最后一次作业说明:</h3>
		<p>张腾-软件141-2014122851</p>
		<p>此项目包含:</p>
		<ul>
			<li><a href="Login.jsp">登录界面</a>
			</li>
			<li><a href="Success.jsp">显示界面</a><span class="tip">请勿直接打开</span>
			</li>
			<li><a href="Update.jsp">更新界面</a><span class="tip">请勿直接打开</span>
			</li>
			<li><a href="Failure.jsp">登录失败界面</a>
			</li>
		</ul>
		<h4>数据库结构展示:</h4>
		<div class="pic1">
			<img alt="数据库结构" src="./images/DB.jpg"><br> <span>数据库结构截图</span>
		</div>
		<div class="pic2" >
			<img id = "infoDesign"alt="info表设计" src="./images/infoDesign.png"><br> <span>info表设计截图</span>
		</div>
		<br>
		<div class="pic3">
			<img alt="info表内容" src="./images/infoContent.png"><br> <span>info表内容截图</span>
		</div>
		<br>
		<div class="pic4">
			<img alt="user表设计" src="./images/userDesign.png"><br> <span>user表设计截图</span>
		</div>
		<br>
		<div class="pic5">
			<img alt="user表内容" src="./images/userContent.png"><br> <span>user表内容截图</span>
		</div>
		<br>
	</div>

</body>
</html>
