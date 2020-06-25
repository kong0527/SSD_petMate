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
					<th><input type="checkbox" id="checkAll" class="check" /></th>
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
						<td><input type="checkbox" id="box" name ="box" class="check" value="${gpurchaseCart.gpurchase.boardNum}"/></td>
						<td ><img src="resources/img/love.png" border="0"> &nbsp;
						${gpurchaseCart.gpurchase.boardTitle}</td>
						<td>${gpurchaseCart.gpurchase.price}</td>
						<td>1</td>
						<td>${gpurchaseCart.gpurchase.boardNum} ${gpurchaseCart.gpurchase.price}</td>
						<td><input type="hidden" name="price" value="${gpurchaseCart.gpurchase.price}" />
						<td><a href="<c:url value="/gpurchaseCartDelete">
						<c:param name="boardNum" value="${gpurchaseCart.gpurchase.boardNum}"/>
						</c:url>"><input type="submit" class = "btn" value="x" /></a></td>
						<!-- <td><button type="submit" formaction="gpurchaseCartDelete" class="btn">x</button></td> -->
					</tr>
				</c:forEach>
				<%-- <c:forEach var="gpurchaseCart" items="${gpurchaseCartList}">
				<form:form modelAttribute="gpurchaseCart">
					<tr>
						<td><input type="checkbox" id="box" name="box" class="check" value="${gpurchaseCart.gpurchase.boardNum}"/></td>
						<td ><img src="resources/img/love.png" border="0"> &nbsp;
						${gpurchaseCart.gpurchase.boardTitle}</td>
						<td>${gpurchaseCart.gpurchase.price}</td>
						<td>1</td>
						<td>${gpurchaseCart.gpurchase.price}</td>
						<td><input type="hidden" name="price" value="${gpurchaseCart.gpurchase.price}" />
						<td><a href="<c:url value="/gpurchaseCartDelete">
						<c:param name="boardNum" value="${gpurchaseCart.gpurchase.boardNum}"/>
						</c:url>"><input type="submit" class = "btn" value="x" /></a></td>
						<!-- <td><button type="submit" formaction="gpurchaseCartDelete" class="btn">x</button></td> -->
					</tr>
				</form:form>
				</c:forEach> --%>
			</tbody>
		</table>

		<table class="text-right" align="right">
			<tr>
				<td>총상품금액</td>
				<td>&nbsp;</td>
				<td id="totalPrice">0₩</td>
			</tr>
			<tr>
				<td>배송비</td>
				<td>&nbsp;</td>
				<td>2500₩</td>
			</tr>
			<tr>
				<td>결제예상금액</td>
				<td>&nbsp;</td>
				<td id="expectPrice">2500₩</td>
			</tr>
			<tr>
				<td><input type="button" id="uncheck" value="cancle" class="btn" /></td>
				<td>&nbsp;</td>
				<td><button type="button" id="btnOrder" name ="btnOrder" class="btn">order</button></td>
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

<script>

<<<<<<< HEAD
	 $(document).on("click","#btnOrder", function() {
=======

	$(document).on("click","#btnOrder", function() {
>>>>>>> branch 'develop' of https://github.com/hjyeon-n/SSD_petMate.git
	  	var checkArr = new Array();     // 배열 초기화
	  	var price = 0;
	    $('#box:checked').each(function(i){
	        checkArr.push($(this).val());  // 체크된 것만 값을 뽑아서 배열에 push
	    });
<<<<<<< HEAD

=======
>>>>>>> branch 'develop' of https://github.com/hjyeon-n/SSD_petMate.git
	    price = $("#expectPrice").val();
	    
	    $.ajax({
	        url: '${pageContext.request.contextPath}/gpurchaseCartToOrder',
	        type: 'post',
	        data: { gpurchaseCartList : checkArr,
		        	price : price },
	    	success : function(result) {
				alert(result);
				location.href = "${pageContext.request.contextPath}/gpurchaseOrderForm";
			}
	    });
<<<<<<< HEAD
	 });
=======
	   
	});

>>>>>>> branch 'develop' of https://github.com/hjyeon-n/SSD_petMate.git

	/* $(document).on("click","#btnOrder", function() {

		var chk = $('input[type="checkbox"]').is(':checked');

		if (chk == true) { // 그 i 번째 input text의 값을 가져온다.
			fabric_seq = $('input[type="checkbox"]').val();
			alert(fabric_seq);
		}
	}); */

	/* $(document).on('change', '#box', function(e){
		e.preventDefault();
		var val = "";
		$("#box").each(function() {
			if($('#box').is(":checked"))
				val += $("#box").val();
		});
		alert(val);	
	}); */
	
	   $(document).ready(function() {

		  // 체크 박스 해제
		$("#uncheck").on('click', function() {
			$(".check").each(function() {
				if($(this).is(":checked"))
					$(".check").prop("checked", false);
			});
		});

		 //체크 박스 모두 선택
		$("#checkAll").change(function () {
		    $('.check').prop("checked", $(this).prop("checked"));
		});  
		
		 //체크 박스 선택 시 가격 변경
		$(".check").change(function() {
			var html = 0;
			var html2 = 0;
			for (var i = 1; i < $('table tr').size(); i++) {
				var fabric_seq = 0;
				// table 중 tr이 i번째 있는 자식중에 체크박스가 체크중이면
				var chk = $('table tr').eq(i).children().find('input[type="checkbox"]').is(':checked');

				if (chk == true) { // 그 i 번째 input text의 값을 가져온다.
					fabric_seq = parseInt($('table tr').eq(i).find('input[name=price]').val());
				}
				html += fabric_seq;
				html2 = html + 2500;
				$("#expectPrice").val(html2);
				$("#totalPrice").html(html + '₩');
				$("#expectPrice").html(html2 + '₩');
				}
		  });

		 
	 });

	  /* function cartList(){
			var checkArr = [];     // 배열 초기화
			    $('input:[name="box"]:checked').each(function(i)) {
			        checkArr.push($(this).val());     // 체크된 것만 값을 뽑아서 배열에 push
			    } 
			    alert("c");
			    $.ajax({
			        url: '${pageContext.request.contextPath}/gpurchaseOrderForm',
			        type: 'post',
			        dataType: 'text',
			        data: gpurchaseCartList : checkArr
			    });
	}*/

		
</script>