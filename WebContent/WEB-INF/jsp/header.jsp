<!--Main Navigation-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<header>
	<c:set var="contextPath">${pageContext.request.contextPath}</c:set>
	<c:set var="pagePath">${pageContext.request.servletPath}</c:set>
	<div id="topheader">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Weeaboo</a>
				</div>
				<ul class="nav navbar-nav">
					<!--Home-->
					<c:choose>
						<c:when test="${fn:indexOf(pagePath,'home')!= -1}">
							<li class="active"><a href="${contextPath}/home">Home</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath}/home">Home</a></li>
						</c:otherwise>
					</c:choose>
					<!--Home-->
					<!--AnimeVoteForYourWaiFu-->
					<c:choose>
						<c:when test="${fn:indexOf(pagePath,'puellaMagi')!= -1}">
							<li class="active"><a href="${contextPath}/puellaMagi/index">AnimeVoteForYourWaiFu</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath}/puellaMagi/index">AnimeVoteForYourWaiFu</a></li>
						</c:otherwise>
					</c:choose>
					<!--AnimeVoteForYourWaiFu-->
					<!--Forum-->
					<c:choose>
						<c:when test="${fn:indexOf(pagePath,'Topic')!= -1}">
							<li class="active"><a href="${contextPath}/Topic/index">Forum</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${contextPath}/Topic/index">Forum</a></li>
						</c:otherwise>
					</c:choose>
					<!--Forum-->
					<li><a href="#3">Page 3</a></li>
					<li><a href="#4">Page 4</a></li>
					<li><a href="#5">Page 5</a></li>
					<li><a href="#6">Page 6</a></li>
					<c:if test="${empty userToken}">
						<li><a href="#" data-toggle="modal" id="loginTrigger"
							data-target="#login"><span class="glyphicon glyphicon-log-in">登入</span></a></li>
						<li><a href="#" data-toggle="modal" id="registerTrigger"
							data-target="#register"><span
								class="glyphicon glyphicon-user">註冊</span></a></li>
					</c:if>
					<c:if test="${not empty userToken}">
						<li><p class="navbar-text">
								<a href="${contextPath}/User/${sessionScope.username}">${sessionScope.username}</a>
							</p></li>
						<li><p class="navbar-text">
								<a href="${contextPath}/settings"><span
									class="glyphicon glyphicon-user">設定</span></a>
							</p></li>
						<li><a href="${contextPath}/signout"><span
								class="glyphicon glyphicon-log-in">登出</span></a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>
</header>

<!--會員登入-->
<div class="modal fade" id="login" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<%@include file="login.jsp"%>
		</div>
	</div>
</div>
<!--會員登入-->

<!--會員註冊-->
<div class="modal fade" id="register" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<%@include file="register.jsp"%>
		</div>
	</div>
</div>
<!--會員註冊-->

<!--Main Navigation-->

<script>
$(document).ready(
		function() {
			$('#topheader .navbar-nav a').on(
					'click',
					function() {
						$('#topheader .navbar-nav').find('li.active')
								.removeClass('active');
						$(this).parent('li').addClass('active');
					});
		});
</script>
