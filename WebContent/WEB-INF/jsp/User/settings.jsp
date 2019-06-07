<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var="contextPath">${pageContext.request.contextPath}</c:set>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>設定</title>
</head>
<body>

<%@ include file="../header.jsp"%>

<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
          <a href="${contextPath}/Topic/index">回首頁</a>  › 設定
        </div>

        <div class="panel-body">

                <form class="form-horizontal" role="form" >
                    <div style="margin-left: 17%">
                        <img width="60px" height="60px" src="http://localhost:8080/${user.avatar}" class="img-rounded">
                        <a class="btn btn-default" href="${contextPath}/settings/avatar" role="button">更換頭像</a>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">uid</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${user.id}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用戶名稱</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${user.username}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${user.email}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">註冊時間</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${user.localCreateTime}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">積分</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">${user.credit}</p>
                        </div>
                    </div>

                </form>

        </div>

    </div>



</div>

<%@ include file="../side.jsp"%>

<%@ include file="../footer.jsp"%>

</body>
</html>