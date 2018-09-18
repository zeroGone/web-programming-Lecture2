<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
<%
String select=request.getParameter("select");
if(select==null) select="0";
%>
<div class="container">
  <h1>책목록</h1>
  <form method="post" class="form-inline mp5">
  	<select name="select" class="form-control w100">
  		<option value="0" <%= "0".equals(select) ? "selected" : "" %>>전체</option>
  		<option value="1" <%= "1".equals(select) ? "selected" : "" %>>제목</option>
  		<option value="2" <%= "2".equals(select) ? "selected" : "" %>>카테고리</option>
  	</select>
 	<input name="input" value="${input}" class="form-control w200"/>
  	<button type="submit" class="btn btn-primary">조회</button>
  	
  	
  	<a href="list" class ="btn btn-default">검색취소</a>
  	
  	<a href="create" class="btn btn-info pull-right">
   			<span class="glyphicon glyphicon-user"></span>책등록</a>
  </form>			
  <table class="table table-bordered mt5">
    <thead>
      <tr>
        <th>id</th>
        <th>제목</th>
        <th>저자</th>
        <th>카테고리</th>
        <th>출판사</th>
        <th>가격</th>
        <th>대여가능</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ books }">
        <tr data-url="edit?id=${ book.id }">
          <td>${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <td>${ book.categoryName }</td>
          <td>${ book.publisherTitle }</td>
          <td>${ book.price }</td>
          <td>${ book.available }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
