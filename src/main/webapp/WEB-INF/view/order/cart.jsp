<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="section-title">
	<div class="container">
		<span class="caption d-block small">Categories</span>
		<h2>Cart</h2>
	</div>
</div>
<div class="sideContainer d-md-flex align-items-stretch">
	<!-- Page Content  -->
	<div id="content" class="p-4 p-md-5 pt-5">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Product</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Total</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="gpurchaseCart" items="${gpurchaseCartList}">
					<tr>
						<td><input type="checkbox" name="gpurchase" value="1" checked /></td>
						<td><img src="resources/img/love.png" border="0"> &nbsp;
						${gpurchaseCart.gpurchase.boardTitle}</td>
						<td>${gpurchaseCart.gpurchase.price}</td>
						<td>1</td>
						<td>${gpurchaseCart.gpurchase.price}</td>
						<td><button type="submit" formaction="cart/delete" class="btn">x</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table class="text-right" align="right">
			<tr>
				<td>총상품금액</td>
				<td>&nbsp;</td>
				<td>25,000₩</td>
			</tr>
			<tr>
				<td>배송비</td>
				<td>&nbsp;</td>
				<td>2500₩</td>
			</tr>
			<tr>
				<td>결제예상금액</td>
				<td>&nbsp;</td>
				<td>27,500₩</td>
			</tr>
			<tr>
				<td><button type="submit" formaction="cart/cancle" class="btn">cancle</button></td>
				<td>&nbsp;</td>
				<td><button type="submit" formaction="cart/cancle" class="btn">order</button></td>
			</tr>
		</table>
		
		
	</div>
	
	<!-- <div class="pagination-row" style="text-align: center;">
			<ul class="custom-pagination list-unstyled">
				<li><a href="#">1</a></li>
				<li class="active"><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">></a></li>
			</ul>
		</div> -->
	<nav id="sidebar">
		<div class="p-4 pt-5">
			<ul class="list-unstyled components mb-5">
				<li><a href="#pageSubmenu1">회원 관리</a></li>
			</ul>
		</div>
	</nav>
</div>
</div>