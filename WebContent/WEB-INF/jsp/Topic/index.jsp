<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>  
<html lang="en">
<head>
    <meta name="keywords" content="Anime,阿宅,動漫,評論">
    <title>Anime - 一個分享動漫社區  </title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        li {list-style-type:none;}
        html, body {
            height: 100%;
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;
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
            border: 1px ;
            clear:both
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
        a{
            color: #8A8A8A;
            cursor: pointer;
        }
    </style>
</head>
<body>

<%@ include file="../header.jsp"%>

<div class="panel panel-default" id="main" style="width: 70%;margin:1% 2% 5% 5%;float: left;">
    <div class="panel-heading" style="background-color: white">
            <a href="${contextPath}/Topic/index" style="margin-right: 2%">全部</a>        
        <a style="margin-right: 2%">活躍</a><a style="margin-right: 2%">精華</a>
        <c:forEach items="${tabList}" var="item">
   		<a href="${contextPath}/Topic/tab/${item.tabNameEn}" style="margin-right: 2%">${item.tabName}</a>        
		</c:forEach>
        
    </div>

<ul class="list-group" style="width: 100%">
    <c:forEach items="${topics}" var="topic">
    <li class="list-group-item">
        <div style="height: 50px">
            <div style="float: left;width: 6%;margin-bottom: 5px">
                <img width="50px" height="50px" src="http://localhost:8080/${topic.user.avatar}" class="img-rounded">
            </div>
            <div style="width: 89%;float: left">
                <a href="${contextPath}/Topic/topic/${topic.id}">${topic.title}</a><br/>
                <div>
                    <a><span class="label label-default" >${topic.tab.tabName}</span></a>&nbsp;&nbsp;&nbsp;
                    <a href="${contextPath}/User/${topic.user.username}"><span ><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;&nbsp;
                    <small class="text-muted">${topic.localCreateTime}</small>
                </div>
            </div>
            <div style="width: 5%;float: right;text-align: center">
                <span class="badge">${topic.countReplies}</span>
            </div>
        </div>
    </li>
    </c:forEach>

</ul>

<div align="center">
		<font size="2">共 ${page.totalPageCount} 頁</font> <font size="2">第
			${page.pageNow} 頁</font> 
			<c:if test="${empty tabPageURL}">
				<a href="${contextPath}/Topic/index?pageNow=1">第一頁</a>
			</c:if>
			<c:if test="${not empty tabPageURL}">
				<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=1">第一頁</a>
			</c:if>
		<c:choose>
			<c:when test="${page.pageNow - 1 > 0}">
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=${page.pageNow - 1}">上一頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
					<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=${page.pageNow - 1}">上一頁</a>
				</c:if>
			</c:when>
			<c:when test="${page.pageNow - 1 <= 0}">
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=1">上一頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
						<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=1">上一頁</a>
				</c:if>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${page.totalPageCount==0}">
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=${page.pageNow}">下一頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
					<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=${page.pageNow}">下一頁</a>
				</c:if>
			</c:when>
			<c:when test="${page.pageNow + 1 < page.totalPageCount}">
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=${page.pageNow + 1}">下一頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
					<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=${page.pageNow + 1}">下一頁</a>
				</c:if>
			</c:when>
			<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=${page.totalPageCount}">下一頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
					<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=${page.totalPageCount}">下一頁</a>
				</c:if>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${page.totalPageCount==0}">
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=${page.pageNow}">最後頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
					<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=${page.pageNow}">最後頁</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${empty tabPageURL}">
					<a href="${contextPath}/Topic/index?pageNow=${page.totalPageCount}">最後頁</a>
				</c:if>
				<c:if test="${not empty tabPageURL}">
					<a href="${contextPath}/Topic/tab/${tabNameEn}?pageNow=${page.totalPageCount}">最後頁</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../side.jsp"%>

<%@ include file="../footer.jsp"%>
</body>
</html>