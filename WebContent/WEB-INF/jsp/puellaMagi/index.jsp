<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<c:set var="contextPath">${pageContext.request.contextPath}</c:set>

<body>
<%@include file="../header.jsp"%>
<%@include file="../leftsidebar.jsp"%>


<div class="container-fluid">
<div class="row">
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