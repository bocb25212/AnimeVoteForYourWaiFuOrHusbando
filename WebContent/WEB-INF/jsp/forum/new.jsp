<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>  
<head>
    <meta charset="UTF-8">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>發新文章 › Sean </title>
</head>
<body>

<%@ include file="../header.jsp"%>

    <div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="${contextPath}/Topic/index">回首頁</a> › 發新文章
        </div>

        <div class="panel-body">
            <form action="${contextPath}/Topic/topic/add" method="post" id="replyForm">
                <div class="form-group">
                    <label for="title">標題</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="請輸入標題" required="required">
                </div>
                <div class="form-group">
                    <label for="content">內容</label>
                    <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                </div>

                <div class="form-group">
                    <label for="tab">選單</label><br/>
                    <div class="col-sm-10" style="width: 40%">
                        <select class="form-control" id="tab" name="tab">
                            <c:forEach items="${tabs}" var="tab">
                            <option value="${tab.id}">${tab.tabName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div><br/>
                <input type="submit" class="btn btn-default btn-sm" value="發布主題">

            </form>
        </div>

    </div>



</div>


    <div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
        <div class="panel-heading" style="background-color: white;text-align: center">
            發文提示
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                <h5>主標題</h5>
                <p>
                    請在標題中描述重點。
                </p>
            </li>

            <li class="list-group-item">
                <h5>內容</h5>
                <p>
                    請清楚表達所要說明的內容。
                </p>
            </li>
        </ul>
    </div>


    <div class="panel panel-default" id="sidebar1" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        論壇應遵守原則
    </div>
    <ul class="list-group" style="width: 100%">
        <li class="list-group-item">
            <h5>尊重原創內容</h5>
            <p>
                本網站僅供學習使用,非商業用途,請尊重原創。
            </p>
        </li>

        <li class="list-group-item">
            <h5>友好互助</h5>
            <p>
                保持對陌生人的友善。用愛去感化他人。
            </p>
        </li>
    </ul>
</div>


<%@ include file="../footer.jsp"%>

<script>
    function submitValidate(flag){
        return flag;
    }
    $("#replyForm").submit(function () {
        if($("#title").val()==''){
            alert("請填寫標题！");
            return submitValidate(false);
        }else {
            var ifSubmit=confirm("確定發表該主題嗎?");
            if (ifSubmit == true){

            }else {
                return submitValidate(false);
            }
        }
    })
</script>
</body>
</html>