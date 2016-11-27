<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>登录成功</title>
<style type="text/css">
body {
	font-family: "微软雅黑";
	background-image: url("./images/bg.jpg");
	background-repeat: no-repeat;
}

div {
	width: 600px;
	margin: 0 auto;
}

#table table {
	border: 1px solid;
	border-collapse: collapse;
}
.page{
	border-top: 1px solid;
}
.delete,.update {
	text-decoration: none;
	color: white;
	font-family: 宋体;
}
.delete:hover,.update:hover{
color: gray;
}

td {
	width: 100px;
	text-align: center;
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

	<div class="find">
		<br> 登录成功! <br>
		<br>
		<form action="dologin!findById">
			<span>查找学号:</span><input name="id" type="text"> <input
				type="submit" value="查找">
		</form>
		<div class="screen">
			<c:set var="findIdFlag" value="${findIdFlag}"></c:set>
			<c:if test="${findIdFlag == 1}">
				<c:set var="isFindOutFlag" value="${isFindOutFlag}"></c:set>

				<table>
					<c:if test="${isFindOutFlag == 1}">
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>班级</th>
							<th>性别</th>
							<th>住址</th>
							<th colspan="2">操作</th>
						</tr>
						<tr>
							<td>${id}</td>
							<td>${name}</td>
							<td>${iclass}</td>
							<td>${sex}</td>
							<td>${iadd}</td>
							<td><a
								href="dologin!toUpdatePage?id=${id}&name=${name}
						&iclass=${iclass}&sex=${sex}&iadd=${iadd}"
								class="update">编辑</a>
							</td>
							<td><a href="dologin!deleteInfo?id=${id}" class="delete">删除</a>
							</td>
						</tr>
					</c:if>
					<c:if test="${isFindOutFlag==0}">
						<tr>
							<td>${msg}</td>

						</tr>
					</c:if>
				</table>
			</c:if>
		</div>
	</div>
	<div id="table">
		<table>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>班级</th>
				<th>性别</th>
				<th>住址</th>
				<th colspan="2">操作</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.iclass}</td>
					<td>${list.sex}</td>
					<td>${list.iadd}</td>
					<td><a
						href="dologin!toUpdatePage?id=${list.id}&name=${list.name}
						&iclass=${list.iclass}&sex=${list.sex}&iadd=${list.iadd}"
						class="update">编辑</a>
					</td>
					<td><a href="dologin!deleteInfo?id=${list.id}" class="delete">删除</a>
					</td>
				</tr>
			</c:forEach>
			<c:set var="flagUp" value="${flagUp}"></c:set>
			<c:set var="flagBack" value="${flagBack}"></c:set>
			<tr class="page">
				<td ><a href="dologin!divPage?begin_end_pageFlag=1">首页</a>
				</td>
				<td><c:if test="${flagUp == 1}">
						<a href="dologin!divPage?curPage = ${curPage-1}">前一页</a>
					</c:if>
				</td>
				<td><span>当前:${curPage}</span>
				</td>
				<td><c:if test="${flagBack == 1}">
						<a href="dologin!divPage?curPage = ${curPage+1}">后一页</a>
					</c:if></td>
				<td><a href="dologin!divPage?begin_end_pageFlag=0">尾页</a>
				</td>
				<td colspan="2"></td>
			</tr>
		</table>
		<br> <a href="Login.jsp">注销账户</a>
	</div>

</body>
</html>
