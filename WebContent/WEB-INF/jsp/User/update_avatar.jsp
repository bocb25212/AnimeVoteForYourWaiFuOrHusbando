<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>頭像上傳</title>
</head>
<body>

<%@ include file="../header.jsp"%>

<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
           <a href="${contextPath}/Topic/index">回首頁</a>  設定 ›頭像上傳
        </div>

        <div class="panel-body">

            <form  action="${contextPath}/settings/avatar/update" enctype="multipart/form-data" method="post" class="form-horizontal" role="form">
                <div style="margin-left: 17%">
                    <img width="60px" height="60px" src="http://localhost:8080/${user.avatar}" class="img-rounded">
                    <input type="file"  name="avatar" accept="image/png,image/jpeg,image/jpg" >
                    <br/>
                    <input class="btn btn-default" type="submit" value="上傳頭像">
                </div>
            </form>

        </div>

    </div>



</div>


<%@ include file="../side.jsp"%>

<%@ include file="../footer.jsp"%>

</body>
</html>