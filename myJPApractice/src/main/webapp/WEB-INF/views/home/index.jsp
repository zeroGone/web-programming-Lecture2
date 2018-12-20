<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<h1>췍언더코리안</h1>
		<hr />

		<h2>apis</h2>
		<a href="api/books" class="btn btn-default">books</a> <a
			href="api/categories" class="btn btn-default">categories</a> <a
			href="api/publishers" class="btn btn-default">publishers</a>

		<h2>jpql</h2>
		<form action="api/jpql">
			<textarea name="s" rows=10 cols=100></textarea>
			<br />
			<button type="submit">실행</button>
		</form>
		</hr>

		<h2>Pagination</h2>
		<hr />
		<a href="book/list" class="btn btn-default">책목록</a>
	</div>
</body>
</html>
