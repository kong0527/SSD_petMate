<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="resources/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="resources/vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="resources/css/util.css">
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<div class="section-title">
	<div class="container">
		<span class="caption d-block small">Categories</span>
		<h2>GpurchaseCart</h2>
	</div>
</div>
	<div class="sideContainer d-md-flex align-items-stretch">
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
							<td><input type="hidden" name="price" value="${gpurchaseCart.gpurchase.price}" /></td>
							<td><input type="submit" class = "btn" value="x" onclick="del(${gpurchaseCart.gpurchase.boardNum})" /></td>
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

		<nav id="sidebar">
			<div class="p-4 pt-5">
				<!-- <span style="color:black"><h5>Categories</h5></span> -->
				<ul class="list-unstyled components mb-5">
					<li><a href="#" data-toggle="modal" data-target="#myModal">회원 정보 수정</a></li>
          			<li>
			            <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">내가 쓴 글</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu2">
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			            </ul>
	          		</li>
	          		<li>
			            <a href="#pageSubmenu3" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">내가 쓴 댓글</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu3">
			                <li><a href="myCommentInquiry"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			                <li><a href="myCommentInfo"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="myCommentGpurchase"><span class="fa fa-chevron-right mr-2"></span>공구 게시판</a></li>
			                <li><a href="myCommentSecondhand"><span class="fa fa-chevron-right mr-2"></span>중고 게시판</a></li>
			                <li><a href="myCommentPetsitter"><span class="fa fa-chevron-right mr-2"></span>구인 게시판</a></li>
			                <li><a href="myCommentReview"><span class="fa fa-chevron-right mr-2"></span>리뷰 게시판</a></li>
			            </ul>
	          		</li>
	          		<li>
			            <a href="#pageSubmenu4" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">북마크</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu4">
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			            </ul>
	          		</li>
	          		<li><a href="myOrderList">내 주문 내역</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
<!-- Modal HTML -->
<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">				
				<h4 class="modal-title">비밀번호 확인</h4>
			</div>
			<div class="modal-body">
				<form method="post"
				class="login100-form validate-form flex-sb flex-w">
					<!-- <span class="login100-form-title p-b-32"> Account Login </span>  -->
					<span class="txt1 p-b-11"> 
						비밀번호 
					</span>
					<div class="wrap-input100 validate-input m-b-36">
						<input type="password" id="pwd" name="pwd" class="input100"/>
						<span class="focus-input100"></span>
					</div>
					<span class="txt1 p-b-11"> 
						비밀번호 확인
					</span>
					<div class="wrap-input100 validate-input m-b-36">
						<input type="password" id="confirmPwd" name="confirmPwd" class="input100"/>
						<span class="focus-input100"></span>
					</div>
					<div class="container-login100-form-btn">
						<button type="submit" value="확인"
								class="login100-form-btn" id="btnConfirm" name="btnConfirm">확인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>  
<script>
	
	$("#btnConfirm").on("click", function(){
		var pass1 = $("#pwd").val();
		var pass2 = $("#confirmPwd").val();
		alert(pass1);
		alert(pass2);
		if(pass1 != pass2) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#confirmPwd").focus();
			return false;
		}
		var confirmPwd = $("#pwd").val();
		$.ajax({
	        url : '${pageContext.request.contextPath}/confirmPwd',
	        type : 'post',
	        data : {'confirmPwd' : confirmPwd},
	        success : function(data){
	        	if (data == 1) {
	        		location.href="${pageContext.request.contextPath}/signUp";
	        	}
	        	else {
	        		alert('비밀번호가 틀렸습니다.');
		        }
	        }
	    });
	});

	$(document).on("click","#btnOrder", function() {
	  	var checkArr = new Array();     // 배열 초기화
	  	var price = 0;
	    $('#box:checked').each(function(i){
	        checkArr.push($(this).val());  // 체크된 것만 값을 뽑아서 배열에 push
	    });

	    if(checkArr == "" || checkArr == null || checkArr == undefined || (checkArr != null && typeof checkArr == "object" && !Object.keys(checkArr).length)){
		   alert("담은 상품이 없습니다.");
		   return;
		}
		
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
	});
	
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


	function del(boardNum) {
		var chk = confirm("해당 상품을 삭제하시겠습니까?");
		if (chk) {
			location.href='gpurchaseCartDelete?boardNum='+boardNum;
		}
	}
	

</script>