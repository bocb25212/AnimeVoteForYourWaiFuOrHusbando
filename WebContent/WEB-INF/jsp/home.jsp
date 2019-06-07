<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>  
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.thumbnail {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.5);
	transition: 0.3s;
	min-width: 40%;
	border-radius: 5px;
}

.thumbnail-description {
	min-height: 40px;
}

.thumbnail:hover {
	cursor: pointer;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 1);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>動漫資訊</title>
</head>
<body>
<%@include file="header.jsp"%>
	<%@include file="leftsidebar.jsp"%>


	<div class="row">
		<div class="col-md-2">&nbsp;</div>
		<div class="col-md-8">
			<div class="row space-16">&nbsp;</div>
			<div class="row">
 <c:forEach items="${articleList}" var="articles">
				<div class="col-sm-4">
					<div class="thumbnail">
						<div class="caption text-center">
							<div class="position-relative">
								<a href="${contextPath}/Article/detail/${articles.id}"><img
									src="http://localhost:8080/${articles.image}"
									style="width: 100%; height: 100%;" /></a>
							</div>
							<h4 id="thumbnail-label">
								<a href="${contextPath}/Article/detail/${articles.id}">${articles.title}</a>
							</h4>
							<p>
								<i class="glyphicon glyphicon-user light-red lighter bigger-120"></i>&nbsp;Author  <a href="${contextPath}/User/home/${articles.userId}">${articles.userId}</a>
							</p>
							<div class="thumbnail-description smaller">${articles.summary}</div>
						</div>
						<div class="caption card-footer text-center">
							<ul class="list-inline">
								<li><i class="people lighter"></i><a href="${contextPath}/Article/detail/${articles.id}"><h4>&nbsp;Read
											More</h4></a></li>
							</ul>
						</div>
					</div>
				</div>
 </c:forEach>
			</div>
			<div class="col-md-2">&nbsp;</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script>
		$(document).ready(function() {
			jQuery.noConflict();
			<c:if test="${not empty notLogin}">
			$("#login").modal();
			</c:if>
		});
	</script>
</body>
</html>