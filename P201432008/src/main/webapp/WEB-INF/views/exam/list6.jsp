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
  <h1>재고 주문 목록</h1>
  <table id="books" class="table table-bordered">
    <thead>
      <tr class="text-center">
        <th style="width:100px;">id</th>
        <th style="width:400px;">제품명</th>
        <th style="width:300px;">카테고리</th>
        <th style="width:100px; text-align: right">수량</th>
        <th style="width:100px; text-align: right">단가</th>
        <th style="width:200px;">주문날짜</th>
        <th style="width:300px;">주문자</th>
        <th style="width:300px;">공급처</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="purchaseOrderDetail" items="${ list }">
        <tr>
          <td>${ purchaseOrderDetail.id }</td>
          <td>${ purchaseOrderDetail.product.productName }</td>
          <td>${ purchaseOrderDetail.product.category }</td>
          <td style="text-align: right">${ purchaseOrderDetail.quantity }</td>
          <td style="text-align: right">${ purchaseOrderDetail.unitCost }</td>
          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ purchaseOrderDetail.purchaseOrder.submittedDate }" /></td>
          <td>${ String.format("%s, %s", purchaseOrderDetail.purchaseOrder.employee.lastName, purchaseOrderDetail.purchaseOrder.employee.firstName) }</td>
          <td>${ String.format("%s, %s", purchaseOrderDetail.purchaseOrder.supplier.lastName, purchaseOrderDetail.purchaseOrder.supplier.firstName) }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
