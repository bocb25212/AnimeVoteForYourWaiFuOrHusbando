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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章</title>
</head>
<%@include file="../header.jsp"%>
<body>
				<div class="col-sm-12">
					<div class="thumbnail">
						<div class="caption text-center">
							<div class="position-relative">
								<img
									src="http://localhost:8080/${article.image}"
									style="width: 50%; height: 50%;" />
							</div>
							<h4 id="thumbnail-label">
								<a href="#">${article.title}</a>
							</h4>
							<p>
								<i class="glyphicon glyphicon-user light-red lighter bigger-120"></i>&nbsp;Author  <a href="${contextPath}/User/home/${article.userId}">${article.userId}</a>
							</p>
							<div class="thumbnail-description smaller">${article.summary}</div>
						</div>
						<div class="caption card-footer text-center">
							${article.content}	
						</div>
					</div>
				</div>
<%@ include file="../footer.jsp"%>
</body>
</html>