<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<div class="container">
  <h1><!--- ${ board.boardName }--->책 목록</h1>
  <form:form method="get" modelAttribute="pagination" class="form-inline mb5">
    <form:hidden path="pg" value="1" />
    <span>순서:</span>
    <form:select path="ob" class="form-control autosubmit"
                 itemValue="value" itemLabel="label" items="${ orderBy }" />    
    <form:select path="sb" class="form-control ml30"
                 itemValue="value" itemLabel="label" items="${ searchBy }" />
    <form:input path="st" class="form-control" placeholder="검색문자열" />
    <button type="submit" class="btn btn-default">
      <i class="glyphicon glyphicon-search"></i> 검색</button>
    <c:if test="${ pagination.sb > 0 || pagination.ob > 0}">
      <a class="btn btn-default" href="list?pg=1">
        <i class="glyphicon glyphicon-ban-circle"></i> 검색취소</a>
    </c:if>
    <span class="ml30">페이지 크기:</span>
    <form:select path="sz" class="form-control autosubmit">
       <form:option value="10"/><form:option value="15"/><form:option value="30"/>     
    </form:select>    
    <div class="pull-right">
      <a class="btn btn-primary" href="create?${pagination.queryString}">
        <i class="glyphicon glyphicon-plus"></i> 책 등록</a>
    </div>    
  </form:form>
  <table id="books" class="table table-bordered">
    <thead>
      <tr class="text-center">
        <th style="width:80px;">id</th>
        <th>제목</th>
        <th style="width:150px;">저자</th>
        <th style="width:150px;">카테고리</th>
        <th style="width:150px;">가격</th>
        <th style="width:150px;">출판사</th>
        <th style="width:150px;">대여여부</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ list }">
        <tr data-url="view?id=${book.id}&${ pagination.queryString }">
          <td class="text-center">${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <!--  <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ article.writeTime }" /></td>-->
          <td>${ book.category.name }</td>
          <td>${ book.price }</td>
          <td>${ book.publisher.name }</td>
          <td>${ book.available }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <my:pagination pageSize="${ pagination.sz }" recordCount="${ pagination.recordCount }" 
                 queryStringName="pg" />
</div>
</body>
</html>
