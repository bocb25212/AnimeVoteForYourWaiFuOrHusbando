<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath">${pageContext.request.contextPath}</c:set>  
<html>
<head>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css">
    
    <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
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
  <div class="panel panel-default">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">登入</h3>
    </div>
    <div class="panel-body">

        <div class="form-group" style="width: 40%;">
            <label for="username">用戶名稱</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="請輸入使用名稱" required="required">
        </div>
        <div class="form-group" style="width: 40%;">
            <label for="password">密碼</label>
            <input type="password" class="form-control" id="passwd" name="password" placeholder="請輸入密碼" required="required">
        </div>

        <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
            <button id="loginButton" class="btn btn-default" style="margin-left: 17%">登入</button>
    </div>
</div>
<script type="text/javascript">

$("#id").keyup(
        function () {
            if(isNaN($("#id").val())){
                $("#info").text("提示:帳號只能為數字");
            }
            else {
                $("#info").text("");
            }
        }
    )
  
    $("#loginButton").click(function () {
        var id =$("#username").val();
        var passwd=$("#passwd").val();
        if( id=='' && passwd==''){
            $("#info").text("提示:帳號和密碼不能為空");
        }
        else if ( id ==''){
            $("#info").text("提示:帳號不能為空");
        }
        else if( passwd ==''){
            $("#info").text("提示:密碼不能為空");
        }
        else {
            $.ajax({
                type: "POST",
                url: "/ssm/api/loginCheck",
                data: {
                    username:id ,
                    password: passwd
                },
                dataType: "json",
                success: function(data) {
                    if(data.stateCode.trim() == "0") {
                        $("#info").text("提示:帳號不存在!");
                    } else if(data.stateCode.trim() == "1") {
                        $("#info").text("提示:密碼錯誤!");
                    } else if(data.stateCode.trim() == "2"){
                        $("#info").text("提示:登入成功，跳轉中...");
                        window.location.reload();
                    }
                }
            });
        }
    })
</script>
</body>
</html>
