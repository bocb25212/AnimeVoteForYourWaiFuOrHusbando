<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>


<c:if test="${empty userToken}">
	<!-- 未登入 -->
	<div class="panel panel-default" id="sidebar2"
		style="width: 20%; margin: 1% 2% 1% 0%; float: right">
		<div class="panel-heading"
			style="background-color: white; text-align: center">
			一個分享關於動漫的網站</div>
		<ul class="list-group" style="width: 100%">
			<li class="list-group-item"><a href="#" data-toggle="modal"
				id="loginTrigger" data-target="#login"><span
					class="glyphicon glyphicon-log-in">登入</span></a></li>

			<li class="list-group-item"><a href="#" data-toggle="modal"
				id="registerTrigger" data-target="#register"><span
					class="glyphicon glyphicon-user">註冊</span></a></li>
		</ul>
	</div>
</c:if>

<c:if test="${!empty userToken}">
	<!-- 已登入 -->
	<div class="panel panel-default" id="sidebar2"
		style="width: 20%; margin: 1% 2% 1% 0%; float: right">
		<div class="panel-heading"
			style="background-color: white; text-align: center">
			<a href="${contextPath}/User/${user.username}">${user.username}</a>
		</div>
		<ul class="list-group" style="width: 100%">
			<li class="list-group-item"><a href="${contextPath}/forum/new">發新文章</a></li>
			<li class="list-group-item"><a href="">0條未讀訊息</a></li>
			<li class="list-group-item"><a href="">積分:${user.credit}</a></li>
		</ul>
	</div>
</c:if>

<div class="panel panel-default" id="sidebar1"
	style="width: 20%; margin: 1% 2% 1% 0%; float: right">
	<div class="panel-heading"
		style="background-color: white; text-align: center">
		<img width="50px" height="50px" src="http://localhost:8080/hot.png"
			class="img-rounded">熱門話題
	</div>
	<ul class="list-group" style="width: 100%">
		<c:forEach items="${hotestTopics}" var="hotestTopic">
			<li class="list-group-item"><a
				href="${contextPath}//Topic/topic/${hotestTopic.id}">${hotestTopic.title}</a></li>
		</c:forEach>
	</ul>
</div>


