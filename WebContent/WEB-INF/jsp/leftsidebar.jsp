<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>
<c:set var="pagePath">${pageContext.request.servletPath}</c:set>

<div class="col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
   <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">我的最愛</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class=""></a></li>
                <li role="presentation"><a href="#" role="button" class="" data-toggle="modal" data-target=""></a></li>
                <li role="presentation"><a href="#" class="emp_clearall_btn"></a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">功能</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
            <!-- 投票系統 -->
               <c:if test="${fn:indexOf(pagePath,'puellaMagi')!= -1}">
                <li role="presentation"><a href="#" class="">投票訊息</a></li>
                <li role="presentation"><a href="#" class="" data-toggle="modal" data-target="#addAnimeCharacter">投票人物新增</a></li>
               </c:if>
            <!-- 投票系統 --> 
            
            <!-- 首頁文章 -->
               <c:if test="${fn:indexOf(pagePath,'home')!= -1}">
                <li role="presentation"><a href="#">發新文章</a></li>
               </c:if>
            <!-- 首頁文章 -->   
            </ul>
        </li>
    </ul>
</div>

<!-- 新增投票人物-->

<!-- 新增投票人物-->


<script type="text/javascript">
</script>
</body>
</html>
