<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${R}res/common.js"></script>
<link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
	<div class="container">
		<h1>책목록</h1>
		<form method="post" class =" form-inline mb5">
			<label>정렬기준</label>
			<select name="orderIndex" class="form-control w100">
				<option value="0" ${ orderIndex.equals("0")?"selected":"" }>ID순</option>
				<option value="1" ${ orderIndex.equals("1")?"selected":"" }>제목순</option>
				<option value="2" ${ orderIndex.equals("2")?"selected":"" }>저자순</option>
				<option value="3" ${ orderIndex.equals("3")?"selected":"" }>카테고리순</option>
				<option value="4" ${ orderIndex.equals("4")?"selected":"" }>가격순</option>
				<option value="5" ${ orderIndex.equals("5")?"selected":"" }>출판사순</option>
			</select>
			<button type="submit" class="btn btn-primary">조회</button>
			<a href="list" class="btn btn-info"> <span
				class="glyphicon glyphicon-user"></span>새로고침
			</a> <a href="create" class="btn btn-info pull-right mb5"> <span
				class="glyphicon glyphicon-user"></span> 책등록
			</a>
		</form>
		<table class="table table-bordered mt5">
			<thead>
				<tr>
					<th>id</th>
					<th>제목</th>
					<th>저자</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>대여여부</th>
					<th>출판사</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ books }">
					<tr data-url="edit?id=${ book.id }">
						<td>${ book.id }</td>
						<td>${ book.title }</td>
						<td>${ book.author }</td>
						<td>${ book.category.categoryName }</td>
						<td>${ book.price }</td>
						<td>${ book.available == true? "O":"X" }</td>
						<td>${ book.publisher.title }</td>
						<td><fmt:formatDate pattern="HH:mm:ss" value="${ book.time }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
