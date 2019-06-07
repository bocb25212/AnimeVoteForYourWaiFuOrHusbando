<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>${topic.title}</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div style="width: 70%; margin: 1% 2% 1% 5%; float: left;">
		<div class="panel panel-default" id="main" style="">
			<div class="panel-heading" style="background-color: white">
				<div>
					<div class="panel-heading" style="background-color: white">
						<a href="${contextPath}/Topic/index">回首頁</a> › 主題
					</div>
					<h3>${topic.title}</h3>
					<br />
					<div>
						<a href="${contextPath}/User/${topic.user.username}"><span><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;
						<small class="text-muted">${topic.localCreateTime}&nbsp;&nbsp;&nbsp;+08:00</small>&nbsp;&nbsp;
						<small class="text-muted">${topic.click}次瀏覽</small>
					</div>
				</div>

				<div style="float: right; margin-top: -100px">
					<img width="50px" height="50px"
						src="http://localhost:8080/${topic.user.avatar}"
						class="img-rounded">
				</div>
			</div>

			<ul class="list-group" style="width: 100%">
				<li class="list-group-item">${topic.content}</li>
			</ul>
		</div>

		<c:if test="${!empty replies}">
			<div class="panel panel-default" id="main" style="">
				<div class="panel-heading" style="background-color: white">
					<span> ${fn:length(replies)} 回覆 | 直到 <c:forEach
							items="${replies}" var="reply" varStatus="status">

							<c:if test="${status.last}">
    ${reply.localCreateTime}
    </c:if>
						</c:forEach>
					</span>
				</div>

				<ul class="list-group" style="width: 100%">
					<!-- 評論 -->
					<c:forEach items="${replies}" var="reply">
						<li class="list-group-item">
							<div style="height: 50px">
								<div style="float: left; width: 6%; margin-bottom: 5px">
									<img width="50px" height="50px"
										src="http://localhost:8080/${reply.user.avatar} "
										class="img-rounded">
								</div>
								<div style="width: 89%; float: left">
									<a href="${contextPath}/User/${reply.user.username}"><strong>${reply.user.username}</strong></a>&nbsp;&nbsp;
									<small class="text-muted">${reply.localCreateTime}</small> <br />
									<div>
										<p>${reply.content}</p>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>

				</ul>
			</div>
		</c:if>



		<div class="panel panel-default" id="main" style="">
			<div class="panel-heading" style="background-color: white">
				增加新回覆</div>
			<div class="panel-body">
				<div class="form-group">
					<form action="${contextPath}/ReplyController/reply/add"
						method="post">
						<input type="hidden" name="topicId" value="${topic.id}"> <input
							type="hidden" name="replyUserId" value="${user.id}">
						<textarea class="form-control" rows="3" name="content"
							required="required"></textarea>
						<br />
						<c:if test="${!empty user}">
							<input type="submit" class="btn btn-default btn-sm" value="回覆">
						</c:if>

						<c:if test="${empty user}">
							<a href="#" data-toggle="modal" id="loginTrigger"
								data-target="#login"><input type="button"
								class="btn btn-default btn-sm" value="登入後才可進行留言"></a>

							<a href="#" data-toggle="modal" id="registerTrigger"
								data-target="#register"><input type="button"
								class="btn btn-default btn-sm" value="註冊"></a>

						</c:if>
					</form>
				</div>

			</div>
		</div>


	</div>

	<%@ include file="../side.jsp"%>


	<%@ include file="../footer.jsp"%>

</body>
</html>