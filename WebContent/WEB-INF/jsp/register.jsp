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
        <h3 class="panel-title">註冊</h3>
    </div>
    <div class="panel-body">
        <form action="${contextPath}/user/add/do" method="post" id="signupForm" class="form-horizontal" role="form" style="margin-left: 5%">
            <div class="form-group" >
                <label class="col-sm-2 control-label">帳號</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="text" class="form-control" id="username" name="username" required="required">
                    <p class="form-control-static">請使用半形的 a-z 或數字 0-9</p>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密碼</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="password" class="form-control" id="password" name="password" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">電子郵件</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="email" class="form-control" id="email" name="email" required="required">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">電話號碼</label>
                <div class="col-sm-10" style="width: 40%;">
                    <select class="form-control" id="areaCode" name="areaCode">
                        <option value="886">+886</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">手機號碼</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="tel" class="form-control" id="tel" name="tel" required="required">
                </div>
            </div>
            <input type="submit" class="btn btn-default" id="signup" style="margin-left: 17%">
        </form>
    </div>
</div>

<script type="text/javascript">


$("#signupForm").submit(function () {
    if($("#username").val()=='' || $("#password").val()==''
    	|| $("#email").val()=='' || $("#tel").val()==''){
        alert("請將註冊填寫完整！");
        return false;
    }else {
    	
    }
})
</script>
</body>
</html>
