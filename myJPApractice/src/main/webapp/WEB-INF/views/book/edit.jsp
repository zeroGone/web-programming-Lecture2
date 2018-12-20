<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="res/common.css">
<style> .error { color: red; }</style>
</head>
<body>
<div class="container">
  <h1>${ bookModel.id == 0 ? "책 등록" : "책 수정" }</h1>
  <form:form method="post" modelAttribute="bookModel">
    <div class="form-group">
      <label>제목:</label>
      <form:input path="title" class="form-control w100" />
      <form:errors path="title" class="error" />
    </div>
    <div class="form-group">
      <label>저자:</label>
      <form:input path="author" class="form-control w100" />
      <form:errors path="author" class="error" />
    </div> 
    <div class="form-group">
      <label>카테고리</label>
      <form:select path="categoryId" class="form-control w100"
                   itemValue="id" itemLabel="name" items="${ categories }" />
    </div>
    <div class="form-group">
      <label>가격:</label>
      <form:input path="price" class="form-control w100" />
      <form:errors path="price" class="error" />
    </div> 
    <div class="form-group">
      <label>출판사</label>
      <form:select path="publisherId" class="form-control w100"
                   itemValue="id" itemLabel="name" items="${ publishers }" />
    </div>
    <div class="form-inline">
      <label>대여중:</label>
      <form:checkbox path="available" class="form-control w100" />
      <form:errors path="available" class="error" />
    </div> 
    <div id="buttons">
		<button type="submit" class="btn btn-primary">
			<i class="glyphicon glyphicon-user"></i> 저장
		</button>
		<a class="btn btn-default" href="list?${ pagination.queryString }">
      <i class="glyphicon glyphicon-list"></i> 목록으로</a>
	</div>
    
  </form:form>
</div>
</body>
</html>
