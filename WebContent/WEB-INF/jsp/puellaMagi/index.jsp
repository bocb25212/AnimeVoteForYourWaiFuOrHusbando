<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>

<body>
<%@include file="../header.jsp"%>
<audio controls autoplay loop>
<source src="${contextPath}/Sispuellamagica.mp3" type="audio/mpeg">
<p>If you can read this, your browser does not support the audio element.</p>
</audio>



<div class="container-fluid">
<div class="row">

<div class="col-sm-3" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
   <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">我的最愛</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class="">魔法少女小圓</a></li>
                <li role="presentation"><a href="#" role="button" class="" data-toggle="modal" data-target=""></a></li>
                <li role="presentation"><a href="#" class="emp_clearall_btn"></a></li>
            </ul>
        </li>
    </ul>
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">後台管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="">投票訊息</a></li>
                <li role="presentation"><a href="#" class="" data-toggle="modal" data-target="#addAnimeCharacter">投票人物新增</a></li>
            </ul>
        </li>
    </ul>
</div>

<c:forEach items="${top3AnimeCharacter}" var="item">
<div class="col-sm-3">
<div class="panel panel-primary">
<div class="panel-heading"><h3 style="text-align:center">${item.name}${item.votecount}</h3></div>
<div class="panel-body">
<c:if test="${item.image != null}">
     <img height="40%" width="80%" id="images"  src="http://localhost:8080/${item.image}">
</c:if>
</div>
</div>
</div>
</c:forEach>



<c:forEach items="${animeCharacterList}" var="item">
<div class="col-sm-3">
<div class="panel panel-primary">
<div class="panel-heading"><h3 style="text-align:center">${item.name}${item.votecount}</h3></div>
<div  class="panel-body">
<c:if test="${item.image != null}">
     <img height="40%" width="80%" id="images"  src="http://localhost:8080/${item.image}">
</c:if>
</div>
<form action="../puellaMagi/vote" method="post" id="voteForm">
<div class="panel-footer">
<input type="hidden" name="id" value="${item.id}">
<input type="hidden" name="name" value="${item.name}">
<input type="submit" value="投票" class="btn btn-default btn-block">
</div>
</form>
</div>
</div>
</c:forEach>

</div>
</div>


<!--新增人物-->
<div class="modal fade" id="addAnimeCharacter" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
				<%@include file="addAnimeCharacter.jsp"%>
		</div>
	</div>
</div>
<!--新增人物-->
<%@ include file="../footer.jsp"%>
<script>
	 $("#voteForm").submit(function(e) {
		    var form = $(this);
		    var url = form.attr('action');
		    $.ajax({
		           type: "POST",
		           url: url,
		           data: form.serialize(), // serializes the form's elements.
		           dataType: "html",
		           success: function(data)
		           {	 
		        	   alert(' 投票成功 ');
		        	   window.location.reload();
		           }
		         });
		    e.preventDefault(); // avoid to execute the actual submit of the form.
		});
	 
</script>
</body>
</html>