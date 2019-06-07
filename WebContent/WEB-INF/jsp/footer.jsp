<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
li {
	list-style-type: none;
}

html, body {
	height: 100%;
	font-size: 14px;
	color: #525252;
	font-family: NotoSansHans-Regular, AvenirNext-Regular, arial,
		Hiragino Sans GB, "Microsoft Yahei", "Hiragino Sans GB",
		"WenQuanYi Micro Hei", sans-serif;
	background: #f0f2f5;
}

.footer {
	background-color: #fff;
	margin-top: 22px;
	margin-bottom: 22px;
	width: 100%;
	padding-top: 22px;
	color: #8A8A8A;
	display: block;
	height: 200px;
	border: 1px;
	clear: both
}

.container {
	margin-right: 5%;
	margin-left: 5%;
	padding-left: 15px;
	padding-right: 15px;
	width: 40%;
	float: left;
}

.info {
	margin-right: 5%;
	width: 10%;
	float: left;
}

a {
	color: #8A8A8A;
	cursor: pointer;
}
</style>
</head>
<body>
	<footer class="footer">
		<div class="container">
			這個網站致力於為每個喜歡動漫的夥伴提供一個分享創造、結識新朋友、互助的平台。 <br />
			<br />
			<br />
		</div>
		<div class="info">
			<p style="text-align: center; font-size: 16px;">統計消息</p>
			<c:if test="${not empty usersNum && not empty topicsNum}">
				<ul>
					<li>會員數量: ${usersNum}</li>
					<li>話題數量: ${topicsNum}</li>
				</ul>
			</c:if>
		</div>
		<div class="info">
			<p style="text-align: center; font-size: 16px;">其他連結</p>
			<ul>
				<li><a href="/">Github</a></li>
				<li><a href="/">關於作者</a></li>
				<li><a href="/"></a></li>
			</ul>
		</div>
		<div class="info">
			<p style="text-align: center; font-size: 16px;">其他消息</p>
			<ul>
				<li><a href="/">關於本站</a></li>
				<li><a href="/">聯絡我們</a></li>
			</ul>
		</div>
	</footer>
</body>
</html>